def solution(operations):
    import heapq
    min_heap = []
    max_heap = []
    for i in operations:
        word,num = i.split()
        num = int(num)
        if word == 'I':
            heapq.heappush(min_heap,num)
            heapq.heappush(max_heap,(-num,num))
        elif min_heap:
            if num == 1:
                min_heap.remove(heapq.heappop(max_heap)[1])
            else:
                x = heapq.heappop(min_heap)
                max_heap.remove((-x,x))
    a, b = 0, 0
    if min_heap:
        a = heapq.heappop(max_heap)[1]
        b = heapq.heappop(min_heap)
    return [a,b]
print(solution(["I 16","D 1"]),[0,0])
print(solution(["I 7","I 5","I -5","D -1"]),[7,5])
print(solution(["I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"]),[6,5])
