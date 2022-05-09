import sys
li = [1,2,6,24,120]
while 1:
    n = list(map(int,sys.stdin.readline().strip()))
    if n == [0]: break
    total = 0
    n = n[::-1]
    for i in range(len(n)):
        total += n[i]*li[i]
    print(total)