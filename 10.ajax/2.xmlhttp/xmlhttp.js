const xhr = new XMLHttpRequest(); // 객체 생성

xhr.open('GET', "https://jsonplaceholder.typicode.com/todos"); // 해석 : URL에 있는 내용을 내놔(GET)
console.log(`${xhr.readyState} OPENED`); // 1 == OPENED.

// readyState가 변경 될 때마다 호출되는 함수
xhr.onreadystatechange = () => {
    if (xhr.readyState == 2) { // send()는 호출했지만 응답을 받지 못한 상태 == 2
        console.log(`HEADERS_RECEIVED ${xhr.readyState}`);
    }  
    // 데이터 응답(로딩) 완료와 같음. == onload
    if (xhr.readyState == 4 && xhr.status == 200) {
        console.log(`responseData : ${xhr.responseText}`); // string 객체 반환
    }
};

// 브라우저가 데이터를 받는 동안 주기적으로 발생
xhr.onprogress = () => {
    console.log(`LOADING, ${xhr.readyState}`);
};

// 데이터 응답(로딩)이 완료된 경우
xhr.onload = () => {
    console.log(`DONE, ${xhr.readyState}`);
}

xhr.send();