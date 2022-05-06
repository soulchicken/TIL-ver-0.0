# 노드몬
- [npm 링크](https://www.npmjs.com/package/nodemon)
- Node.js 어플리케이션이 수정되었을 때 자동으로 다시 시작해준다.
- 코드, 메소드의 변경이나 추가를 요구하지 않는다.

## 다운 받기
- `npm install --save-dev nodemon`

## 사용하기
- node : `nodemon {파일명}`
- ex) `nodemon index.js` : 노드로 index.js를 실행하는데, 먼가 바뀌면 다시 실행해줘! 라는 뜻
- none node : `nodemon --exec {명령어} {파일명}`
- ex) `nodemon --exec "python -v" ./app.py` : 파이썬 버전좀 확인해줄래? 라는 뜻

## package.json에서 script 명령어 넣기
```json
"scripts":{
    "start": "node src",
    "start:dev": "nodemon --watch src/ src/index.js"
}
```