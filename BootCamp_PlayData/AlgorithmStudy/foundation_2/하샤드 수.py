def solution(x):
    return False if x % (sum(map(int,str(x)))) else True