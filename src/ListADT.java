public interface ListADT<T> {
   
    /*
     * Description  : Return item located on specified index
     * Precondition : List is not empty
     *                Index is valid
     * Postcondition: 
     * Return       : Item located on index
     */
    public T get(int index);
    
    /*
     * Description  : Return the index of item located in the list
     * Precondition : List is not empty
     * Postcondition: 
     * Return       : Index of the item location
     */
    public T search(T item);
    
    /*
     * Description  : Return item located on specified index
     * Precondition : 
     * Postcondition: Item is added into the list
     * Return       : Item located on specified index
     */
    public void insert(int index,T item);
    
    /*
     * Description  : Remove item located on given index
     * Precondition : List is not empty
     * Postcondition: Item is removed from the list
     * Return       : 
     */
    public void remove(int index);
}
