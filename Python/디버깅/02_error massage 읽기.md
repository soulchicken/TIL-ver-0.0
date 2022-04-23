# 에러 읽고 대처하기

> 광주 인공지능 사관학교 pre-course로 제공받은 elice 의 디버깅 강의 정리입니다.

## 1. 에러 메시지 읽기
- 가장 마지막 줄이 가장 중요하다. (근본적인 원인이 나옴)
- 그리고 그 위부터가 그 다음으로 중요하다. (가장 근본적인 원인의 위치들이 나옴)

### 1.1. 에러 상황
```py
def greeting(your_name):
    print('Hello, ' + yourname + '!')
greeting('Trump')
```
위 소스 코드는 아래와 같은 에러메시지를 출력한다.
```
Traceback (most recent call last):
  File "C:/Users/SOULFEVER/Desktop/1.py", line 3, in <module>
    greeting('Trump')
  File "C:/Users/SOULFEVER/Desktop/1.py", line 2, in greeting
    print('Hello, ' + yourname + '!')
NameError: name 'yourname' is not defined
```
#### 1.1.1. 에러 읽어보기
- `Traceback (most recent call last)`
    - 문제 상황에서 가장 마지막에 발생한 문제부터 아마도 원인까지 타고타고 올라갈게
- `File "C:/Users/SOULFEVER/Desktop/1.py", line 3, in <module> greeting('Trump')`
    - 해당 파일의 3번째 줄에서 문제가 생겼다. 3번째 줄에 `greeting`  함수는 1 ~ 2번째 줄에서 생기는데, 이처럼 자신의 줄이 아닌 다른 줄에서 실행된 경우를 `<module>`이라 한다.
- `File "C:/Users/SOULFEVER/Desktop/1.py", line 2, in greeting print('Hello, ' + yourname + '!')`
    - 직 전에 생긴 3번째 줄의 앞에는 2번째 줄이 있을 것이다. print() 에서 문제가 생긴 것을 알 수 있다.
- `NameError: name 'yourname' is not defined`
    - 이름의 문제가 아닐까? 라는 의미. yourname은 정의되지 않았다.

### 1.2. 에러 상황 2
```py
def average(numbers):
    return sum(numbers) / len(numbers)
average([])
```
위 소스 코드는 아래와 같은 에러메시지를 출력한다.
```
Traceback (most recent call last):
  File "C:/Users/SOULFEVER/Desktop/1.py", line 3, in <module>
    average([])
  File "C:/Users/SOULFEVER/Desktop/1.py", line 2, in average
    return sum(numbers) / len(numbers)
ZeroDivisionError: division by zero
```
#### 1.2.1. 에러 읽어보기 2
- `Trackback ...` : 지금부터 어느 경로로 에러가 발생했는지 알려줄게
- `File ... (첫번째)` : average([])을 실행한 3번째 줄의 바깥( `<module>` )에서 뭔가 문제가 생긴 것 같아
- `File ... (두번째)` : 2번째 줄, average함수가 있는 곳 안에서 return 부분에 문제가 생겼어
- `ZeroDivisionError: division by zero` : 0으로 나눈게 문제같은걸?

## 2. 자주 접하는 에러코드

### 2.1 Syntax error
- 잘못된 문법.
- 예시 코드 : 3번째 줄 for문 맨 뒤에 (`:`)이 빠졌다.
```py
def add_all(numbers):
    result = 0
    for number in numbers
        result += number
    return result
```
- 위 소스 코드는 아래와 같은 에러메시지를 출력한다.
```
File "main.py", line 3
    for number in numbers
syntaxError : invalid syntax
```
- 컴퓨터가 이해할 수 없는 코드라는 의미.
- 이 에러메시지엔 Traceback이 없다. 컴퓨터는 이 코드의 논리를 알 수 없기 때문.

## 2.2. Name error
- 변수 이름, 함수 이름을 오타로 생기는 에러
- 예시 코드 : 4번째 줄에 number를 numbre로 오타

```py
def add_all(numbers):
    result = 0
    for number in numbers:
        result += numbre
    return result
add_all([1,2,3])
```

- 위 소스 코드는 아래와 같은 에러메시지를 출력한다.

```
Traceback (most recent call last):
  File "C:/Users/SOULFEVER/Desktop/1.py", line 6, in <module>
    add_all([1,2,3])
  File "C:/Users/SOULFEVER/Desktop/1.py", line 4, in add_all
    result += numbre
NameError: name 'numbre' is not defined
```

- `NameError: name 'numbre' is not defined` : 정의한 적 없는 `numbre` 라는 변수가 나왔어요! 라는 뜻

## 2.3. Type error

### 2.3.1. 타입 에러 예시 1
- 예시 코드 : 숫자 + 문자열 연산으로 에러 발생
```py
def add_all(numbers):
    result = 0
    for number in numbers:
        result += number
    return result
add_all(['a','a','b'])
```

- 위 소스 코드는 아래와 같은 에러메시지를 출력한다.

```
Traceback (most recent call last):
  File "C:/Users/SOULFEVER/Desktop/1.py", line 6, in <module>
    add_all(['a','a','b'])
  File "C:/Users/SOULFEVER/Desktop/1.py", line 4, in add_all
    result += number
TypeError: unsupported operand type(s) for +=: 'int' and 'str'
```

- `TypeError: unsupported operand type(s) for +=: 'int' and 'str'`
    - 다른 타입의 변수가 더해져서 생긴 문제다. 라는 뜻.

### 2.3.2. 타입 에러 예시 2
- 예시 코드 : 숫자 + 문자열 연산으로 에러 발생
```py
def usd_to_krw(price):
    price_in_krw = price * 100
    return price_in_krw + ' won'
usd_to_krw(4.99)
```

- 위 소스 코드는 아래와 같은 에러메시지를 출력한다.

```
Traceback (most recent call last):
  File "C:/Users/SOULFEVER/Desktop/1.py", line 4, in <module>
    usd_to_krw(4.99)
  File "C:/Users/SOULFEVER/Desktop/1.py", line 3, in usd_to_krw
    return price_in_krw + ' won'
TypeError: unsupported operand type(s) for +: 'float' and 'str'
```

## 2.4. Index error
- 인덱스 범위에서 벗어나는 요소를 불러오려고 하면 생기는 에러

```py
def first_character(string):
    return string[0]
first_character("")
```

- 위 소스 코드는 아래와 같은 에러메시지를 출력한다.

```
Traceback (most recent call last):
  File "/Users/soulfever/Documents/solved/1.py", line 3, in <module>
    first_character("")
  File "/Users/soulfever/Documents/solved/1.py", line 2, in first_character
    return string[0]
IndexError: string index out of range
```
- `IndexError: string index out of range` : 인덱스 범위를 넘어갔어! 라는 의미


## 2.5. Zero division error
- 수를 0으로 나누려고 할 때 발생하는 에러

```py
def average(numbers):
    return sum(numbers) / len(numbers)
average([])
```

- 위 소스 코드는 아래와 같은 에러메시지를 출력한다.

```
Traceback (most recent call last):
  File "/Users/soulfever/Documents/solved/1.py", line 3, in <module>
    average([])
  File "/Users/soulfever/Documents/solved/1.py", line 2, in average
    return sum(numbers) / len(numbers)
ZeroDivisionError: division by zero
```
- `ZeroDivisionError: division by zero` : 0으로는 나눌 수 없어! 라는 뜻

## 2.6. Import error
- 모듈, 패키지 import를 잘못했을 때 생기는 에러

```py
from math import squareroot
print(squareroot(4)) # 2.0 ??
```

- 위 소스 코드는 아래와 같은 에러메시지를 출력한다.

```
Traceback (most recent call last):
  File "/Users/soulfever/Documents/solved/1.py", line 1, in <module>
    from math import squareroot
ImportError: cannot import name 'squareroot' from 'math' (/Library/Frameworks/Python.framework/Versions/3.10/lib/python3.10/lib-dynload/math.cpython-310-darwin.so)
```
- `ImportError: cannot import name 'squareroot' from 'math'` : `math`에서 `squareroot`를 찾을 수 없어! 라는 뜻.
- 제곱근 함수의 이름 : `sqrt`.


## 2.7. Recursion error
- 재귀함수에서 나타나는 에러.
- 아래 코드에서 문제점 : 4 + 3 + 2 + 1 + 0 + (-1) + (-2) + (-3) + .........

```py
def sum_to(n):
    return n + sum_to(n-1)
sum_to(4)
```

- 위 소스 코드는 아래와 같은 에러메시지를 출력한다.

```
Traceback (most recent call last):
  File "/Users/soulfever/Documents/solved/1.py", line 3, in <module>
    sum_to(4)
  File "/Users/soulfever/Documents/solved/1.py", line 2, in sum_to
    return n + sum_to(n-1)
  File "/Users/soulfever/Documents/solved/1.py", line 2, in sum_to
    return n + sum_to(n-1)
  File "/Users/soulfever/Documents/solved/1.py", line 2, in sum_to
    return n + sum_to(n-1)
  [Previous line repeated 1022 more times]
RecursionError: maximum recursion depth exceeded
```
- `[Previous line repeated 1022 more times]` : 저 라인을 난 1022번 반복했어. (왜 재귀가 안끝나니?) 라는 뜻
- `RecursionError: maximum recursion depth exceeded` : 최대 재귀 깊이(안고 있을 수 있는 재귀함수의 양)를 넘겼어. 라는 뜻