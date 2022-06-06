from collections import deque

N,M,K,X = map(int,input().split())
route = [[] for _ in range(N+1)]
for _ in range(M):
    a,b = map(int,input().split())
    route[a].append(b)

que = deque()
que.append((X,0))

check = [float('inf')]*(N+1)

while que:
    last, time = que.popleft()
    if check[last] > time:
        check[last] = time
        for i in route[last]:
            que.append((i,time+1))

stack = []
for i in range(N+1):
    if check[i] == K:
        stack.append(i)
if stack:
    for i in stack:
        print(i)
else:
    print(-1)
