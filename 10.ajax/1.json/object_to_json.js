// JavaScript Object
console.log("test");
const book = {
    title: "노인과 바다",
    author: "헤밍 웨이",
    isSold: false,
    genere: ["소설","비극"],
};

// JSON 포맷. property도 ""로 작성
// {
//     "title": "노인과 바다",
//     "author": "헤밍 웨이",
//     "isSold": false,
//     "genere": ["소설","비극"],
// };

const a = JSON.stringify(book);
console.log(typeof a, a);

const monster = [
    {id : 1, style: 'bird', attack: '꼬리치기', },
    {id : 2, style: 'snake', attack: '휘감기', },
    {id : 3, style: 'fish', attack: '몸통 박치기', },
];

const jsonMonster = JSON.stringify(monster);
console.log(jsonMonster);