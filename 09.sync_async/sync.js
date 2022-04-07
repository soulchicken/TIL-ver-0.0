// 표현식 사용
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

// 현지 실행 중인 작업(Task)이 종료할 때까지 다음에실행될 작업이 대기하는 방식을 동기 처리라고 한다.

const employee = {
    id : "34594",
    firstName : 'Heather',
    lastName : 'Banks',
    hireDate : '1/19/1998',
    deptCode : 'BB001',
    salary : 72000
    // ...
};

const employeeData = [
    {
        id : "34594",
        firstName : 'Heather',
        lastName : 'Banks',
        hireDate : '1/19/1998',
        deptCode : 'BB001',
        salary : 72000,
    },
    {
        id : "34593",
        firstName : 'Tina',
        lastName : 'Young',
        hireDate : '4/1/2010',
        deptCode : 'BB001',
        salary : 65000,
    }
]