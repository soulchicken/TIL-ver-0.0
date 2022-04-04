function solution(s) {
    if (s.length % 2 == 0) return s[parseInt(s.length / 2)-1] + s[parseInt(s.length / 2)];
    return s[parseInt(s.length / 2)];
}