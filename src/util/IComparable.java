package util;

public interface IComparable<T> {

    /*
     * Description  : Compares this object with the specified object for order
     * Precondition : 
     * Postcondition: 
     * Return       :     1 - This object is larger than target
     *                    0 - Both object are equal
     *                   -1 - This object is smaller than target
     */
    public int compareTo(T o);
    
}
