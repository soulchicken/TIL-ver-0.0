# 4 Week - RedixTransformAndBitMask
- [내용 정리](./Summary.md)
- 문제풀이
    - [팩토리얼 진법](https://www.acmicpc.net/problem/5692)
        - [문제 접근](#1-팩토리얼-진법)
        - [소스 코드 전체 링크](./%ED%8C%A9%ED%86%A0%EB%A6%AC%EC%96%BC%20%EC%A7%84%EB%B2%95.py)
    - [진법 변환](https://www.acmicpc.net/problem/2745)
        - [문제 접근](#2-진법-변환)
        - [소스 코드 전체 링크](./%EC%A7%84%EB%B2%95%20%EB%B3%80%ED%99%98.py)
    - [비밀지도](https://programmers.co.kr/learn/courses/30/lessons/17681)
        - [문제 접근](#3-비밀지도)
        - [소스 코드 전체 링크](./%EB%B9%84%EB%B0%80%EC%A7%80%EB%8F%84.py)

## 문제 접근
### 1. 팩토리얼 진법
1. 문제에서 주어지는 숫자는 최대 5자리 수이다. 각 자릿수에 맞게 수를 미리 준비해준다. : `li = [1,2,6,24,120]`
2. input 받은 수를 각 자릿수를 따로따로 리스트에 넣는다. : `n = list(map(int,sys.stdin.readline().strip()))`
3. 만약 입력받은 수가 0이라면 while문 종료. : `if n == [0]: break`
4. input 받아서 만든 리스트를 역순으로 만들어놓고, li의 해당 자릿수와 곱한 값을 total에 더한다.
```py
total = 0
n = n[::-1]
for i in range(len(n)):
    total += n[i]*li[i]
```

### 2. 진법 변환
1. 최초에 total값을 0으로 만들고, 입력받은 수 N와 진법의 수 B를 입력받는다.
```py
total = 0
N,B = input().split()
N = N[::-1]
B = int(B)
```
2. for문으로 N의 요소를 하나씩 꺼낸다. : `for i in range(len(N)):`
3. 만약 꺼낸 문자열 요소가 숫자라면 int로 변환한 값을 n에 넣는다.
```py
if N[i].isdigit():
    n = int(N[i])
```
4. 만약 꺼낸 문자열 요소가 숫자가 아니라면 (해당 알파벳의 아스키코드 값) - (A의 아스키코드 값 65) + 10 을 n에 넣는다.
```py
else:
    n = int(ord(N[i])) - 65 + 10
```
5.total에 n값을 B진법의 자릿수에 맞게 곱해서 더한다. :`total += n * B**i`

### 3. 비밀지도
1. return할 `answer = []`를 최초의 모습으로 만들어 놓고 한 줄씩 추가한다.
2. for문으로 n번 돌린다. : `for i in range(n):`
3. 두 지도의 OR 연산을 2진법으로 나타낸다. : `x = bin(arr1[i] | arr2[i])`
4. 2진법 변환시 나오게 되는 `0b` 접두사를 제거하고, '0'은 ' '으로, '1'은 '#'으로 replace한다. : `x = (str(x)[2:]).replace('0',' ').replace('1','#')`
5. 숫자가 작은 경우 칸 수가 모자랄 수 있으므로 rjust로 오른쪽 정렬한다. : `x = x.rjust(n)`
6. 정렬한 값을 answer에 추가한다. : `answer.append(x)`