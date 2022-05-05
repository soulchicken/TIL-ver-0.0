# Node JS 사용하기

> 조건 : 홈페이지에서 Node.js를 잘 다운 받는다.

## 프로젝트 생성

1. 먼저 git repo를 만들기
    - 터미널 `git init` : git 시작
    - 터미널 `git remote add origin {github repo url}` : 해당 깃허브 리포지토리 remote 
2. npm 프로젝트 시작
    - 터미널 `npm init` : npm 프로젝트 시작
        - 패키지명, 버전, 디스크립션, 라이센스 등등 확인
    - `package.json` 내용을 확인하고 필요하면 수정

## npm에서 패키지 다운받기
- npm install {패키지명} or npm i {패키지명}
- ex) `npm i express` : express 받아오기

## JS 파일 터미널에서 실행하기
- `node 파일명.js` 
    - 해당 경로의 index.js 파일 내용이 `console.log("Hi!")`이고,   
    터미널에서 `node index.js` 사용하면 Hi! 출력

## 단축 명령어를 만들기
- gogo라는 명령어로 index.js 파일 실행해보기
    - package.json 파일에 내용 추가
    ```json
    "scripts": {
         "gogo" : "node index.js"
    },
    ```
    - `npm run gogo` 를 터미널에서 실행