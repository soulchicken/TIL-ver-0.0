def solution(people, limit):
    from collections import deque
    people.sort(reverse = True)
    people = deque(people)
    answer = 0
    while people:
        n = limit
        n -= people.popleft()
        answer += 1
        while people:
            if people[-1] > n: break
            n -= people.pop()
    return answer
print(solution([70, 50, 80, 50],100),3)
print(solution([70, 80, 50], 100),3)
