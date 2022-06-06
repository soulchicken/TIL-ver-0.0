## Object
- 잘못된 object 사용 (에러 발생)
```ts
const player : object = {
    name : 'soul'
}
player.name // 오브젝트에는 name 이라는 속성이 없다는 에러가 나타나게 된다.
```
- Object를 만들기!
```ts
const player : {
    name:string,
    age:number
} = {
    name : 'soul',
    age : 10
}
player.name // 사용 가능!
```

- 위에서 age를 선택적으로 사용하고 싶어짐
    - age 뒤에 ?를 붙이지 않으면 에러 발생
```ts
const player2 : {
    name:string,
    age?:number
} = {
    name : 'fever'
}
```

## Ailas를 만들기

```ts
type Player = {
    name:string,
    age?:number
}

const kim : Player = {
    name : "kim"
}
const dong : Player = {
    name : "dong",
    age : 12
}
```

## 함수에서 타입
```ts
function playerMaker(name:string) : Player { // 문자열타입 name을 입력받아 Player 타입으로 return 하겠다는 의미
    return {
        name
    }
}

// 위 함수를 화살표 식으로 작성하면
const playerMaker = (name:string) : Player => {
    name
}


const hyun = playerMaker("현");
hyun.age = 13;
```