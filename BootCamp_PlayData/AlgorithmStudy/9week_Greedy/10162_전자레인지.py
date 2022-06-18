n = int(input())
a = n // 300
n %= 300
b = n // 60
n %= 60
c = n // 10
n %= 10
if n:
    print(-1)
else:
    print(a,b,c)
