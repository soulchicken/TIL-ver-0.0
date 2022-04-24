# try / except

> 광주 인공지능 사관학교 pre-course로 제공받은 elice 의 디버깅 강의 정리입니다.

- 어떤 예외상황을 미리 예측하고 안정망을 설치하는 방법!
## 1. 예외상황을 처리하기
1. 에러가 발생했다. : 예시에서는 zero division error
```py
def average(numbers):
    return sum(numbers) / len(numbers)
average([])
```

2. if문으로 분기하기 : 에러 없이 'no numbers!'가 출력된다.
```py
def average(numbers):
    if len(numbers) > 0:
        return sum(numbers) / len(numbers)
    print('no numbers!')
average([])
```

3. if문 분기와 똑같지만, 더 확실하게 읽히는 코드. try / except 문
```py
def average(numbers):
    try:
        return sum(numbers) / len(numbers)
    except ZeroDivisionError:
        print('no numbers!')
average([])
# no numbers! 출력
```