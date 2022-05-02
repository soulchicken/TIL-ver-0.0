# 2 Week - DFS & BFS
- [내용 정리](./Summary.md)
- 문제풀이
    - [DFS와 BFS](https://www.acmicpc.net/problem/1260)
        - [문제 접근](#1-dfs와-bfs)
        - [소스 코드 전체 링크](1260_DFS%EC%99%80%20BFS.py)
    - [바이러스](https://www.acmicpc.net/problem/2606)
        - [문제 접근](#2-바이러스)
        - [소스 코드 전체 링크](./2606_%EB%B0%94%EC%9D%B4%EB%9F%AC%EC%8A%A4.py)
    - [타겟 넘버](https://programmers.co.kr/learn/courses/30/lessons/43165)
        - [문제 접근](#3-타겟-넘버)
        - [소스 코드 전체 링크](./%ED%83%80%EA%B2%9F%EB%84%98%EB%B2%84.py)

## 문제 접근
### 1. DFS와 BFS
1. 양방향 접근이 가능하다. 길에 해당하는 `li`리스트에 길을 추가할 때 양방향으로 추가한다. 

```py
li = [[] for _ in range(N+1)]
for i in range(M):
    a,b = map(int,input().split())
    li[a].append(b)
    li[b].append(a)
```

2. 길을 정렬해준다. (오름차순)

```py
for i in range(1,N+1):
    li[i].sort()
```

3. (DFS) check 리스트로 진입 여부를 표시하고, stack으로 이동 경로를 표시한다. (이동경로의 시작은 V)

```py
check = [True] * (N+1)
stack = [V]
```

4. (DFS) DFS 함수를 만들고 실행한다. 

```py
def DFS(last):
    check[last] = False
    for to_go in li[last]:
        if check[to_go]:
            stack.append(to_go)
            DFS(to_go)

DFS(V)
```
5. (DFS) 출력한다. : `print(' '.join(map(str,stack)))`

6. (BFS) 이동경로를 표시하는 stack, 진입 여부를 표시하는 check 리스트를 초기화하고, queue를 만든다. queue에는 첫 이동지점인 V를 추가한다.

```py
que = deque()
check = [True] * (N+1)
que.append(V)
stack = []
```

7. (BFS) while문으로 BFS를 구현한다.
```py
while que:
    start = que.popleft()
    if check[start]:
        stack.append(start)
        check[start] = False
        for i in li[start]:
            if check[i]:
                que.append(i)
```
8. (BFS) 출력한다. `print(' '.join(map(str,stack)))`

### 2. 바이러스
1. 양방향 접근이 가능하다. 길에 해당하는 `li`리스트에 길을 추가할 때 양방향으로 추가한다. 

```py
li = [[] for _ in range(N+1)]
for i in range(M):
    a,b = map(int,input().split())
    li[a].append(b)
    li[b].append(a)
```

2. 진입 여부를 표시하는 check 리스트를 초기화하고, queue를 만든다. queue에는 첫 이동지점인 1을 추가한다.
    - check 리스트에서 진입한 곳은 1, 진입하지 않은 곳은 0이 되도록 한다.

```py
check = [0]*(N+1)
que = deque()
que.append(1)
```

3. while문으로 BFS를 구현한다. 이때 진입한 곳을 0에서 1로 바꾼다.

```py
while que:
    x = que.popleft()
    if not check[x]:
        check[x] = 1
        for i in li[x]:
            que.append(i)
```

4. 진입한 곳의 개수는 check의 요소들의 합에서 최초의 출발지점의 수(1개)를 뺀 값이다.
    - `print(sum(check) - 1)`

### 3. 타겟 넘버
1. queue를 통해 BFS를 구현한다.queue에 들어가는 요소는 `(total,index)`
    - index : 이번 while문에서 열어볼 numbers의 인덱스 번호
    - total : 이전까지 수들의 합

```py
que = deque()
que.append((0,0)) # 토탈은 0, 0번 인덱스로 시작할 예정
```

2. 자주 사용할 numbers 배열의 길이를 미리 생성하고, 정답 answer에 0으로 시작한다.

```py
length = len(numbers)
answer = 0
```

3. while문으로 BFS를 구현한다.
    - 만약 index가 length보다 작다면. 해당 인데스의 수를 더하거나 빼서 큐에 넣는다.
    - index가 length보다 작지 않고, total과 target이 같은 수라면 answer에 1을 추가한다.

```py
while que:
    total,index = que.popleft()
    if index < length:
        que.append((total + numbers[index],index+1))
        que.append((total - numbers[index],index+1))
    elif total == target:
        answer += 1
```

4. `return answer`