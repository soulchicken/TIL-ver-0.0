n = int(input())
s = []
def binary(n):
    if not n:
        return
    a = n % 2
    binary(n // 2)
    s.append(str(a))
binary(n)
print(''.join(s))
