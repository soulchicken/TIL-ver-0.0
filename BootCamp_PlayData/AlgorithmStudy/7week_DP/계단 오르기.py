n = int(input())
li = [0] + [int(input()) for _ in range(n)]
one = [0]*(n+1)
two = [0]*(n+1)
one[1] = li[1]
for i in range(2,n+1):
    one[i] = max(one[i-2],two[i-2]) + li[i]
    two[i] = one[i-1] + li[i]
print(max(one[-1],two[-1]))
