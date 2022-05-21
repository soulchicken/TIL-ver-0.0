# Lambda, Map, Reduce

> 네이버 부스트코스 '머신러닝을 위한 파이썬' 강의 내용 정리

마음을 내립니다...
## 람다 (Lambda)
- 함수 이름 없이, 함수처럼 쓸 수 있는 익명 함수
- 수학의 람다 대수에서 유래
- `lambda 입력 값 : 반환 값` 형태
- Python 3 부터는 코드의 직관성이 떨어져 굳이 권장하지는 않음
- Legacy library나 다양한 머신러닝 코드에서 여전히 많이 쓰임

```python
# General Function
def f(x,y):
    return x+y

print(f(1,4))

# Lambda Function
f = lambda x, y: x + y
print(f(1,4))
```

- 활용하기
```py
print((lambda x: x+1)(5)) # 5 출력
```

## Map function
- `Sequence` 자료형 각 `element`에 동일한 함수를 적용
- `map(function_name,list_data)`
- 활용하기
```py
ex = [1,2,3,4,5]
f = lambda x: x ** 2
print(list(map(f,ex)))
>>> [1, 4, 9, 16, 25] 출력!
```

```py
f = lambda x,y : x + y
a = [1,2,3,4,5]
b = [6,7,8,9,10]
print(list(map(f, a,b)))
>>> [7, 9, 11, 13, 15] 출력!

li = list(map(lambda x: x**2 if x % 2 == 0 else x, ex))
print(li)
>>> [1, 4, 3, 16, 5]
```

## Reduce function
- map 과 달리 list에 똑같은 함수를 적용해서 통합
```py
from functools import reduce
print(reduce(lambda x, y: x+y, [1, 2, 3, 4, 5]))
# 1 + 2 = 3, 3 + 3 = 6, 6 + 4 = 10, 10 + 5 = 15 (출력!)
>>> 15 출력
```
- 활용하기 (펙토리얼 구현)
```py
def factorial(n):
    return reduce(
        lambda x, y : x*y, range(1,n+1)
    )
# 1 * 2 = 2, 2 * 3 = 6, 6 * 4 = 24, 24 * 5 = 120 (출력!)
print(factorial(5))
>>> 120 출력!

```
