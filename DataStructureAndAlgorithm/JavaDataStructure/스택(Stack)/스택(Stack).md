# 스택 (Stack)
<br>

## 1. 스텍 구조
- LIFO(Last-In,First-Out), FILO(First In, Last-Out) 방식 (큐과 반대)
- 가장 먼저 넣은 데이터를 가장 나중에 빼는 구조

## 2. 장단점
- 장점
  - 단순해서 구현하기 쉽다
  - 데이터 저장 / 읽기 속도가 빠르다
- 단점
  - 데이터 최대 갯수를 미리 정해야 한다
  - 저장 공간의 낭비가 발생할 수 있다
  - 단순하고 빠른 성능을 위해 사용. 배열을 활용해 구현하는게 일반적
  
## 3. JAVA에서 사용하는 방법
- ```java.util```패키지에서 Stack 클래스를 제공
- ```push(item)``` : Input, 데이터 넣기
- ```pop()``` : Output, 데이터를 빼서 리턴

```java
// 스택 클래스 임포트
import java.util.Stack;
```

```java
// 스택 선언하기
Stack<Integer> stack_int = new Stack<Integer>(); // 정수형 스택 선언
```
```java
// 스택에 1, 2, 3 추가
stack_int.push(1);
stack_int.push(2);
stack_int.push(3);
System.out.println(stack_int); // 데이터가 잘 들어왔는지 확인
```
```java
// 데이터 제거 (pop) 2번 해보기
int pop1 = stack_int.pop();
int pop2 = stack_int.pop();
System.out.println(pop1 + "," + pop2);
```

## 4. 사용처
- 멀티 태스킹을 위한 프로세스 스케쥴링 방식을 구현하기 위해 많이 사용된다.
- 특별한 장단점이 존재하지는 않는다.