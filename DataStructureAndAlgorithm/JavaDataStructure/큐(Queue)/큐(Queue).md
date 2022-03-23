# 큐 (Queue)
<br>

## 1. 큐 구조
- FIFO(First-In,First-Out), LILO(Last In, Last-Out) 방식 (스텍과 반대)
- 가장 먼저 넣은 데이터가 가장 먼저 꺼내는 구조

## 2. 용어
- Enqueue : Input, 데이터 넣기
- Dequeue : Output, 데이터 빼기

## 3. JAVA에서 사용하는 방법
- ```java.util```패키지에서 Queue 클래스를 제공 (LinkedList 클래스를 사용해야함)
- Enqueue : Queue 클래스에서 ```add(value)``` 또는 ```offer(value)``` 메서드
- Dequeue : Queue 클래스에서 ```poll()``` 또는 ```remove()``` 메서드

```java
// 꼭 import 해야하는 2가지
import java.util.LinkedList;
import java.util.Queue;
```

```java
// 큐 선언하기
Queue<Integer> queue_int = new LinkedList<Integer>();
Queue<String> queue_str = new LinkedList<String>();
```
```java
// 데이터 추가 (add 또는 offer) : 리턴 값으로 true가 나오는 것을 확인 가능
boolean add = queue_int.add(1);
boolean off = queue_int.offer(1);
System.out.println(add);
System.out.println(off);
System.out.println(queue_int); // 두 값이 들어온 것을 확인 가능
```
```java
// 데이터 제거 (poll, remove)
int poll = queue_int.poll();
System.out.println(poll);
int remove = queue_int.remove();
System.out.println(remove);
```

## 4. 사용처
- 멀티 태스킹을 위한 프로세스 스케쥴링 방식을 구현하기 위해 많이 사용된다.
- 특별한 장단점이 존재하지는 않는다.