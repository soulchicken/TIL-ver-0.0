function solution(a, b) {
    if (a > b) {
        return (a+b)*(a-b+1) /2;
    }
    return (a+b)*(b-a+1) /2;
}