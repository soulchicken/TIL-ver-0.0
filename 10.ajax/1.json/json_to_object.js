console.log('test');
const book = {
    title: "노인과 바다",
    author: "헤밍 웨이",
    isSold: false,
    genere: ["소설","비극"],
};

const responseData = JSON.stringify(book);
const bookObj = JSON.parse(responseData);
console.log(bookObj.author);
console.log(bookObj.title);
console.log();

const monster = [
    {id : 1, style: 'bird', attack: '꼬리치기', },
    {id : 2, style: 'snake', attack: '휘감기', },
    {id : 3, style: 'fish', attack: '몸통 박치기', },
];

const responseMonsterData = JSON.stringify(monster); // 백엔드에서 받아왔다고 가정
const monsterObj = JSON.parse(responseMonsterData);
console.log(monsterObj[1]);
