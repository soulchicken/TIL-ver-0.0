# Asterisk

> 네이버 부스트코스 '머신러닝을 위한 파이썬' 강의 내용 정리

## Asterisk
- 흔히 알고 있는 `*` 를 의미
- 단순 곱셈, 제곱연산, 가변 인자 활용 등 다양하게 사용됨

```py
# *arg
def asterist_test(a, *args):
    print(a, args)
    print(type(args))
asterist_test(1,2,3,4,5,6)
>>> 1 (2, 3, 4, 5, 6)
>>> <class 'tuple'>

# *arg : tuple 타입으로 들어가게 됨
def asterist_test(a, *args):
    print(a, args)
    print(type(args))
asterist_test(1,2,3,4,5,6)
>>> 1 (2, 3, 4, 5, 6)
>>> <class 'tuple'>

# *kargsv : dict 타입으로 들어가게 됨
def asterist_test(a, **kargs):
    print(a, kargs)
    print(type(kargs))
asterist_test(1,b = 2,c = 3,d = 4,e = 5,f = 6)
>>> 1 {'b': 2, 'c': 3, 'd': 4, 'e': 5, 'f': 6}
>>> <class 'dict'>
```

## Unpacking a container
- tuple, dict 등 자료형에 들어가 있는 값을 unpacking
- 함수의 입력값, zip 등에 유용하게 사용

### tuple 타입에서 경우의 수
```py
def asterist_test(a, *args):
    print(a, args[0])
    print(a, args)
    print(type(args))

asterist_test(1,(2,3,4,5,6))
>>> 1 (2, 3, 4, 5, 6)
>>> 1 ((2, 3, 4, 5, 6),)
>>> <class 'tuple'>

-------------------------------------

def asterist_test(a, *args):
    print(a, args)
    print(type(args))

asterist_test(1,*(2,3,4,5,6))
>>> 1 (2, 3, 4, 5, 6)
>>> <class 'tuple'>

-------------------------------------

def asterist_test(a, args):
    print(a, *args)
    print(type(args))

asterist_test(1,(2,3,4,5,6))
>>> 1 2 3 4 5 6
>>> <class 'tuple'>

-------------------------------------

def asterist_test(a, args):
    print(a, *args)
    print(type(args))

asterist_test(1,*(2,3,4,5,6))
>>> TypeError
```

### dict 타입에서 경우의 수
```py
a, b, c = ([1, 2], [3, 4], [5, 6])
print(a, b, c)
>>> [1, 2] [3, 4] [5, 6]

-------------------------------------

data = ([1, 2], [3, 4], [5, 6])
print(*data)
>>> [1, 2] [3, 4] [5, 6]

-------------------------------------

def asterisk_test(a, b, c, d,):
    print(a, b, c, d)
data = {"b" : 1, "c" : 2, "d" : 3}
asterisk_test(10, **data)
>>> 10 1 2 3

-------------------------------------

for data in zip(*([1, 2], [3, 4], [5, 6])):
    print(data)
>>> (1, 3, 5)
>>> (2, 4, 6)
```