# 10 week - LinkedList & Tree
- [내용 정리](./Summary.md)
- 문제풀이
    - [프린터](https://programmers.co.kr/learn/courses/30/lessons/42587)
        - [문제 접근](#1-프린터)
        - [소스 코드 전체 링크](./%ED%94%84%EB%A6%B0%ED%84%B0.py)
    - [더 맵게](https://programmers.co.kr/learn/courses/30/lessons/42626)
        - [문제 접근](#2-더-맵게)
        - [소스 코드 전체 링크](./%EB%8D%94%20%EB%A7%B5%EA%B2%8C.py)
    - [이중우선순위큐](https://programmers.co.kr/learn/courses/30/lessons/42628)
        - [문제 접근](#3-이중우선순위큐)
        - [소스 코드 전체 링크](./%EC%9D%B4%EC%A4%91%EC%9A%B0%EC%84%A0%EC%88%9C%EC%9C%84%ED%81%90.py)

## 문제 접근

### 1. 프린터
1. deque를 사용한다.
    - priorities를 deque로 변환
    - check 리스트에 location값이 있는 인덱스면 1로 초기화 나머지는 0으로 초기화
```py
from collections import deque
priorities = deque(priorities)
check = deque([0]*len(priorities))
check[location] = 1
```
2. counts 리스트를 통해 0~9까지 숫자들의 인덱스를 만들고 값을 0으로 초기화
    - 0 ~ 9까지 priorites에서의 숫자의 개수를 넣어준다.
```py
counts = [0]*10
for i in priorities:
    counts[i] += 1
```
3. for문으로 9부터 1까지 숫자를 탐색한다.
    - 초기엔 answer 는 0으로 한다.
    - for문에서 나오는 숫자에 맞춰서 while문을 돌린다. break 조건은 counts[i]값이 0이 아닐 때 까지이다.
```py
answer = 0
for i in range(9,0,-1):
    while counts[i]:
```
4. while문 안에서 만약 priorities[0]값이랑 i 값이 같다면
    - answer에 1추가
    - priorities를 popleft
    - counts[i] 값에 1 빼기
```py
if priorities[0] == i:
    answer += 1
    priorities.popleft()
    counts[i] -= 1
```
5. 만약 그 안에서 check[0]값이?
    - 1이라면 (location 위치라면) : `if check[0]: return answer`
    - 0이라면 (location 위치가 아니라면) : `check.popleft()`
6. 4에서처럼 비교했을 때 priorities[0]값이랑 i 값이 다르다면 popleft하고 append로 순환
```py
else:
    priorities.append(priorities.popleft())
    check.append(check.popleft())
```
7. `return answer`

### 2. 더 맵게
1. heap 구조를 사용한다. 스코빌 리스트에 있는 값들을 heap에 넣어준다.
```py
import heapq
heap = []
for i in scoville:
    heapq.heappush(heap,i)
```
2. while문으로 최소값이 K이상일때까지 돌린다.
    - heap의 길이가 알맞지않아 에러상황이 나올 수 있으니 try, catch문을 사용한다.
    - heap에서 2개를 꺼내서 공식에 맞춰서 제조한 값을 heap에 넣는다.
    - 만약 최소값이 K 이상이면 반복한 횟수를 return
    - 예외상황 발생시 -1 return
```py
answer = 0
while 1:
    try:
        if heap[0] >= K: return answer
        answer += 1
        a = heapq.heappop(heap)
        b = heapq.heappop(heap)
        heapq.heappush(heap,a+b*2)
    except: return -1
```

### 3. 이중우선순위큐
1. heap 자료구조로 min,max_heap을 만든다.
```py
import heapq
min_heap = []
max_heap = []
```
2. for문으로 operations을 하나씩 돌린다. 그리고 split으로 분해한다.
```py
for i in operations:
    word,num = i.split()
    num = int(num)
```
3. 만약 word가 I 라면 push를 해야한다.
```py
if word == 'I':
    heapq.heappush(min_heap,num)
    heapq.heappush(max_heap,(-num,num))
```
4. word가 I가 아닌 상태에서 heap에 자료가 존재하다면 D를 실행한다.
- 값을 pop하면 반대면 (min이면 max를, max면 min을) 힙에도 값을 지워준다.
```py
elif min_heap:
    if num == 1:
        min_heap.remove(heapq.heappop(max_heap)[1])
    else:
        x = heapq.heappop(min_heap)
        max_heap.remove((-x,x))
```
5. 최대 최소값을 꺼내서 return한다.
```py
a, b = 0, 0
if min_heap:
    a = heapq.heappop(max_heap)[1]
    b = heapq.heappop(min_heap)
return [a,b]
```