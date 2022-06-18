# 9 week - Greedy
- [내용 정리](./Summary.md)
- 문제풀이
    - [체육복](https://programmers.co.kr/learn/courses/30/lessons/42862)
        - [문제 접근](#1-체육복)
        - [소스 코드 전체 링크](./%EC%B2%B4%EC%9C%A1%EB%B3%B5.py)
    - [전자레인지](https://www.acmicpc.net/problem/10162)
        - [문제 접근](#2-전자레인지)
        - [소스 코드 전체 링크](./10162_%EC%A0%84%EC%9E%90%EB%A0%88%EC%9D%B8%EC%A7%80.py)
    - [구명 보트](https://programmers.co.kr/learn/courses/30/lessons/42885)
        - [문제 접근](#3-구명보트)
        - [소스 코드 전체 링크](./%EA%B5%AC%EB%AA%85%EB%B3%B4%ED%8A%B8.py)

## 문제 접근

### 1. 체육복
1. 기초 2주차에 풀었기 때문에 패스

### 2. 전자레인지
1. 5분, 1분, 10초 단위로 끊어서 나머지를 확인한다. (몫은 a,b,c에 저장)
```py
n = int(input())
a = n // 300
n %= 300
b = n // 60
n %= 60
c = n // 10
n %= 10
```
2. 만약 n이 0이 아니라면 -1 출력 `if n: print(-1)`
3. n이 0이라면 a,b,c 출력 : `else: print(a,b,c)`

### 3. 구명보트
1. 그냥 list로 사용하니 시간초과가 떠서 deque를 사용해 효율성 테스트를 통과했다. people을 내림차순으로 정리하고 deque에 넣었다.
```py
from collections import deque
people.sort(reverse = True)
people = deque(people)
```
2. people을 무거운 순서대로 하나씩 꺼내고 꺼낼때마다 answer에 1을 더한다.
```py
n = limit
n -= people.popleft()
answer += 1
```
3. while문으로 people의 가장 가벼운 순서대로 하나씩 꺼내서 보트에 더 탈 수 있는 사람을 뺀다.
```py
while people:
    if people[-1] > n: break
    n -= people.pop()
```