const toDoForm = document.getElementById("todo-form");
const toDoInput = toDoForm.querySelector("input");
const toDoList = document.getElementById("todo-list");

const toDos = [];

function svaeToDos() {
    localStorage.setItem("todos", JSON.stringify(toDos));

}

function deleteToDo(event) { 
    const li = event.target.parentElement;
    li.remove();
}

function paintToDo(newToDo) {
    const li = document.createElement("li")

    const span = document.createElement("span");
    span.innerText = newToDo;


    const button = document.createElement("button");
    button.innerText = "X";
    button.addEventListener("click", deleteToDo)

    li.appendChild(span);
    li.appendChild(button);

    toDoList.appendChild(li);
}

function handleToDoSubmit(event) {
    event.preventDefault();
    const newToDo = toDoInput.value;
    toDoInput.value = "";
    toDos.push(newTodo);
    paintToDo(newToDo);
    svaeToDos();
}

toDoForm.addEventListener("submit", handleToDoSubmit);
