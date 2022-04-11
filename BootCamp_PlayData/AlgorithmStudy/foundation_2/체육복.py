def solution(n, lost, reserve):
    people = [1]*(n+1)
    people[0] = 0
    reserve.sort()
    for i in lost:
        people[i] = 0
        if i in reserve:
            people[i] = 1
            reserve.remove(i)
    for i in reserve:
        if i > 1 and people[i - 1] == 0: people[i - 1] = 1
        elif i < n and people[i + 1] == 0: people[i + 1] = 1
    return sum(people)