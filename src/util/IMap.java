package util;

public interface IMap<K, V> {

    /*
     * Description  : Returns the number of key-value mappings in this map.
     * Precondition : 
     * Postcondition: 
     * Return       : Number of key-value mappings in this map.
     */
    int size();

    /*
     * Description  : Returns the value to which the specified key is mapped, 
     *                or null if this map contains no mapping for the key.
     * Precondition : Element present in set
     * Postcondition: 
     * Return       : Value - to which the specified key is mapped
     *                null  - if this map contains no mapping for the key.
     */
    V get(Object key);

    /*
     * Description  : Associates the specified value with the specified key in this map.
     * Precondition : 
     * Postcondition: Value mapped with the specified key
     * Return       : Value - the previous value associated with key
     *                null  - if there was no mapping for key
     */
    V put(K key, V value);

    /*
     * Description  : Removes the mapping for a key from this map if it is present
     * Precondition : 
     * Postcondition: Key is removed
     * Return       : Value - the previous value associated with key
     *                null  - if there was no mapping for key.
     */
    V remove(Object key);

    /*
     * Description  : Returns true if this map contains no key-value mappings.
     * Precondition : 
     * Postcondition: 
     * Return       : true  - this map contains no key-value mappings.
     *                false - this map contains key-value mappings.
     */
    boolean isEmpty();

    /*
     * Description  : Returns true if this map contains a mapping for the specified key.
     * Precondition : 
     * Postcondition: 
     * Return       : true  - this map contains a mapping for the specified key.
     *                false - this map contains no mapping for the specified key.
     */
    boolean containsKey(Object key);

    /*
     * Description  : Returns true if this map maps one or more keys to the specified value.
     * Precondition : 
     * Postcondition: 
     * Return       : true  - this map maps one or more keys to the specified value.
                      false - no key maps to the specified value.
     */
    boolean containsValue(Object value);

    /*
     * Description  : Removes all of the mappings from this map.
     * Precondition : 
     * Postcondition: The map will be empty
     * Return       :
     */
    void clear();
}
