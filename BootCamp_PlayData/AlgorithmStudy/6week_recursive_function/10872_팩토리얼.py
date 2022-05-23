n = int(input())

def factorial(k):
    if k < 2:
        return 1

    else:
        return k * factorial(k-1)

print(factorial(n))
