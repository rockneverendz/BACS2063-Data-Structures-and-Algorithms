package util;

public interface IList<E> extends ICollection<E> {

    /*
     * Description  : Inserts the specified element at the specified position in this list
     * Precondition : 
     * Postcondition: Data is added into the list
     * Return       : 
     */
    public void add(int index, E data);

    /*
     * Description  : Removes all of the elements from this list
     * Precondition : 
     * Postcondition: List is emptied
     * Return       : 
     */
    public void clear();

    /*
     * Description  : Returns the element at the specified position in this list
     * Precondition : List is not empty
     *                Index is valid
     * Postcondition: 
     * Return       : Data located on index
     */
    public E get(int index);

    /*
     * Description  : Returns the hash code value for this list
     * Precondition : 
     * Postcondition: 
     * Return       : Hash code value for this list
     */
    public int hashCode();

    /*
     * Description  : Return the index of data located in the list
     * Precondition : List is not empty
     * Postcondition: 
     * Return       : 0-n   - Index of the data location
     *              : -1    - Data doesn't exists in list.
     */
    public int indexOf(Object o);

    /*
     * Description  : Returns true if this list contains no elements.
     * Precondition : 
     * Postcondition: 
     * Return       : true  - this list contains no elements.
     */
    public boolean isEmpty();

    /*
     * Description  : Removes the element at the specified position in this list
     * Precondition : List is not empty
     *              : Index is valid
     * Postcondition: Data is removed from the list
     * Return       : 
     */
    public void remove(int index);

    /*
     * Description  : Returns the number of elements in this list
     * Precondition : 
     * Postcondition: 
     * Return       : The number of elements in this list
     */
    public int size();
}
