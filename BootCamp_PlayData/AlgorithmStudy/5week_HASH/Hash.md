# 5 Week - Hash
- [내용 정리](./Summary.md)
- 문제풀이
    - [Hashing](https://www.acmicpc.net/problem/15829)
        - [문제 접근](#1-hashing)
        - [소스 코드 전체 링크](Hashing.py)
    - [완주하지 못한 선수](https://programmers.co.kr/learn/courses/30/lessons/42576)
        - [문제 접근](#2-완주하지-못한-선수)
        - [소스 코드 전체 링크](./%EC%99%84%EC%A3%BC%ED%95%98%EC%A7%80%20%EB%AA%BB%ED%95%9C%20%EC%84%A0%EC%88%98.py)
    - [전화번호 목록](https://programmers.co.kr/learn/courses/30/lessons/42577)
        - [문제 접근](#3-전화번호-목록)
        - [소스 코드 전체 링크](./%EC%A0%84%ED%99%94%EB%B2%88%ED%98%B8%20%EB%AA%A9%EB%A1%9D.py)

## 문제 접근
**그치만 해시로 풀지 않지**

### 1. Hashing
1. 입력값을 받고, 답으로 출력할  cnt 값을 0 으로 초기화
```py
import sys
input = sys.stdin.readline
n = int(input())
s = input().strip()
cnt = 0
```
2. for문으로 해당 문자열을 1칸씩 살펴본다.
    - a의 아스키코드 값이 96이기 때문에 해당문자의 아스키 코드값에서 96을 빼고 31**i 를 곱한다.
    - 값이 커질 수 있으니 문제에서 사용하라고 한 `1234567891`을 나눈 나머지를 사용한다.
```py
for i in range(n):
    cnt += (ord(s[i])-96)*(31**i)
    cnt %= 1234567891
```
3. 출력 : `print(cnt)`

### 2. 완주하지 못한 선수
1. 참가자, 완주자 리스트를 정렬한다.
```py
participant.sort()
completion.sort()
```
2. for문으로 한 칸씩 옮겨가면서 참가자와 완주자의 이름이 맞는지 확인한다.
    1. 이름이 다르다면 참가자 명 `return`
    2. 모든 이름이 같다면 마지막 참가자 명 `return`
```py
for i in range(len(completion)):
    if completion[i] != participant[i]:
        return participant[i]
return participant[-1]
```

### 3. 전화번호 목록
1. 전화번호 목록을 정렬한다. `phone_book.sort()`
2. for문으로 한 칸씩 올라가면서 그 다음 전화번호와의 유사성을 확인한다.
    - 그 중에서 유사한 번호가 발견되면 바로 `return False`
    - 마지막까지 유사한 번호가 없다면 `return True`
```py
for i in range(len(phone_book)-1):
    a = len(phone_book[i+1])
    b = len(phone_book[i])
    if a > b and phone_book[i] == phone_book[i+1][:b]: return False
    elif a < b and phone_book[i][:a] == phone_book[i+1]: return False
return True
```