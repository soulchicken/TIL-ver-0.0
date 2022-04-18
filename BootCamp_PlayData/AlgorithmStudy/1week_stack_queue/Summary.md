# 1 week - Stack & Queue

## 1. stack 스택
- 영어로 '쌓다' 라는 의미
- 목록, 리스트에서 접근이 한 쪽에서만 가능한 구조.
- LIFO (Last-In, First-Out)

### 1.1. 기능
- `push` : 스택에 (맨 위) 요소를 추가.
- `peek` : 스택에서 (맨 위) 요소를 봄.
- `pop` : 스택에서 (맨 위) 요소를 뺌.

### 1.2. 구현 방법
- `1. 직접 구현` `2. 이미 구현된 클래스 import`, `3. List를 스택으로 구현` 이 3가지 방법이 있다.
- Python의 경우 List가 스택으로 사용 가능하도록 구현되어있다.

#### 1.2.1. 직접 구현
```py
clss Stack(list):
    push = list.append
    
    def peek(self):
        return slef[-1]
    # pop 함수는 이미 리스트에 존재

s = Stack()
s.push(1) # s = [1]
s.push(5) # s = [1, 5]
s.push(10) # s = [1, 5, 10]
print(s.pop()) # 10 출력, s = [1, 5]
print(s.peek()) # 5 출력, s = [1, 5]
```

#### 1.2.2. List를 스택으로 활용
```py
s = []
s.append(1) # push! s = [1]
s.append(5) # push! s = [1, 5]
s.append(10) # push! s = [1, 5, 10]
print(s.pop()) # pop! "10 출력" s = [1, 5]
print(s[-1]) # peek! "5 출력" s = [1, 5]
```

## 2. Queue 큐
- 일이 처리되기를 기다리는 리스트
- 프로그래밍에서 목록, 리스트에서 접근이 양쪽에서 가능한 구조 (선착순 방식)
- FIFO(First-In, First-Out)가 기본 원리

### 2.1. 기능
- `put` : 큐에 (맨 위) 요소를 추가.
- `peek` : 큐에서 (맨 아래) 요소를 봄.
- `get` : 큐에서 (맨 아래) 요소를 뺌.

### 2.2. 구현 방법

#### 2.2.1. 직접 구현
```py
class Queue(list):
    put = list.append

    def peek(self):
        return self[0]
    def get(self):
        return pop(0)

q = Queue()
q.put(1) # put! q = [1]
q.put(5) # put! q = [1, 5]
q.put(10) #put!  q = [1, 5, 10]
print(q.get()) # get! 1 출력, q = [5, 10]
print(q.peek()) # peek! 5 출력 q = [5, 10]
```

#### 2.2.2. 구현된 클래스 import
```py
from queue import Queue
q = Queue()
q.put(1) # put! q = [1]
q.put(5) # put! q = [1, 5]
q.put(10) #put!  q = [1, 5, 10]
print(q.get()) # get! 1 출력, q = [5, 10]
print(q.peek()) # peek! 5 출력 q = [5, 10]
```

#### 2.2.3. List를 큐로 활용
```py
q = []
q.append(1) # put(1)! q = [1]
q.append(5) # put(5)! q = [1, 5]
q.append(10) #put(10)!  q = [1, 5, 10]
print(q.pop(0)) # get()! 1 출력, q = [5, 10]
print(q[0]) # peek! 5 출력 q = [5, 10]
```