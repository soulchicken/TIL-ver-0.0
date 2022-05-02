from collections import deque
N,M,V = map(int,input().split())
li = [[] for _ in range(N+1)]
for i in range(M):
    a,b = map(int,input().split())
    li[a].append(b)
    li[b].append(a)

for i in range(1,N+1):
    li[i].sort()

check = [True] * (N+1)
stack = [V]
def DFS(last):
    check[last] = False
    for to_go in li[last]:
        if check[to_go]:
            stack.append(to_go)
            DFS(to_go)

DFS(V)
print(' '.join(map(str,stack)))

que = deque()
check = [True] * (N+1)
que.append(V)
stack = []
while que:
    start = que.popleft()
    if check[start]:
        stack.append(start)
        check[start] = False
        for i in li[start]:
            if check[i]:
                que.append(i)
print(' '.join(map(str,stack)))

