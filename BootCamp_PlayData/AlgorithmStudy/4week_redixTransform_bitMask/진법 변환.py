total = 0
N,B = input().split()
N = N[::-1]
B = int(B)
for i in range(len(N)):
    if N[i].isdigit():
        n = int(N[i])
    else:
        n = int(ord(N[i])) - 65 + 10
    total += n * B**i
print(total)