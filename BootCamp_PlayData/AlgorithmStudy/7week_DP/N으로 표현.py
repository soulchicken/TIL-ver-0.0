def solution(N, number):
    li = [[] for _ in range(8+1)]
    if N == number:
        return 1
    for n in range(1,9):
        a = int(str(N)*n)
        if a == number:
            return n
        li[n].append(a)
        for k in range(1,n):
            for i in range(len(li[k])):
                for j in range(len(li[n-k])):
                    arr = [li[k][i] + li[n-k][j], li[k][i] - li[n-k][j]
                         ,li[k][i] * li[n-k][j]]
                    if li[n-k][j]:
                        arr.append(li[k][i] // li[n-k][j])
                    if number in arr:
                        return n
                    li[n].extend(arr)

    return -1

print(solution(5,12))
print(solution(2,11))
