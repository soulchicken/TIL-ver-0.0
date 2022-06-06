def solution(N, road, K):
    route = [[] for _ in range(N+1)]

    for a,b,c in road:
        route[a].append((b,c))
        route[b].append((a,c))
    
    from collections import deque
    que = deque()
    que.append((1,0)) # last,time
    check = [float('inf')]*(N+1)
    while que:
        last,time = que.popleft()
        if check[last] > time:
            check[last] = time
            for go,t in route[last]:
                que.append((go,time+t))
    answer = 0
    for i in check:
        if i <= K:
            answer += 1
    return answer
    

ans = solution(5,[[1,2,1],[2,3,3],[5,2,2],[1,4,2],[5,3,1],[5,4,2]],3)
print(ans,4, ans==4)
ans = solution(6,[[1,2,1],[1,3,2],[2,3,2],[3,4,3],[3,5,2],[3,5,3],[5,6,1]],4)
print(ans,4, ans==4)
