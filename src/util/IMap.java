package util;

public interface IMap<K, V> {
    /*
     * Why it's called Map instead of Dictionary?
     * https://stackoverflow.com/questions/2884068
     */

    /*
     * Description  : Returns the number of key-value mappings in this map.
     * Precondition : -
     * Postcondition: -
     * Return       : Number of key-value mappings in this map.
     */
    int size();

    /*
     * Description  : Returns the value to which the specified key is mapped, 
     *                or null if this map contains no mapping for the key.
     * Precondition : Element present in set
     * Postcondition: -
     * Return       : Value = to which the specified key is mapped
     *                null  = if this map contains no mapping for the key.
     */
    V get(Object key);

    /*
     * Description  : Associates the specified value with the specified key in this map.
     * Precondition : -
     * Postcondition: Value mapped with the specified key
     * Return       : Value = the previous value associated with key
     *                null  = if there was no mapping for key
     */
    V put(K key, V value);

    /*
     * Description  : Removes the mapping for a key from this map if it is present
     * Precondition : -
     * Postcondition: Key is removed
     * Return       : Value = the previous value associated with key
     *                null  = if there was no mapping for key.
     */
    V remove(Object key);

    /*
     * Description  : Returns true if this map contains no key-value mappings.
     * Precondition : -
     * Postcondition: -
     * Return       : true  = this map contains no key-value mappings.
     *                false = this map contains key-value mappings.
     */
    boolean isEmpty();

    /*
     * Description  : Removes all of the mappings from this map.
     * Precondition : -
     * Postcondition: The map will be empty
     * Return       : -
     */
    void clear();
    
    interface IEntry<K, V> {
    }
}
