// 변수 네이밍 컨벤션, 도메인과 관련된 용어를 정의
// source : 번역할 텍스트와 관련된 명칭
// target : 번역된 결과와 관련된 명칭
const [sourceTextArea, targetTextArea] = document.getElementsByTagName('textarea');
// console.log(sourceTextArea, targetTextArea);

const [sourceSelect, targetSelect] = document.getElementsByTagName('select');
// console.log(sourceSelect, targetSelect);

// 번역할 언어의 기본 타입(en)
let targetLanguage = 'en';

// 어떤 언어로 번역할 지 선택하는 target selectbox의 option(선택지)의 값이 바뀔 때마다 이벤트가 발생.
targetSelect.addEventListener('change', () => {
    // console.dir(targetSelect);
    const selectedIndex = targetSelect.selectedIndex;
    targetLanguage = targetSelect.options[selectedIndex].value;
});



let debouncer; // 디바운서 선언

sourceTextArea.addEventListener('input', (event) => {

    if (debouncer) {
        // debouncer에 TimeID 값이 있으면 (카운팅 중이면)
        clearTimeout(debouncer); // 현재 타이머 카운트 초기화
    }

    debouncer = setTimeout(() => {
        const text = event.target.value;
        if (text) {
            // 비동기 요청을 도와주는 Web API 객체 생성
            const xhr = new XMLHttpRequest();

            // node 서버의 특정 url 주소
            const url = '/detectLangs';

            xhr.onreadystatechange = () => {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    ;
                    const translateObj = JSON.parse(xhr.responseText);
                    const result = translateObj.message.result;
                    targetTextArea.value = result.translatedText;

                }
            };

            // 요청 준비
            xhr.open('POST', url);

            // Node 서버에 보낼 객체 형태의 JSON 데이터
            const requestData = { // typeof : object
                text,
                targetLanguage,
            };

            xhr.setRequestHeader('Content-type', 'application/json');

            // JSON의 타입은 ? string
            const objectToJSON = JSON.stringify(requestData);

            // 요청 전송
            xhr.send(objectToJSON);
        }
    }, 2 * 1000); // 2초 후 callback 함수 호출
});