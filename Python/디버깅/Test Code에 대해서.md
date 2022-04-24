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