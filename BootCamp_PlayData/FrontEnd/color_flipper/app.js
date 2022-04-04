const btn = document.querySelector(".btn");
const color = document.getElementById("color");
const body = document.querySelector("body");

function clickEvent() {
    let r = parseInt(Math.random()*256);
    let g = parseInt(Math.random()*256);
    let b = parseInt(Math.random()*256);
    // 템플릿 리터럴 (`) 백틱 기호를 사용
    color.innerText = `rgba(${r},${g},${b})`;
    color.style.color = `rgba(${r},${g},${b})`;
    body.style.backgroundColor = `rgba(${r},${g},${b})`;
}

btn.addEventListener("click",clickEvent);