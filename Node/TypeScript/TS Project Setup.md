# Project Setup
- 가장 먼저 할 일 : 프로젝트를 할 폴더에서 `npm init`

## 프로젝트 생성
- 타입스크립트를 devDependencies에 추가 install : `npm i -D  typescript`
- src 폴더를 만들고 .ts 파일들을 만들어서 사용하기!

## TS 파일을 컴파일해서 JS로
- 먼저 `tsconfig.json` 생성 : `touch tsconfig.json`
    - 이 파일이 있어야 vscode가 typescript로 작업한다는 것을 알게 된다. 어마어마한 자동완성 기능을 제공하게 된다.
    - src 폴더의 파일들을 컴파일 할 것이고, build 폴더에 결과물을 넣을 것이다 라는 의미
    - 변환하면 JS 버전을 ES6로 바꿀 것이라는 의미
    - lib는 어느 환경에서 실행되는 지에 대해서 알려준다.
        - ES6, DOM이라면, 자바스크립트 버전, 브라우저에서 하겠다라는 말
```json
{
    "include": ["src"],
    "compilerOptions": {
        "outDir": "build",
        "target" : "ES6",
        "lib" : ["ES6", "DOM"]
    }
}
```
- package.json에 build 스크립트 추가, `npm run build`를 하면 이제 build에 컴파일된 js파일이 생긴다.
```json
"scripts": {
    "build": "tsc"
},
```