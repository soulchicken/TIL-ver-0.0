# 6 week - Recursive Function
- [내용 정리](./Summary.md)
- 문제풀이
    - [이진수 변환](https://www.acmicpc.net/problem/10829)
        - [문제 접근](#1-이진수-변환)
        - [소스 코드 전체 링크](10829_%EC%9D%B4%EC%A7%84%EC%88%98%20%EB%B3%80%ED%99%98.py)
    - [팩토리얼](https://www.acmicpc.net/problem/10872)
        - [문제 접근](#2-팩토리얼)
        - [소스 코드 전체 링크](10872_%ED%8C%A9%ED%86%A0%EB%A6%AC%EC%96%BC.py)
    - [괄호 변환](https://programmers.co.kr/learn/courses/30/lessons/60058)
        - [문제 접근](#3-괄호-변환)
        - [소스 코드 전체 링크](./%EA%B4%84%ED%98%B8%20%EB%B3%80%ED%99%98.py)

## 문제 접근
**재귀함수로 굳이 풀 필요 없을지라도 최선을 다해 재귀호출함**

### 1. 이진수 변환
1. 입력값을 받고, 이진수로 들어갈 리스트 생성
```py
n = int(input())
s = []
```
2. 이진수 함수 생성 `def binary(n):`
    1. 만약 n이 0이라면? 그냥 return : `if not n: return`
    2. 0이 아니라면?
        1. 이진수로 들어갈 수 a 만들기 : `a = n % 2`
        2. n // 2가 들어간 함수 호출 : `binary(n // 2)`
        3. 위에서 호출한 함수가 끝난 이후 s에 a를 추가 : `s.append(str(a))`
3. 함수 호출 및 프린트
```py
binary(n)
print(''.join(s))

```

### 2. 팩토리얼
1. 입력을 받는다. : `n = int(input())`
2. 팩토리얼 함수를 만든다. : `def factorial(k):`
    1. 만약 k가 2보다 작다면 (0이거나 1이라면) `return 1`
    2. 2보다 크거나 같다면 `return k * factorial(k-1)`
3. 출력 : `print(factorial(n))`

### 3. 괄호 변환
1. 만약 입력값이 빈 문자열이면 그대로 반환 : `if not p: return ""`
2. 오른쪽, 왼쪽 괄호의 갯수를 카운팅할 변수를 만들고, 올바른 괄호인지를 판별하는 flag 변수를 만든다.
```py
right = 0
left = 0
flag = True
```
3. for문으로 u를 어디까지 만들 지 확인한다. 올바르지 않은 u가 된다면 flag는 `False`가 된다.
```py
for i in range(len(p)):
    if p[i] == '(' : left += 1
    else : right += 1
    if right > left : flag = False
    if right == left : break
u = p[:i+1]
v = p[i+1:]
```
4. 만약 u가 올바르다면? : `if flag : return u + solution(v)`
5. 그렇지 않다면?
```py
else:
    u = u[1:-1]
    a = ""
    for i in u:
        if i == '(':
            a += ')'
        else:
            a += '('
    return "(" + solution(v) + ")" + a
```