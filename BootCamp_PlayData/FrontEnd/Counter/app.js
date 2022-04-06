const number = document.getElementById("counting-num");

// btn들을 getClassElements로 배열로 가져오는 행위를 하면 더 좋게 바꿀 것 같다.

const incButton = document.getElementById('inc');
const decButton = document.getElementById('dec');
const resetButton = document.getElementById('reset');
const startButton = document.getElementById('start-btn');
const gameSetButton = document.getElementById('end');

const inGame = [number, incButton, decButton, resetButton, gameSetButton];

let count = 0;

function gameStart() {
    resetCount();
    startButton.classList.add('hidden');
    for (let i = 0; i < inGame.length; i++) {
        inGame[i].classList.remove('hidden');
    }
}

function gameSet() {
    startButton.classList.remove('hidden');
    for (let i = 0; i < inGame.length; i++) {
        inGame[i].classList.add('hidden');
    }
}

// function decreaseCount() {
//     count--;
//     showNumber();
// }

function resetCount() {
    count = 0;
    showNumber();
}

// function increaseCount() {
//     count++;
//     showNumber();
// }

function showNumber() {
    number.style.color = `rgba(${122 + 5*count},${122 - 8*count},${122 - 5*count})`;
    number.textContent = count;
}

startButton.addEventListener('click', gameStart);
// incButton.addEventListener('click', increaseCount);
// decButton.addEventListener('click', decreaseCount);
resetButton.addEventListener('click', resetCount);
gameSetButton.addEventListener('click', gameSet);


let GameBtns = document.getElementsByClassName('game-btn');
GameBtns = Array.from(GameBtns);

// console.log(GameBtns);
GameBtns.forEach(button => {
    // console.log(button);
    button.addEventListener('click', (event) => {
        // console.log(event); // 이벤트와 관련된 다양한 정보를 가지고 있는 객체
        // console.log(event.currentTarget);
        const curTargetID = event.currentTarget.id;
        if (curTargetID == 'reset') {
            count = 0;
        } else if (curTargetID == 'dec') {
            count--;
        } else {
            count++;
        }

        showNumber();
    });
}); // 화살표 함수를 forEach()의 인자값으로 전달함
// 그때 전달된 화살표 함수를 콜백 함수(callback function)라고 함