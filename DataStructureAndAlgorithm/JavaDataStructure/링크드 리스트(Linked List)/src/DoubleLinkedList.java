public class DoubleLinkedList<T> {
    public Node<T> head = null;
    public Node<T> tail = null;

    public class Node<T> {
        T data;
        Node<T> prev = null;
        Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    public void addNode(T data) {
        if (this.head == null) {
            this.head = new Node<T>(data);
            this.tail = this.head;
        } else {
            Node<T> node = this.head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<T>(data);
            node.next.prev = node;
            this.tail = node.next;
        }
    }

    public void printAll() {
        if (this.head != null) {
            Node<T> node = this.head;
            System.out.println(node.data);
            while (node.next != null) {
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public T searchFromHead(T isdata) {
        if (this.head == null) {
            return null;
        }
        Node<T> node = this.head;
        while (node.next != null) {
            if (node.data == isdata) {
                return node.data;
            }
            node = node.next;
        }
        return null;
    }

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
}