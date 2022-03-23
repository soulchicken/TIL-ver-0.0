# Collections

> 네이버 부스트코스 '머신러닝을 위한 파이썬' 강의 내용 정리

## Collections
- list, tuple, dict에 대한 Python Built-in 확장 자료 구조(모듈)
- 편의성, 실행 효율등을 사용자에게 제공함
- 아래의 모듈이 존재함
```py
from collections import deque
from collections import Counter
from collections import OrderedDict
from collections import defaultdict
from collections import namedtuple
```

### deque
- stack과 queue를 지원하는 모듈
- list에 비해 효율적인 자료 저장 방식을 지원함
- `append`, `pop`, `appendleft`, `popleft`
- 일반적인 리스트 사용
```py
import time

start_time = time.clock()
just_list = []
for i in range(10000):
    for j in range(10000):
        just_list.append(i)
        just_list.pop()
print(time.clock() - start_time, "seconds")
>>> 26.9465943 seconds
```
- deque 사용
```py
from collections import deque
import time

start_time = time.clock()
just_list = deque()
for i in range(10000):
    for j in range(10000):
        just_list.append(i)
        just_list.pop()
print(time.clock() - start_time, "seconds")
>>> 9.8335841 seconds
```

### OrderedDict
- Dict와 달리 데이터를 입력한 순서대로 dict를 반환함 
- 사용법
```py
from collections import OrderedDict
d = OrderedDict()
d['x'] = 100
d['y'] = 200
d['z'] = 300
d['l'] = 500
for k, v in d.items():
    print(k, v)
>>> x 100
>>> y 200
>>> z 300
>>> l 500
```
- Dict type 값을, value 또는 key 값으로 정렬(sort)할 때 사용 가능
```py
for k,v in OrderedDict(sorted(d.items(), key = lambda t: t[0])).items():
    print(k,v)
>>> l 500
>>> x 100
>>> y 200
>>> z 300

for k,v in OrderedDict(sorted(d.items(), key = lambda t: t[1])).items():
    print(k,v)
>>> x 100
>>> y 200
>>> z 300
>>> l 500
```

### defaultdict
- dict type의 값에 기본 값을 지정, 신규값 생성시 사용하는 방법
```py
d = dict()
print(d["first"])
>>> keyError

from collections import defaultdict
d = defaultdict(object) # defaultdict 생성
d = defaultdict(lambda : 0) # 기본값을 0으로 설정
print(d["first"])
>>> 0
```

### Counter
- sequence type의 data element 들의 갯수를 dict 형태로 반환
```py
from  collections import Counter

c = Counter()
c = Counter('gallanhad')
print(c) # 정렬까지해서 나타남
>>> Counter({'a': 3, 'l': 2, 'g': 1, 'n': 1, 'h': 1, 'd': 1})
```

### namedtuple
- tuple 형태로 data 구조체를 저장하는 방법
- 저장되는 data의 variable을 사전에 지정해서 저장함
```py
from  collections import namedtuple

Point = namedtuple('Point', ['x','y'])
p = Point(11, y = 22)
print(p[0] +  p[1])

x, y = p
print(x, y)
print(p.x + p.y)
print(Point(x=11, y=22))
>>> 33
>>> 11 22
>>> 33
>>> Point(x=11, y=22)
```