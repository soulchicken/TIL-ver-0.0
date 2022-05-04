# 3 week - DFS & BFS 깊이 우선 탐색 & 너비 우선 탐색

## 1. 깊이 우선 탐색 (DFS)
- Depth First Search의 약자. 하나의 경우의 수에 대하여   
  모든 경우의 수를 조사하고 다음 경우의 수를 조사하면서 해를 찾는 과정
- 스택 (stack)을 사용하여 구현

### 1.1. 깊이 우선 탐색 예시 (미로 찾기)
- 주어진 미로가 탈출 가능한 미로라면 True, 탈출 불가능한 미로라면 False 반환
- (0,0) 을 스택에 넣고 시작. (0,1)을 갈 수 있다면 stack에 추가. 갈수 없다면 (1,0) 추가.
- (0,1)에서 (0,2)를 갈 수 있다면 추가. 아무대도 갈 수 없다면 (0,1)을 제거
- 도착지점으로 오면 True, 모든 탐색이 끝났는데 도착 못하면 False
- 글로 쓰기 힘듦.
```py
# 예시코드.... 별로...인듯... 
while stack:
    now = stack.pop()
    if now = dest:
        return True
    x,y = now
    if x - 1 > -1:
        if maps[y][x-1] == 0:
            stack.append([y,x-1])
            maps[y][x-1] = 2
    if x + 1 < hori:
        if maps[y][x+1] == 1:
            stack.append([y,x+1])
            maps[y][x-1] = 2
    if y - 1 > -1:
        if maps[y-1][x] == 1:
            stack.append([y-1,x])
            maps[y-1][x] = 2
    if x + 1< verti:
        if maps[y+1][x] == 1:
            stack.append([y+1,x])
            maps[y+1][x] = 2
return False
```

## 2. 너비 우선 탐색 (BFS)
- Breadth Firet Search의 약자로 너비 우선 탐색.
- 큐를 사용하여 구현
- 하나의 경우에 대한 다음 단계의 모든 경우의 수를 조사하면서 해를 찾는 과정. (같은 레벨 먼저 탐색)
- 첫 단계 검사 : 만약 정답이 있다면 종료. 없다면 다음 단계
- 두 번째 단계 검사 : 만약 정답이 있다면 종료. 없다면 다음 단계
- 마지막 단계 검사 : 만약 정답이 있다면 종료. 없다면 없는 거.

### 2.1. 너비 우선 탐색 예시 (최단 경로 찾기)
- 1번 섬에서 12번 섬으로 가는 최단 경로는 얼마인가? (모든 경로의 거리는 1)
- 1번 섬에서 다음 단계는 2,6번 섬이다. 큐에 넣는다.
- 2번 섬을 뺀다. 2번 섬에서 다음 단계는 3, 11번이다.
- 6번 섬을 뺀다. 6번 섬에서 다음 단계는 3,5,**12**번 섬이다.
- 3번 섬을 뺀다.6,8번 섬이다.
- 11번 섬을 뺀다. 알아서 넣는다.
- 3번 섬을 뺀다. 3번 섬은 이미 한 번 처리 했으니 continue.
- 5 번 섬을 뺀다... 알아서 넣는다.
- 12번 섬을 뺀다. 알고리즘 종료.

```py
# 예시 코드
while queue:
    count = len(queue)
    for time in range(count):
        now = queue.popleft()
        if now == dest:
            return answer
        for i in data:
            if i[0] == now and visited[i[1] - 1] == False:
                queue.append(i[1])
                visited[i[1] - 1] = True
            elif i[1] == now and visited[i[0] - 1] == False:
                queue.append(i[0])
                visited[i[0] - 1] = True
    answer += 1
return answer
```