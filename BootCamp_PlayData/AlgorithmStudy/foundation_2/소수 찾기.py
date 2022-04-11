def solution(n):
    answer = 0
    check = [1]*(n+1)
    for i in range(2,n+1):
        if check[i]:
            answer += 1
            for j in range(i,n+1,i):
                check[j] = 0
    return answer