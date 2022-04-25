def solution(numbers):
    check = [0]*10000000
    check[0] = 1
    check[1] = 1
    for i in range(2,10000000):
        if check[i] == 0:
            for j in range(i*2,10000000,i):
                check[j] = 1
    answer = set()
    from itertools  import permutations
    for i in range(len(numbers)):
        for pro in permutations(numbers,i+1):
            n = int(''.join(pro))
            if check[n] == 0:
                answer.add(n)
    return len(answer)