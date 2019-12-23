package util;

public interface ISet<E> extends ICollection<E> {

    /*
     * Description  : Adds the specified element to this set if it is not already present
     * Precondition : Element not present in set
     * Postcondition: Element is added into set
     * Return       : -
     */
    public void add(E e);

    /*
     * Description  : Adds all of the element(s) in the specified collection to this set 
     *                if they're not already present present
     * Precondition : Element(s) not present in set
     * Postcondition: Element(s) is added into set
     * Return       : -
     */
    public void addAll(ICollection<? extends E> c);

    /*
     * Description  : Removes all of the elements from this set
     * Precondition : -
     * Postcondition: Collection is cleared
     * Return       : -
     */
    public void clear();

    /*
     * Description  : Returns true if this set contains the specified element
     * Precondition : -
     * Postcondition: -
     * Return       : true   = Element present in set
     *                false  = Element not present in set
     */
    public boolean contains(Object o);

    /*
     * Description  : Returns true if this set contains no elements
     * Precondition : -
     * Postcondition: -
     * Return       : true   = Set is empty
     *                false  = Set is not empty
     */
    public boolean isEmpty();

    /*
     * Description  : Removes the specified element from this set if it is present
     * Precondition : Element exists inside set
     * Postcondition: Element is removed from set
     * Return       : true   = Element is removed from set
     *                false  = Element is not removed from set
     */
    public boolean remove(Object o);

    /*
     * Description  : Returns the number of elements in this set
     * Precondition : -
     * Postcondition: -
     * Return       : The number of elements in this set
     */
    public int size();

    /*
     * Description  : Returns an array containing all of the elements in this set
     * Precondition : -
     * Postcondition: -
     * Return       : Array containing all of the elements in this set
     */
    public Object[] toArray();
}
