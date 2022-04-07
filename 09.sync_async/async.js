// 비동기 방식 (Asynchronous)

// (*) asterisk
/**
 * 
 * @returns 
 */
const firstFunc = () => console.log("첫 번째 함수 호출");
const someLongTasks = () => {
    console.log('-------');
    console.log('특정 작업 처리중 암튼 긴 시간 걸림');
    console.log('-------');
};
const secondFunc = () => {
    console.log('두번째 함수 호출');
};
firstFunc();
someLongTasks();
secondFunc();

// 일정한 작업 시간 이후에 함수가 호출되도록 시간 지연시켜주는 sleep() 작성
/**
 * 
 * @param {*} callbackFunc 
 * @param {*} delay 
 */
function sleep(callbackFunc, delay) {
    console.log("시간 지연중!");
    const delayedTime = Date.now() + delay;
    while (Date.now() < delayedTime);
    callbackFunc();
}

// 3초 동안 두번째 작업을 블로킹하기
console.log('-----------------');
console.log('시간지연 만들기');
firstFunc();
sleep(secondFunc,3000);

console.log('\n\n---------비동기---------\n\n')
setTimeout(firstFunc, 3 * 1000);
secondFunc();