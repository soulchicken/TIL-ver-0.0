# 8 week - Dijkstra
- [내용 정리](./Summary.md)
- 문제풀이
    - [배달](https://programmers.co.kr/learn/courses/30/lessons/12978)
        - [문제 접근](#1-배달)
        - [소스 코드 전체 링크](./%EA%B3%84%EB%8B%A8%20%EC%98%A4%EB%A5%B4%EA%B8%B0.py)
    - [특정 거리의 도시 찾기](https://www.acmicpc.net/problem/18352)
        - [문제 접근](#2-특정-거리의-도시-찾기)
        - [소스 코드 전체 링크](./%ED%8A%B9%EC%A0%95%20%EA%B1%B0%EB%A6%AC%EC%9D%98%20%EB%8F%84%EC%8B%9C%20%EC%B0%BE%EA%B8%B0.py)
    - [가장 먼 노드](https://programmers.co.kr/learn/courses/30/lessons/49189)
        - [문제 접근](#3-가장-먼-노드)
        - [소스 코드 전체 링크](./%EA%B0%80%EC%9E%A5%20%EB%A8%BC%20%EB%85%B8%EB%93%9C.py)

## 문제 접근

### 1. 배달
1. route 2차원 배열을 만들고 이동 경로, 이동 비용을 추가한다.
```py
route = [[] for _ in range(N+1)]
for a,b,c in road:
    route[a].append((b,c))
    route[b].append((a,c))
```
2. deque를 사용하고, 최초 시작지점 1번, 비용 0을 큐에 추가한다.
```py
from collections import deque
que = deque()
que.append((1,0)) # last,time
```
3. check 리스트에 해당 인덱스 위치에 최단 경로비용을 넣을 예정 : `check = [float('inf')]*(N+1)`
4. while 문으로 큐에 요소가 없을 때까지 반복
    - 만약 해당 인덱스의 비용이 check리스트의 값보다 작다면 해당 값으로 초기화
    - 초기화를 했다면 for문으로 해당 인덱스에서 이동하는 경로, 추가비용을 큐에 추가
```py
while que:
    last,time = que.popleft()
    if check[last] > time:
        check[last] = time
        for go,t in route[last]:
            que.append((go,time+t))
```
5. answer에 한계 이동비용은 K보다 작거나 같은 값의 갯수를 넣고 return
```py
answer = 0
for i in check:
    if i <= K:
        answer += 1
return answer
```

### 2. 특정 거리의 도시 찾기
1. deque를 import, N,M,K,X를 입력받는다.
```py
from collections import deque
N,M,K,X = map(int,input().split())
```
2. 경로에 대한 저장을 route 리스트에 한다. (2차원 배열)
    - M번 입력받으면서 경로를 저장한다.
```py
route = [[] for _ in range(N+1)]
for _ in range(M):
    a,b = map(int,input().split())
    route[a].append(b)
```
3. 큐에 X에서 0 시간을 지낸 상황을 저장
```py
que = deque()
que.append((X,0))
```
4. check 리스트에 해당 인덱스의 최단경로의 시간을 저장 `check = [float('inf')]*(N+1)`
5. while문으로 que의 요소가 없을 때까지 반복
    - que에서 popleft해서 해당 위치의 시간이 check 리스트의 값보다 작다면 check리스트의 값 변경
    - 변경을 했다면, for문으로 해당 위치에서 이동하는 경로를 큐에 추가
```py
while que:
    last, time = que.popleft()
    if check[last] > time:
        check[last] = time
        for i in route[last]:
            que.append((i,time+1))
```
6. stack에 check리스트의 값이 K인 인덱스를 추가
```py
stack = []
for i in range(N+1):
    if check[i] == K:
        stack.append(i)
```
7. 만약 stack에 값이 들어갔다면 하나씩 출력, 아니라면 -1 출력
```py
if stack:
    for i in stack:
        print(i)
else:
    print(-1)
```

### 3. 가장 먼 노드
1. route에 가는 길을 만들어준다.
```py
route = [[] for _ in range(n+1)]
for a,b in edge:
    route[a].append(b)
    route[b].append(a)
```
2. check 리스트에 모든 위치에 가는 최소 경로값을 넣을 예정 : `check = [float('inf')]*(n+1)`
3. deque를 만들고, 1번 노드에서 출발(시간은 0 경과)
```py
from collections import deque
que = deque()
que.append((1,0)) # last,time
```
3. while문으로 que에 요소가 없을 때까지 반복한다.
    - 만약 que에서 popleft한 요소를 비교해서 해당 위치에 시간이 check리스트의 값보다 작다면 값 적용
    - 그리고 해당 위치에서 출발하도록 que에 저장
```py
while que:
    last,time = que.popleft()
    if check[last] > time:
        check[last] = time
        for go in route[last]:
            que.append((go,time+1))
```
4. 최댓값이 되는 노드의 check 값을 찾을 때마다 answer에 1씩 추가
```py
MAX = -1
answer = 0
for i in check:
    if i == float('inf'):
        continue
    elif i > MAX:
        answer = 1
        MAX = i
    elif i == MAX:
        answer += 1
```
5. return! : `return answer`