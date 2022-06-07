# 220607 프론트 백앤드 연결

## getServerSideProps 
- 지속적인 요청이 있을 때마다 서버의 데이터를 요청하는 방식
```js
// nextJS의 feature
export const getServerSideProps = () => {
  try {
    const res = fetch('자원의 URL');
    const todos = res.json();
    console.log(todos);

  } catch (error) {
    console.log();
  }
};
```

### getStaticProps : next에서 정적인 랜더링을 할 때 사용

# 이번 중간 프로젝트 가이드 라인
1. 간단한 프로젝트 소개 (표면적인 레벨에서 이해할 수 있는) -> 적당히 참신한 아이디어, 이슈 등등
2. 시연 영상(or 움짤)
3. 도메인 용어 정의 (프로젝트 주제에 대한 용어, 변수명 등 정의)
4. 프로젝트 내에서 본인의 담당 및 역할이 무엇이었는지
5. 사용 기술 스택 ex)FE, BE 각각 요구되는 라이브러리, 프레임워크
6. 간단한 UI 목업 or 프로토타입 화면
7. 기능 소개
8. Restful API 명세서
-> Postman API Document or 직접 작성(표) 등
9. DB ERD (워크밴치, ER Cloud 등등)
10. 서비스 아키텍처 -> 전체적인 서비스가 어떻게 구성되어있는가. (도식화)
11. 느낀 점

## 추천 구현 기능 예시
1. 기본 데이터 입출력(CRUD)
2. 인증 기능 (oAuth) -> 프론트단 JS에선 localStorage 등
3. 검색 기능
4. 페이징 처리(spring boot API로 활용 가능)

## 팀 별 계획 작성 (Github Projects)

## API 명세서 작성 (Github Wiki)

## issue 탭 열심히 활용하기


