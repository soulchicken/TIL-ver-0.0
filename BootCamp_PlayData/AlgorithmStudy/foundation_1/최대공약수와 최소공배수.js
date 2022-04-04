function solution(n, m) {
    for (let i = n; i > 0; i--) if (n % i == 0 && m % i == 0) return [i, n*m/i];
}