# 5 week - Hash

## 1. 해시란?
- 데이터를 다루는 기법 중 하나로 검색과 저장이 아주 용이한 구조
- key와 value 쌍으로 데이터를 저장한다.
- key와 value 사이엔 해시함수가 자리잡고 있다. 함수로 key를 변환하면 value로 갈 수 있다.

## 2. 해시함수란?
- 임의의 길이를 갖는 메시지를 입력받아 고정된 길이의 해시 값을 출력하는 함수

## 3. 해시 구현 방법
**딕셔너리 클래스 활용**
### 3.1. 딕셔너리 삽입
```py
hash = dict() # or hash = {}

hash[1] = 'apple' # key = 1, value = 'apple'
hash['banana'] = 2 # key = 'banana' value = 2
hash[(4,5)] = [1,2,3] # key = (4,5) value = [1,2,3]
hash[10] = dict({1:'a', 2:'b'})
# hash[[1,2,3]] = 5 리스트는 키로 사용 불가
# hash[{1,2,3}] = 'orange'  집합은 키로 사용 불가
```
### 3.2. 딕셔너리 수정
- 위에 만든 hash 딕셔너리 활용
```py
hash[1] = 'melon' # apple 에서 melon으로 바뀜
hash['banana'] = 10 # 2에서 10으로 바뀜
```

### 3.3. 딕셔너리 값 추출
- 추출하면 딕셔너리에서 사라짐
- 3.2에서 사용한 hash 딕셔너리 활용
```py
print(hash.pop(1))
>>> melon
print(hash.pop('banana'))
>>> 10
```

### 3.4. 딕셔너리 값 삭제
- 반환없이 삭제만 함
- 3.2에서 사용한 hash 딕셔너리 활용
```py
del hash[1] # key = 1, value = melon 삭제
del hash['banana'] # key = 'banana' value = 10 삭제
```

## 4. 딕셔너리 활용
- 딕셔너리 루프
- 딕셔너리 정렬

### 4.1. 딕셔너리 루프
- `hash.keys()` : 키값 모아서 리스트
- `hash.values()` : 벨류값 모아서 리스트
- `hash.items()` : (키,벨류) 튜플을 모아서 리스트

```py
hash = dict()
for i in range(1,6):
    hash[i] = i**2
for k in hash.keys():
    print(k, end = ' ')
print()
>>> 1 2 3 4 5

for v in hash.values():
    print(v, end = ' ')
print()
>>> 1 4 9 16 25

for k, v in hash.items():
    print(k,v, end = ', ')
print()
>>> 1 1, 2 4, 3 9, 4 16, 5 25
```

### 4.2. 딕셔너리 정렬
- `sorted()` : 언제나 리스트 타입으로 반환됨

### 4.2.1. 오름차순 정렬
```py
hash = dict({1 : 10, 3 : 12, 5 : 7, 7 : 6, 4 : 5})

# keys로 정렬
sorted( hash.keys(), key = lambda x : x)
>>> [1, 3, 4, 5, 7]

# values로 정렬
sorted( hash.values(), key = lambda x : x)
>>> [5, 6, 7, 10, 12]

# items로 정렬
sorted( hash.items() key = lambda x : x)
>>> [(1, 10), (3, 12), (4, 5), (5, 7), (7, 6)]
```

### 4.2.2. 내림차순 정렬
```py
hash = dict({1 : 10, 3 : 12, 5 : 7, 7 : 6, 4 : 5})

# keys로 정렬
sorted( hash.keys(), key = lambda x : -x)
>>> [7, 5, 4, 3, 1]
# values로 정렬
sorted( hash.values(), key = lambda x : -x)
>>> [12, 10, 7, 6, 5]

# items로 정렬

# 아래처럼 하면 에러가 나온다. 튜플에는 마이너스 연산을 할 수 없다.
# sorted( hash.items() key = lambda x : -x)

sorted( hash.items() key = lambda x : -x[1]) # value로 내림차순 정렬
>>> [(3, 12), (1, 10), (5, 7), (7, 6), (4, 5)]
```