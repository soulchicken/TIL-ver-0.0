from collections import deque
N = int(input())
M = int(input())
li = [[] for _ in range(N+1)]
for i in range(M):
    a,b = map(int,input().split())
    li[a].append(b)
    li[b].append(a)

check = [0]*(N+1)

que = deque()
que.append(1)
while que:
    x = que.popleft()
    if not check[x]:
        check[x] = 1
        for i in li[x]:
            que.append(i)
print(sum(check) - 1)
