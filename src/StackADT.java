public interface StackADT<T> {
    
    /**
     * Description: add newEntry to the last location
     * Precondition: newEntry is not null
     * Postcondition: newEntry is added
     *                stack size increase.Return: nothing
     * Return: nothing
     */
    public void push(T newEntry);

    /**
     * Description: to return the last item
     * Precondition: the stack is not empty
     * Postcondition: the item is removed
     *                stack size decreased
     * Return: the last item
     */
    public T pop();
    
    /**
     * Description: to return the last item
     * Precondition: the stack is not empty
     * Postcondition: nothing
     * Return: the last item
     */
    public T peek();
    
    /**
     * Description: the check the stack is empty or not
     * Precondition: nothing
     * Postcondition: 
     * Return: true if empty
     *         false if not
     */
    public boolean isEmpty();
    
    /**
     * Description: to clear the stack
     * Precondition: none
     * Postcondition: the stack becomes empty 
     * Return: none
     */
    public void clear();
}