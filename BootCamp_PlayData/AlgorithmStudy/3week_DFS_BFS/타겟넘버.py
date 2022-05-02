def solution(numbers, target):
    from collections import deque
    que = deque()
    que.append((0,0)) # 토탈은 0, 0번 인덱스로 시작할 예정
    length = len(numbers)
    answer = 0
    while que:
        total,index = que.popleft()
        if index < length:
            que.append((total + numbers[index],index+1))
            que.append((total - numbers[index],index+1))
        elif total == target:
            answer += 1
    return answer
print(solution([1,1,1,1,1],3))
print(solution([4,1,2,1],4))
