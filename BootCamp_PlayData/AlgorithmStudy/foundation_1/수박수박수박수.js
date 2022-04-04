function solution(n) {
    var answer = '';
    for (let i = 0; i < n-1; i += 2) {
        answer += '수박';
    }
    if (n % 2 === 1) {
        answer += '수';
    }
    return answer;
}