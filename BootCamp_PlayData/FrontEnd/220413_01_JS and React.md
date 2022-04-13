# 220413 JavaScript

Node.js : 단순한 JS 실행 환경.
- 기존에는 JS를 브라우저 엔진으로만 실행이 가능했으나 Node.js를 사용하면 에디터에서도 실행 가능
- 서버를 구성할 수 있는 환경이 가능해졌다

Web API : DOM, XMLHttpRequest
- 순수한 JS 기능이 아니라 어딘가의 외부 API.
- 만약 Node를 사용한다면 DOM을 쓸 수 없다

Framework. 정해진 틀이나 가이드가 있다. 가이드라인대로만 따라하면 결과물을 빠르게 만들 수 있는게 프레임워크
- 서버 구성이 편리해진다. (Node에서는 Express라는 프레임워크 사용)

# 프레임 워크 vs 라이브러리
- 프레임워크는 자유도가 떨어지지만 라이브러리는 다양성이 좀 존재한다.
- 다루는 것은 프레임워크가 편하다.

# React
- [공식 문서](https://ko.reactjs.org/docs/getting-started.html)
- A JavaScript library for building user interfaces
- 라이브러리. (vue는 프레임워크)
- 이전 상태와 마지막의 가장 최근 상태와의 차이를 비교해주고, 변경 내용을 감지하여 ReactDOM에 전달


## CDN (contents delivery network)
    - 전에 구글 폰트했던거마냥 링크를 통해서 사용하게 되는 것
### React, React DOM을 CDN으로 가져오기
```js
// react의 최상위 API. React 라이브러리 진입점
<script crossorigin src="https://unpkg.com/react@18/umd/react.development.js"></script>
// react로 생성한 컴포넌트를 브라우저(Real DOM)한테 전달해주는 역할
<script crossorigin src="https://unpkg.com/react-dom@18/umd/react-dom.development.js"></script>
```

## createElement
```js
const component = React.createElement('div',null,'div입니다.');
console.log(component); // <div>div입니다.</div>
ReactDOM.render(component,document.getElementById('root')); // id='root' 안에 component을 넣고 랜더링을 해준다

// ReactDOM.render(Component, root); // 랜더링할 것, 랜더링할 곳

```

## 태그 중첩 (Nesting)
- div 태그 안에 p 태그가 들어간 component를 만들기
```js
const component = React.createElement('div',null,'div입니다.',React.createElement('p',null,'p입니다.'));
```

## 숏코딩 맨들기
```js
const Component = function(props) {
    return React.createElement('p',null,`${props.count}`);
}

const Component = (props) => {
    return React.createElement('p',null,`${props.count}`);
};

const Component = props => React.createElement('p',null,`${props.count}`);

```

## 컴포넌트 만들기
1. 클래스형 컴포넌트
2. 함수형 컴포넌트

## Babel
```html
<script src="https://unpkg.com/@babel/standalone/babel.min.js"></script>
<script type="text/babel">
    // babel 을 통한 JSX문법을 사용하기 위함
</script>
```

### Babel 적용하기 (JSX)
```html
<div id="root"></div>
<script type="text/babel">
    //1. Babel CDN을 활용하여 JSX 적용
    //   Babel로 적용된 모습.
    //   https://babeljs.io/repl#?browsers=defaults%2C%20not%20ie%2011%2C%20not%20ie_mob%2011&build=&builtIns=false&corejs=3.21&spec=false&loose=false&code_lz=AQ0JQUwQwYwFwCIHkCyA6AThAdgEwhgBQBQoZwAPLgJYBuAfKeWRQK4A2jzzFAFgEz0AKr2rYA5gGdgMKHGntqAawgUA9AK7cWi-gGEA9gDMjEVWt1NtICrqHR1l66FvV6KauyWO3V7uo4tHjUaBgAaPzJcAxhWAFscODQAR1YCAE8AZQh2CHgDIgAiAGIMAwM4QoBKSOAqgG4gA&debug=false&forceAllTransforms=false&shippedProposals=false&circleciRepo=&evaluate=false&fileSize=false&timeTravel=false&sourceType=module&lineWrap=true&presets=env%2Creact%2Cstage-2&prettier=false&targets=&version=7.17.6&externalPlugins=&assumptions=%7B%7D
      
    render() 내에 html elements가 직접 적용되어 있어서 가독성이 떨어짐.
    ReactDOM.render(
    <div>
        <ul>
        <h2>Things cats like</h2>
        <li>Coffee</li>
        <li>Tea</li>
        <li>Milk</li>
        </ul>
    </div>,
    document.getElementById("root")
    );
    
    // 2. 함수 컴포넌트 방식으로 분리
    const root = document.getElementById('root');
    let coffee = 'startbucks';
    const Component = props => {
        return (
            <ul>
                <h2>Things cats like</h2>
                <li>{coffee} Coffee</li>
                <li>Tea</li>
                <li>Milk</li>
            </ul>
        );
    };
    ReactDOM.render(<Component />,root);
... // <> 로 감싼 커스텀 태그로 지정
```

> JSX는 HTML보다는 JavaScript에 가깝기 때문에, React DOM은 HTML 어트리뷰트 이름 대신 **camelCase** 프로퍼티 명명 규칙을 사용합니다.
> 예를 들어, JSX에서 **class**는 **className**가 되고 **tabindex**는 **tabIndex**가 됩니다.
