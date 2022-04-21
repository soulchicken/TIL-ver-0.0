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

