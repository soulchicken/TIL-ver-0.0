# Test Code에 대해서

## 1. Test Code가 왜 필요해
- "내가 짠 코드가 맞게 짠 코드가 맞을까?" 에 대한 검증 : **설계된 대로 작동하는 지**
- "코드를 수정했는데 같은 기능으로 구현되는가?"에 대한 검증 : **수정후에도 동일하게 작동하는지**

## 2. 유닛 테스트
- 코드 테스트의 기본적인 개념
- Unit : 가장 작은 단위 (= 함수 1개)
- 유닛 테스트로 원하는 바 : 주어진 **입력(인자)**에 대해 예상된 **출력(리턴 값)**을 내놓는가?
- 테스트 작성을 어떻게 하느냐에 따라 어떤 출력을 의도하는지가 결정됨 (즉, 테스트 == 설계) (TDD, Test-Driven Development)

## 2.1. 예시 (펠린드롬)
- 회문 : level, 수박이박수, 토마토같은 앞뒤가 똑같은 단어
```py
def is_palindrome(text):
    if text[0] == text[-1]:
        ...
def test_is_palindrome_level():
    assert(is_palindrome("level") == True) # False라면 에러 발생, 종료.
    
def test_is_palindrome_lever():
    assert(is_palindrome("lever") == False) # True라면 에러 발생, 종료.

def test_is_palindrome_empty():
    assert(is_palindrome("")) # ??? : 설계에 따라 결과가 달라질 수 있다

def test_is_palindrome_sentence():
    assert(is_palindrome("Mr. Owl ate my metal worm")) # ??? : 설계에 따라 결과가 달라질 수 있다
```

```py
from helper import is_palindrome

# 다양한 예시에 대해 함수를 테스트합니다.
def test_is_palindrome(is_palindrome):    
    # 문자열 "madam"에 대해 테스트합니다. 리턴값은 True여야 합니다.
    assert(is_palindrome("madam") == True)

    # 아래 assert 안의 False들을 지우고 코드를 작성하면 됩니다.
    # 올바른 리턴값은 문제 설명의 함수 설계를 보고 생각해 보세요.

    # 문자열 "adam"에 대해 테스트합니다.
    assert(is_palindrome("adam") == False)

    # 빈 문자열에 대해 테스트합니다.
    assert(is_palindrome("") == True)

    # 문자열 "Step on no pets"에 대해 테스트합니다.
    assert(is_palindrome("Step on no pets") == True)

    # 문자열 "Madam, I'm Adam"에 대해 테스트합니다.
    assert(is_palindrome("Madam, I'm Adam") == True)

    # 문자열 "소주 만 병만 주소"에 대해 테스트합니다.
    assert(is_palindrome("소주 만 병만 주소") == True)

    # 문자열 "!소주 만 병만 주소?"에 대해 테스트합니다.
    assert(is_palindrome("!소주 만 병만 주소?") == True)

    # 문자열 "소주 만 병쯤만 주소"에 대해 테스트합니다.
    assert(is_palindrome("소주 만 병쯤만 주소") == False)

test_is_palindrome(is_palindrome)
```

## 2.2. 좋은 유닛 테스트의 조건
> 1. 읽기 쉽다.
> 2. 독립적이다.
> 3. 충분히 작다.
> 4. 충분히 넓다.

### 2.2.1. 읽기 쉽다.
- 내용을 쉽게 이해할 수 있어야한다.
- 간결한 코드가 미덕이지만 테스트 코드에서 만큼은 **예외상황을 검증하고자 하는 의도**를 보이는게 더 중요하다.
```py
# Bad
def test1():
    assert(is_palindrome("level") == True)

# Good
def test_is_palindrome_level():
    assert(is_palindrome("level") == True)
```

### 2.2.2. 독립적이다.
- Heater 클래스로 만든 객체 heater를 가지고 control_heater() 함수를 사용해보는 테스트
```py
heater = Heater()
def test_control_heater_when_cold(): # 추울 때 히터에 대한 컨트롤을 확인하는 테스트
    heater.current_temperature = -5.0
    heater.preferrend_temperature = 18.0
    control_heater(heater)
    assert(heater.is_turned_on == True)

def test_control_heater_when_hot(): # 더울 때 히터에 대한 컨트롤을 확인하는 테스트
    heater.current_temperature = 25.0
    heater.preferrend_temperature = 18.0
    control_heater(heater)
    assert(heater.is_turned_on == False)
```
- 근데 만약 아래와 같은 상황이라면?
```py
# 일정하지 않은 테스트 결과

# Case 1
test_control_heater_when_cold() # PASS
test_control_heater_when_hot() # PASS

# Case 2
test_control_heater_when_hot() # FAIL
test_control_heater_when_cold() # PASS
```

- 객체는 늘 새롭게 생성해야한다
- 제대로 작성한 테스트 코드
```py
def test_control_heater_when_cold(): # 추울 때 히터에 대한 컨트롤을 확인하는 테스트
    heater = Heater()
    heater.current_temperature = -5.0
    heater.preferrend_temperature = 18.0
    control_heater(heater)
    assert(heater.is_turned_on == True)

def test_control_heater_when_hot(): # 더울 때 히터에 대한 컨트롤을 확인하는 테스트
    heater = Heater()
    heater.current_temperature = 25.0
    heater.preferrend_temperature = 18.0
    control_heater(heater)
    assert(heater.is_turned_on == False)
```

### 2.2.3. 충분히 작다.
- 두 가지 (여러가지)일을 한 테스트 함수에서 해선 안된다.
```py
# Bad (하나에 다 넣기)
def test_heater():
    heater = Heater()
    ...
    assert(heater.is_turned_on == True)
    assert(read_temperature(heater) == "..")

# Good (2개로 분리)
def test_control_heater():
    ...
    assert(heater.is_turned_on == True)

def test_read_temperature():
    ...
    assert(read_temperature(heater) == "..")
```

### 2.2.4. 충분히 넓다.
- 들어올 수 있는 다양한 입력들을 충분히 고려해야 한다. 즉, **edge case**를 고려해야 한다
    - edge case 예. (자동 히터) )
        -현재온도가 희망온도보다 높을 때
        - 현재 온도가 희망 온도보다 낮을 때
        - 두 온도가 같을 때
        - 온도 하나를 알 수 없을 때
    - 예) 펠린드롬에서 빈 문자열은?
- **설계**를 통해 이런 예외를 어떻게 처리할 것인지 생각해야한다
- 이러한 엣지 케이스를 충분히 고려하지 않는다면 설계에 빈틈이 있다는 의미.

## 2.3. 파이썬의 `unittest`
- unittest : 파이썬에 기본적으로 내장되있는 모듈
```py
import unittest

class IsPalindromeTests(unittest.TestCase):
    # 모든 함수의 인자에 self를 첫번째 인자로 받아야한다.
    def test_level(self):
        self.assertTrue(is_palindrome("level"))
    def test_lever(self):
        self.assertFalse(is_palindrome("lever"))

...

unittest.main() # 실행!
```
- 이 밖에도 값이 같다.`self.assertEqual(함수(a), B)`도 있다. 종류가 많으니 하나씩 알아가기.




