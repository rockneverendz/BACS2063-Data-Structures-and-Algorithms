package util;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListImpl<E>
        implements IList<E> {
    
    private int size = 0;
    private Node head;
    private Node tail;
    
    @Override
    public void add(int index, E data) {
        checkPositionIndex(index);

        /* 
         * The cases:
         * 1. An empty linked list,
         * 2. The head (before the current first item) of the linked list, i = 0,
         * 3. The position beyond the last (the current tail) item of the linked list, i = N,
         * 4. The other positions of the linked list, i = [1..N-1].
         */
        if (size == 0) {
            insertNew(data);
        } else if (index == 0) {
            insertHead(data);
        } else if (index == size) {
            insertTail(data);
        } else {
            insertMiddle(data, node(index));
        }
    }

    @Override
    public void clear() {
        // Clearing all of the links between nodes is "unnecessary", but:
        // - helps a generational GC if the discarded nodes inhabit
        //   more than one generation
        // - is sure to free memory even if there is a reachable Iterator
        Node<E> temp = head;
        while (temp != head) {
            Node<E> next = temp.next;
            temp.data = null;
            temp.next = null;
            temp.prev = null;
            temp = next;
        }

        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        checkElementIndex(index);
        return node(index).data;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        for (Node<E> x = head; x != null; x = x.next) {
            if (o.equals(x.data)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void remove(int index) {
        checkElementIndex(index);

        /*
         * For remove(i), there are three (legal) possibilities, i.e. index i is:
         *
         * The head (the current first item) of the linked list, i = 0, it affects the head pointer
         * The tail of the linked list, i = N-1, it affects the tail pointer
         * The other positions of the linked list, i = [1..N-2].
         */
        if (index == 0) {
            removeHead();
        } else if (index == size - 1) {
            removeTail();
        } else {
            removeMiddle(node(index));
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E e) {
        if (tail != null) {
            insertTail(e);
        } else {
            insertNew(e);
        }
    }

    @Override
    public boolean remove(Object o) {
        remove(indexOf(o));
        return true;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        for (Node<E> node = head;
                node != null;
                node = node.next) {
            array[i++] = node.data;
        }
        return array;
    }

    private static class Node<E> {

        E data;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E data, Node<E> next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    /*
     * Tells if the argument is the index of an existing element.
     */
    private void checkElementIndex(int index) {
        if (!(index >= 0 && index < size)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    /*
     * Tells if the argument is the index of a valid position for an iterator or
     * an add operation.
     */
    private void checkPositionIndex(int index) {
        if (!(index >= 0 && index <= size)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    /*
     * Constructs an IndexOutOfBoundsException detail message.
     */
    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    /*
     * Returns the (non-null) Node at the specified element index.
     */
    Node<E> node(int index) {

        // If index is under half part of the list, loop from head
        // Else loop from tail.
        // Best case O(1)
        // Worst case O(n)
        if (index < (size >> 1)) {
            Node<E> node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node<E> node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
    }

    private void insertNew(E data) {
        // Create a new node
        Node<E> node = new Node(null, data, null);

        // New head and tail of the list
        head = node;
        tail = node;

        size++;
    }

    private void insertHead(E data) {
        // Create a new node, with it's next points to the old head.
        Node<E> node = new Node(null, data, head);

        // Update old head prev
        head.prev = node;

        // New head of the list
        head = node;

        size++;
    }

    private void insertTail(E data) {
        // Create a new node, with it's next points to the old tail.
        Node<E> node = new Node(tail, data, null);

        // Update old tail next
        tail.next = node;

        // New tail of the list
        tail = node;

        size++;
    }

    private void insertMiddle(E data, Node<E> oldNode) {
        // Create a new node with ;- 
        // prev - pointing to what's pointed by oldNode.prev
        // next - pointing to the oldNode.
        Node<E> node = new Node(oldNode.prev, data, oldNode);

        // Update oldNode.prev's next
        oldNode.prev.next = node;

        // Update oldNode's prev
        oldNode.prev = node;

        size++;
    }

    private void removeHead() {
        // Temporary store the head
        Node oldHead = head;

        // Transfer the head
        head = oldHead.next;
        head.prev = null;

        // Help garbage collection
        // oldHead.prev = null; // head's prev is already a null
        oldHead.data = null;
        oldHead.next = null;

        size--;
    }

    private void removeTail() {
        // Temporary store the tail
        Node oldTail = tail;

        // Transfer the tail
        tail = oldTail.prev;
        tail.prev = null;

        // Help garbage collection
        oldTail.prev = null;
        oldTail.data = null;
        // oldTail.next = null; // tail's next is already a null        

        size--;
    }

    private void removeMiddle(Node<E> node) {
        // Temporary store the node
        Node oldNode = node;
        Node nextNode = node.next;
        Node prevNode = node.prev;

        // Relink both next and prev
        nextNode.prev = prevNode;
        prevNode.next = nextNode;

        // Help garbage collection
        oldNode.prev = null;
        oldNode.data = null;
        oldNode.next = null;

        size--;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedListImpl{size=")
                .append(size)
                .append(", head=")
                .append(head)
                .append(", tail=")
                .append(tail)
                .append("}\n");
        
        sb.append("name, brand, price, stock, model, Processor.getModel(), Graphics.getModel(), memory, storage, display, weight, color\n");
        
        Node<E> node = head;
        while(node != null) {
            sb.append(node.data.toString());
            sb.append('\n');
            node = node.next;
        }
        
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }
    
    private class LinkedListIterator implements Iterator<E> {
        private Node<E> lastReturned;
        private Node<E> next;
        private int nextIndex;

        LinkedListIterator() {
            next = head;
            nextIndex = 0;
        }

        public boolean hasNext() {
            return nextIndex < size;
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.data;
        }
    }
}
