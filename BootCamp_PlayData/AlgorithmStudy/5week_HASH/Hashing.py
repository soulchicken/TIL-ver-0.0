import sys
input = sys.stdin.readline
n = int(input())
s = input().strip()
cnt = 0
for i in range(n):
    cnt += (ord(s[i])-96)*(31**i)
    cnt %= 1234567891
print(cnt)
