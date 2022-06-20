def solution(scoville, K):
    import heapq
    heap = []
    for i in scoville:
        heapq.heappush(heap,i)
    answer = 0
    while 1:
        try:
            if heap[0] >= K: return answer
            answer += 1
            a = heapq.heappop(heap)
            b = heapq.heappop(heap)
            heapq.heappush(heap,a+b*2)
        except: return -1
print(solution([1, 2, 3, 9, 10, 12],7),2)
print(solution([1, 2],6),-1)
