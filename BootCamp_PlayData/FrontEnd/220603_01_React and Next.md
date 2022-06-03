# 220603 React & Next
Next 프레임워크로 페이지 라우팅을 할 예정

## Next
- 성능, 렌더링 속도에 대한 전반적인 개선을 해준다.

### 프로젝트 생성
`npx create-next-app {프로젝트 명}`

### 터미널 단축 명령어 확인
```json
"scripts": {
    "dev": "next dev",
    "build": "next build",
    "start": "next start",
    "lint": "next lint"
},
```

### 랜더링을 어떻게 할 것인가?
- CSR (Client Side Rendering)
    - index.html의 <div id="root">여기에 컴포넌트들이 렌더링된다</div>
    - 검색엔진으로 찾아 들어가기엔 아직 렌더링이 안되있는 상태가 되서 검색 노출에 불리하다.
- SSR (Server Side Rendering)
- SSG (Static Site Generation)

### SEO
- Search Engine Optimization. 검색 엔진 최적화
- 개발자 + 기획자가 같이 고민한다.
- 예) h1 태그는 1개만 쓴다. title 태그는 해당 웹페이지를 가장 잘 나타내는 내용을 기술한다. 등등

## 아이콘 svg 무료 제공 사이트
`https://iconmonstr.com/`

## 라우팅
- [공식문서 - 라우팅](https://nextjs.org/docs/routing/introduction)
- File Based Routing : Next는 파일 기반의 라우팅을 한다.

```
pages/index.js -> localhost:3000/
pages/about.js -> localhost:3000/about/
pages/todos/index.js -> localhost:3000/todos/
pages/todos/[id].js -> localhost:3000/todos/[id]
pages/index.js -> localhost:3000/
```

# 추가 강의 (Git / Hub)
내가 어디에 관심있고 무슨 포지션을 하고 싶은지

자랑할만한 프로젝트

내가 할 줄 아는 스택

