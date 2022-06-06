def solution(n, edge):
    route = [[] for _ in range(n+1)]
    for a,b in edge:
        route[a].append(b)
        route[b].append(a)
    check = [float('inf')]*(n+1)

    from collections import deque
    que = deque()
    que.append((1,0)) # last,time

    while que:
        last,time = que.popleft()
        if check[last] > time:
            check[last] = time
            for go in route[last]:
                que.append((go,time+1))
    
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
            
    return answer

ans = solution(6,[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]])
print(ans,3, ans==3)
