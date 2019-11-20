public interface StackADT<T> {
    
    /*
     * Description  : Add item to the last location
     * Precondition : Item is not null
     * Postcondition: Item is added,
     *                Stack size increases
     * Return       : nothing
     */
    public void push(T item);

    /*
     * Description  : Returns the last item
     * Precondition : Stack is not empty
     * Postcondition: Item is removed,
     *                Stack size decreased
     * Return       : Last item
     */
    public T pop();
    
    /*
     * Description  : Return the last item
     * Precondition : Stack is not empty
     * Postcondition: 
     * Return       : Last item
     */
    public T peek();
    
    /*
     * Description  : Check the stack is empty or not
     * Precondition : 
     * Postcondition: 
     * Return       : True if empty,
     *                False if not
     */
    public boolean isEmpty();
    
    /*
     * Description  : Clear the stack
     * Precondition : 
     * Postcondition: Stack becomes empty 
     * Return       : 
     */
    public void clear();
}