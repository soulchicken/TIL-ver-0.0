def solution(priorities, location):
    from collections import deque
    counts = [0]*10
    for i in priorities:
        counts[i] += 1
    priorities = deque(priorities)
    check = deque([0]*len(priorities))
    check[location] = 1
    answer = 0
    for i in range(9,0,-1):
        while counts[i]:
            if priorities[0] == i:
                answer += 1
                priorities.popleft()
                counts[i] -= 1
                if check[0]:
                    return answer
                check.popleft()
            else:
                priorities.append(priorities.popleft())
                check.append(check.popleft())
    return answer


print([2, 1, 3, 2],solution([2, 1, 3, 2], 2),1)
print([1, 1, 9, 1, 1, 1],solution([1, 1, 9, 1, 1, 1], 0),5)
