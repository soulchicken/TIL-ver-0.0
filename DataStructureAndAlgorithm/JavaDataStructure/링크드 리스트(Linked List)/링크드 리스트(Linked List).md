# 링크드 리스트 (Linked List)
- 연결 리스트. 순차적으로 연결된 공간에 데이터를 나열
- 떨어진 공간에 존재하는 데이터를 화살표로 연결해서 관리
<br>

## 1. 링크드 리스트 용어
- 노드(Node) : 데이터 저장 단위 (데이터 값, 포인터)로 구성
- 포인터(Pointer) : 각 노드 안에서 다음이나 이전 노드와의 연결 정보를 갖고 있는 공간


## 2. 장단점
- 장점
    - 미리 데이터 할당을 하지 않아도 된다 (배열과의 차이점)

- 단점
    - 저장공간의 효율이 좋지 않다
    - 연결 정보를 찾는 시간이 필요. 찾는 시간이 필요하다
    - 중간 데이터를 삭제시 데이터 연결을 재구성하는 번거로움이 있다.
  

## 3. JAVA에서 사용하는 방법 (Single Linked List)
- Node 클래스 형태
```java
// node 생성
public class Node <T> {
  T data; 
  Node<T> next = null;

  public Node(T data) {
    this.data = data;
  }
}
```
- SingleLinkedList 클래스 생성
```java
public class SingleLinkedList<T> {
    public Node<T> head = null;

    public class Node<T> {
        T data;
        Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }
    // 노드를 추가하는 매소드
    public void addNode(T data) {
        if (head == null) {
            head = new Node<T>(data);
        } else {
            Node<T> node = this.head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<T>(data);
        }
    }
    // 전체 노드를 출력하는 매소드
    public void PrintAllNode() {
        if (head != null) {
            Node<T> node = this.head;
            System.out.println(node.data);
            while (node.next != null) {
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

}
```
- 실습하기 위해 만든 main 매소드
```java
public class StudyLinkedList {
  public static void main(String[] args) {
    SingleLinkedList<Integer> MyLinkedList = new SingleLinkedList<>();
    MyLinkedList.addNode(1);
    // head의 데이터 : 1
    System.out.println(MyLinkedList.head.data);
    // head 다음 노드의 데이터 : 2
    MyLinkedList.addNode(2);
    System.out.println(MyLinkedList.head.next.data);
    // 노드에 3 추가
    MyLinkedList.addNode(3);
    // 전체 출력 (1 2 3이 출력됨)
    MyLinkedList.PrintAllNode();
  }
}
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

## 5. 데이터 사이에 데이터를 추가하기
~~~java
public Node<T> search (T data) {
    if (this.head == null) {
        return null;
    } else {
        Node<T> node = this.head;
        while (node != null) {
            if (node.data == data) {
                return node;
            } else {
                node = node.next;
            }
        }
        return null;
    }
}

public void addNodeInside (T data, T isData) {
    Node<T> searchedNode = this.search(isData);

    if (searchedNode == null) {
        this.addNode(data);
    } else {
        Node<T> nextNode = searchedNode.next;
        searchedNode.next = new Node<T>(data);
        searchedNode.next.next = nextNode;
    }
}
~~~

## 6. 데이터를 삭제하기
~~~java
public boolean delNode(T isData) {
    if (this.head == null) {
        return false;
    }
    Node<T> node = this.head;
    if (node.data == isData) {
        this.head = this.head.next;
        return true;
    }
    while (node.next != null) {
         if (node.next.data == isData) {
             node.next = node.next.next;
             return true;
         }
         node = node.next;
    }
    return false;
}
~~~