package util;

public class LinkedListImpl<E>
        implements IList<E> {

    int size = 0;
    Node head;
    Node tail;

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
        
        if (size == 0)
            insertNew(data);
        else if (index == 0)
            insertHead(data);
        else if (index == size)
            insertTail(data);
        else
            insert(data, node(index));
        
        
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E get(int index) {
        checkElementIndex(index);
        return node(index).data;
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(E e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        
        // New head of the list
        head = node;
    }

    private void insertHead(E data) {
        // Create a new node, with it's next points to the old head.
        Node<E> node = new Node(null, data, head);
        
        // Update old head prev
        head.prev = node;
        
        // New head of the list
        head = node;
    }

    private void insertTail(E data) {
        // Create a new node, with it's next points to the old tail.
        Node<E> node = new Node(tail, data, null);

        // Update old tail next
        tail.next = node;

        // New tail of the list
        tail = node;
    }

    private void insert(E data, Node<E> oldNode) {
        // Create a new node with ;- 
        // prev pointing to what's pointed by oldNode.prev
        // next pointing to the oldNode.
        Node<E> node = new Node(oldNode.prev, data, oldNode);

        // Update oldNode.prev's next
        oldNode.prev.next = node;
        
        // Update oldNode's prev
        oldNode.prev = node;
    }
}