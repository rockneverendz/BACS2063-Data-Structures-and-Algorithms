package list;

public class LinkedListImpl<E> implements ListADT<E> {

    Node head;
    Node tail;

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E indexOf(Object data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(int index, E data) {
        
        // Create a new node
        Node newNode = new Node(data);

        // If the Linked List is empty, 
        // then make the new node as head 
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            if (index == size)
                linkLast(element);
            else
                linkBefore(element, node(index));
        }

        // Return the list by head 
        return list;
    }

    @Override
    public void remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
