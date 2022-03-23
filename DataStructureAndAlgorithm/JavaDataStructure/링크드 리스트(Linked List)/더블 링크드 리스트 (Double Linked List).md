# 더블 링크드 리스트 (Double Linked List)
- 이중 연결 리스트
- 양방향으로 연결. 싱글 링크드 리스트에서 한 방향으로만 탐색하는 점을 보완
- 노드의 prev 포인터가 추가된 모습을 볼 수 있다.
```java
public class Node<T> {
        T data;
        Node<T> prev = null;
        Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }
```
- 링크드 리스트의 맨 뒤에서부터 원하는 데이터를 탐색하는 기능 구현.
```java
public T searchFromTail(T isData) {
    if (this.head == null) {
        return null;
    } Node<T> node = this.tail;
    while (node != null) {
        if (node.data == isData) {
            return node.data;
        }
        node = node.prev;

    }
    return null;
}
```
- 특정 노드 앞에 데이터를 추가하는 기능이 가능하다.
```java
public boolean insertToFront(T existedData, T addData) {
    if (this.head == null) {
        this.head = new Node<>(addData);
        this.tail = this.head;
    } else if (this.head.data == existedData) {
        Node<T> newHead = new Node<>(addData);
        newHead.next = this.head;
        this.head = newHead;
        return true;
    } else {
        Node<T> node = this.head;
        while (node != null) {
            if (node.data == existedData) {
                Node<T> nodePrev = node.prev;
                nodePrev.next = new Node<T>(addData);
                nodePrev.next.next = node;
                nodePrev.next.prev = nodePrev;
                node.prev = nodePrev.next;
                return true;
            }
            node = node.next;
        }
    }
    return false;
}
```