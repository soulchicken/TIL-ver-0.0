const xhr = new XMLHttpRequest(); // 객체 생성

xhr.open('GET', "https://jsonplaceholder.typicode.com/todos"); // 해석 : URL에 있는 내용을 내놔(GET)

const todos = document.getElementById('todos');
const clearBtn = document.getElementById('btn-clear');
const lookBtn = document.getElementById('btn-look');

xhr.onreadystatechange = () => {
    // 데이터 응답(로딩) 완료와 같음. == onload
    if (xhr.readyState == 4 && xhr.status == 200) {
        const responseData = xhr.responseText; // string
        const parseData = JSON.parse(responseData);
        let t = 0;
        let f = 0;
        for (let i of parseData) {
            if (i.completed) t++;
            else f++;
        }
        todos.innerHTML  += (`<h2>전체 ToDoList ${t+f}개 중에서 ${t}개를 해결했고,${f}개는 아직 해결하지 못하셨네용.</h2><br><br>`)
        for (let i = 0; i < parseData.length; i++) {
            if (parseData[i].completed) {
                todos.innerHTML  += (`${i+1} 번째 ToDo : <del>"${parseData[i].title}" </del><b> COMPLETE! </b> <br>`);    
            }
            else {
                todos.innerHTML  += (`${i+1} 번째 ToDo : "${parseData[i].title}" <br>`);
            }
        }
    }
};

xhr.send();

xhr.open('GET', "https://jsonplaceholder.typicode.com/todos");
function clearTodo() {
    
    const responseData = xhr.responseText; // string
    const parseData = JSON.parse(responseData);
    for (let i of parseData) {
        if (i.completed) t++;
        else f++;
    }
    todos.innerHTML  = (`<h2>전체 ToDoList ${t+f}개 중에서 ${t}개를 해결했고,${f}개는 아직 해결하지 못하셨네용.</h2><br><br>`);
    for (let i = 0; i < parseData.length; i++) {
        if (!parseData[i].completed) {
            todos.innerHTML  += (`${i+1} 번째 ToDo : "${parseData[i].title}" <br>`);    
        }
    }
    xhr.send();
}
clearBtn.addEventListener('click',clearTodo);

xhr.send();