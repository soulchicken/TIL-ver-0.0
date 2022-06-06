# 7 week - DP
- [내용 정리](./Summary.md)
- 문제풀이
    - [계단 오르기](https://www.acmicpc.net/problem/2579)
        - [문제 접근](#1-계단-오르기)
        - [소스 코드 전체 링크](./%EA%B3%84%EB%8B%A8%20%EC%98%A4%EB%A5%B4%EA%B8%B0.py)
    - [정수 삼각형](https://programmers.co.kr/learn/courses/30/lessons/43105)
        - [문제 접근](#2-정수-삼각형)
        - [소스 코드 전체 링크](./%EC%A0%95%EC%88%98%20%EC%82%BC%EA%B0%81%ED%98%95.py)
    - [N으로 표현](https://programmers.co.kr/learn/courses/30/lessons/42895)
        - [문제 접근](#3-n으로-표현)
        - [소스 코드 전체 링크](./N%EC%9C%BC%EB%A1%9C%20%ED%91%9C%ED%98%84.py)

## 문제 접근

### 1. 계단 오르기
1. 입력을 잘 받고, 해당 인덱스에서 1번 연속, 2번 연속으로 밟았을 때 최댓값을 저장하는 리스트를 만든다.
```py
n = int(input())
li = [0] + [int(input()) for _ in range(n)]
one = [0]*(n+1)
two = [0]*(n+1)
```
2. 1번칸을 1번만 연속으로 밟은 상태의 값을 넣어준다.: `one[1] = li[1]`
3. for문으로 DP값을 넣어준다.
```py
for i in range(2,n+1):
    one[i] = max(one[i-2],two[i-2]) + li[i]
    two[i] = one[i-1] + li[i]
```
4. 출력 : `print(max(one[-1],two[-1]))`
### 2. 정수 삼각형
1. 점화식 느낌 : `triangle[i][j] += max(triangle[i][j+1],triangle[i+1][j+1])`

### 3. N으로 표현
1. n개의 수를 사용했을 때의 수를 저장할 리스트를 미리 만든다. : `li = [[] for _ in range(8+1)]`, 최대 8회 반복하므로 리스트는 9개 (0번까지 해서)
2. for문으로 1번 라인부터 9번라인까지 (숫자를 1개만 쓴 시점부터, 9번 쓴 시점까지) 확인한다.
    - 만약 k번 수를 사용했다면, k-1, 1번 사용한 수 들을 사칙연산 비교하고, k-2,2번 사용한 수들을 사칙연산 비교하고.... 를 반복한다.

```py
for n in range(1,9):
    a = int(str(N)*n)
    if a == number:
        return n
    li[n].append(a)
    for k in range(1,n):
        for i in range(len(li[k])):
            for j in range(len(li[n-k])):
                arr = [li[k][i] + li[n-k][j], li[k][i] - li[n-k][j]
                        ,li[k][i] * li[n-k][j]]
                if li[n-k][j]:
                    arr.append(li[k][i] // li[n-k][j])
                if number in arr:
                    return n
                li[n].extend(arr)
return -1
```