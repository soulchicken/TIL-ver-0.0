# 타입 스크립트
- 주말맞이 가볍게 공부해보기

## 타입스크립트 왜 쓰는데?
- 타입을 지정할 수 있다. (명시적으로)
- 자바 스크립트는 `[1,2,3] + false`를 연산할 수 있다.
```ts
let a = "hello"

// 오류 발생
a = 1
// 오류 발생
let b : boolean = "x"

let b : boolean = false

let c = [1,2,3] // number[]

// 작동 안하는 코드
c.push("1")

// 명시적으로 array에 타입 지정하기
let d : number[] = []

const player = {
    name: "soul"
}

// 에러 발생
player.hello()
// 에러 발생
player.name = 1
```

