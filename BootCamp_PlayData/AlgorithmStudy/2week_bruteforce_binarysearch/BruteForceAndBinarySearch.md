# 1 Week - Stack & Queue
- [내용 정리](./Summary.md)
- 문제풀이
    - [모의고사](https://programmers.co.kr/learn/courses/30/lessons/42840?language=python3)
        - [문제 접근](#1-모의고사)
        - [소스 코드 전체 링크](./%EB%AA%A8%EC%9D%98%EA%B3%A0%EC%82%AC.py)
    - [소수 찾기](https://programmers.co.kr/learn/courses/30/lessons/42839)
        - [문제 접근](#2-소수-찾기)
        - [소스 코드 전체 링크](./%EC%86%8C%EC%88%98%20%EC%B0%BE%EA%B8%B0.py)
    - [숫자 카드 2](https://www.acmicpc.net/problem/10816)
        - [문제 접근](#3-숫자-카드-2)
        - [소스 코드 전체 링크](./%EC%88%AB%EC%9E%90%EC%B9%B4%EB%93%9C2.py)

## 문제 접근
### 1. 모의고사
- 1. 최대 10000 문제가 출제되기 때문에 1,2,3번 수포자들의 정답지의 길이를 10000이 되도록 맞춘다.
```py
man1 = [1,2,3,4,5] * 2000
man2 = [2,1,2,3,2,4,2,5] * 1250
man3 = [3,3,1,1,2,2,4,4,5,5] * 1000
```
- 2. 최초의 점수는 0으로 만들어 놓고. for문으로 answers를 돌려서 정답인 사람의 점수를 1씩 올린다.
```py
score = [0,0,0]
for i in range(len(answers)):
    if answers[i] == man1[i]: score[0] += 1
    if answers[i] == man2[i]: score[1] += 1
    if answers[i] == man3[i]: score[2] += 1
```
- 3. 최댓값은 사람을 리스트로 만들어서 return한다. 
```py
answer = []
x = max(score)
for i in range(3):
    if score[i] == x:
        answer.append(i+1)
return answer
```

### 2. 소수 찾기
- 1. 숫자의 범위는 최대가 7 자릿수. 소수를 구해야하므로 일단 check 리스트에 에라토스테네스의 체를 활용해 먼저 소수를 거른다.
```py
check = [0]*10000000
check[0] = 1
check[1] = 1
for i in range(2,10000000):
    if check[i] == 0:
        for j in range(i*2,10000000,i):
            check[j] = 1
```
- 2. 브루트포스로 하다보면 숫자가 겹칠 수 있으므로 list가 아니라 set 를 사용한다. `answer = set()`
- 3. itertools의 퍼뮤테이션을 사용해서 모든 경우의 수를 구하고, 구해진 수에서 check 리스트에 소수로 판별이 되 있는 수를 answer에 추가한다.
```py
from itertools  import permutations
for i in range(len(numbers)):
    for pro in permutations(numbers,i+1):
        n = int(''.join(pro))
        if check[n] == 0:
            answer.add(n)
```
- 4. answer의 길이 return `return len(answer)`

### 3. 숫자 카드 2
- 1. n,li,m,li2로 입력을 받는다. li,li2는 리스트로 입력받는다.
- 2. 숫자의 범위는 -10,000,000 ~ 10,000,000 이다.
    - `NUM = 1000000` 으로 기준을 하나 잡아준다.
    - `check = [0]*(NUM*2 + 1)` : 숫자가 들어갈 check 리스트를 만들어준다.
- 3. for문으로 li 리스트에 있는 숫자카드의 갯수를 만들어준다.
    - `for i in li: check[i - NUM] += 1`
- 4. 원하는 카드들의 갯수를 print, end를 사용해서 출력한다.
    - `for i in li2: print(check[i - NUM],end = ' ')`