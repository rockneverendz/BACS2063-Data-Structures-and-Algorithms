public interface CollectionADT<E> {

    /*
     * Description  : Add element into collection
     * Precondition : Collection exists
     * Postcondition: Element is added into collection
     * Return       : true   - Element is added
     *                false  - Element is not added
     */
    public boolean add(E e);
    
    /*
     * Description  : Removes all of the elements from this collection
     * Precondition : 
     * Postcondition: Collection is cleared
     * Return       : 
     */
    public void clear();
    
    /*
     * Description  : Compares the specified object with this collection for equality
     * Precondition : 
     * Postcondition: 
     * Return       : true   - Elements are the same
     *                false  - Elements are not the same
     */
    public boolean equals(Object o);
    
    /*
     * Description  : Returns the hash code value for this collection
     * Precondition : 
     * Postcondition: 
     * Return       : Hash code value for this collection
     */
    public int hashCode();
    
    /*
     * Description  : Returns true if this collection contains no elements
     * Precondition : 
     * Postcondition: 
     * Return       : true   - Collection is empty
     *                false  - Collection is not empty
     */
    public boolean isEmpty();
    
    /*
     * Description  : Removes a single instance of the specified element from this collection, if it is present
     * Precondition : Element exists inside collection
     * Postcondition: Element is removed from collection
     * Return       : true   - Element is removed from collection
     *                false  - Element is not removed from collection
     */
    public boolean remove(Object o);
    
    /*
     * Description  : Returns the number of elements in this collection
     * Precondition : 
     * Postcondition: 
     * Return       : true   - Element is removed from collection
     *                false  - Element is not removed from collection
     */
    public int size();
    
    /*
     * Description  : Returns an array containing all of the elements in this collection.
     * Precondition : 
     * Postcondition: 
     * Return       : Array containing all of the elements in this collection.
     */
    public Object[] toArray();
}