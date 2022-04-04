function solution(s){
    return (s.match(/p/g) || []).length + (s.match(/P/g) || []).length == (s.match(/y/g) || []).length + (s.match(/Y/g) || []).length;
}