function solution(n)
{   
    return Array.from(n.toString()).reduce((a,b) => parseInt(a)+parseInt(b),0);
}