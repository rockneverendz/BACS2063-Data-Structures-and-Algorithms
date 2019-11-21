package list;

public class Node<E> {
    E data;
    Node next;

    Node(E data) {
        this.data = data;
        this.next = null;
    }
}