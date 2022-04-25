n = int(input())
li = list(map(int,input().split()))
m = int(input())
li2 = list(map(int,input().split()))
NUM = 10000000
check = [0]*(NUM*2 + 1)
for i in li:
    check[i - NUM] += 1
for i in li2:
    print(check[i - NUM],end = ' ')
