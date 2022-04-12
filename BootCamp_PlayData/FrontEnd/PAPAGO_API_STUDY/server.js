const express = require('express'); // express 패키지 import

const app = express(express.static('public'));

// API key를 별도로 관리 : dot(.) .env라는 파일에 key를 보관하고,
// dotenv가 .env 파일을 활용해서, process.env 객체에 포함시켜줌

const dotenv = require('dotenv'); // dotenv 패키지 import
dotenv.config();


const clientId = process.env.CLIENT_ID;
const clientSecret = process.env.CLIENT_SECRET;

const request = require('request'); // request 패키지 import

// express의 static
app.use(express.static('public'));
app.use(express.json());

app.get('/', (request, response) => {
    response.sendFile(__dirname, 'index.html'); // 인자 2개 (경로, )
});

// 브라우저로부터 감지할 언어 텍스트를 받아서, 네이버 서버로 요청 및 결과 응답
app.post('/detectLangs', (req, res) => {
    // 127.0.0.1:3000/detectLangs로 요청했을 때
    // console.log('요청 성공');
    // console.log(req.body);
    const {text:query, targetLanguage } = req.body;
    // console.log(query,targetLanguage);
    const url = 'https://openapi.naver.com/v1/papago/detectLangs';
    const options = {
        url, // 네이버 언어 감지 서버의 주소
        form: { query }, // form이라는 property에 우리가 보낼 데이터를 객체 형태로 전송
        headers: {
            "X-Naver-Client-Id": clientId,
            "X-Naver-Client-Secret": clientSecret,

        },
    };
     // request.post('요청에 필요한 데이터 동봉', '요청에 따른 응답 정보 확인하는 콜백함수')
     request.post(options, (error, response, body) => {
        if(! error && response.statusCode === 200) {
            // 응답 성공
            const parsedBody = JSON.parse(body);
            // papago 번역 url로 재 요청 (redirect)
            res.redirect(`translate?lang=${parsedBody['langCode']}&targetLanguage=${targetLanguage}&query=${query}`);
            // localhost:3000/translate?lang=en&targetLanguage=ko&query=hi 같은 느낌
        }
        else {
            console.log(`언어감지 error = ${response.statusCode} 입니다`); // error = 에러코드
        }
     });
     // options에 요청에 필요한 데이터들를 보관
});

// 파파고 번역 요청 부분
app.get('/translate',(req, res) => {
    // lang = 'en'
    // 파파고 번역 url 작성

    const {lang : source, query: text, targetLanguage : target } = req.query;
    console.log(text, source);
    // console.log(query,targetLanguage);
    const url = 'https://openapi.naver.com/v1/papago/n2mt';
    const options = {
        url, // 네이버 언어 감지 서버의 주소
        form: { 
            source, target, text }, // form이라는 property에 우리가 보낼 데이터를 객체 형태로 전송
        headers: {
            "X-Naver-Client-Id": clientId,
            "X-Naver-Client-Secret": clientSecret,
        },
    };

    request.post(options, (error, response, body) => {

        if (!error && response.statusCode == 200) {
            res.setHeader('Content-Type','application/json');
            res.send(body);
            // res.json(body);// stringify() 가 적용된 메서드
          } else {
            res.status(response.statusCode).end();
            console.log('언어 번역 error = ' + response.statusCode);
          }
     });

});

app.listen(3000, () => {
    console.log('http://127.0.0.1:3000/ app listening on port 3000!');
}); // 포트 번호, 콜백 함수