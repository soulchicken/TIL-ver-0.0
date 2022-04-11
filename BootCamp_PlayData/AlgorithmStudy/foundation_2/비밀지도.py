def solution(n, arr1, arr2):
    answer = []
    for i in range(n):
        x = bin(arr1[i] | arr2[i])
        x = (str(x)[2:]).replace('0',' ').replace('1','#')
        x = x.rjust(n)
        answer.append(x)
    return answer