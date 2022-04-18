def solution(progresses, speeds):
    from math import ceil
    from collections import deque
    answer = []
    queue = deque()
    for i in range(len(progresses)):
        queue.append( ceil ((100 - progresses[i]) / speeds[i]) )
    while queue:
        n = queue.popleft()
        count = 1
        while queue and queue[0] <= n:
            count += 1
            queue.popleft()
        answer.append(count)
    return answer