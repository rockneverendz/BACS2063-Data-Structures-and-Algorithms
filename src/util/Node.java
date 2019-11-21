package util;

public class Node<E> {

    E data;
    Node<E> next;
    Node<E> prev;

    Node(Node<E> prev, E data, Node<E> next) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
