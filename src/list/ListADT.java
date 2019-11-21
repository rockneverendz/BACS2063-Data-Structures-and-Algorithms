package list;

public interface ListADT<E> {
   
    /*
     * Description  : Returns the element at the specified position in this list
     * Precondition : List is not empty
     *                Index is valid
     * Postcondition: 
     * Return       : Data located on index
     */
    public E get(int index);
    
    /*
     * Description  : Return the index of data located in the list
     * Precondition : List is not empty
     * Postcondition: 
     * Return       : Index of the data location
     */
    public E indexOf(E data);
    
    /*
     * Description  : Inserts the specified element at the specified position in this list
     * Precondition : 
     * Postcondition: Data is added into the list
     * Return       : Data located on specified index
     */
    public void add(int index,E data);
    
    /*
     * Description  : Removes the element at the specified position in this list
     * Precondition : List is not empty
     * Postcondition: Data is removed from the list
     * Return       : 
     */
    public void remove(int index);
    
    /*
     * Description  : Returns the number of elements in this list
     * Precondition : List is not empty
     * Postcondition: Data is removed from the list
     * Return       : 
     */
    public int size();
}
