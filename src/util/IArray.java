package util;

/**
 * @author Jarrod
 */
public interface IArray {
    
    /*
     * Description  : Sort the array using the comparator provided
     * Precondition : -
     * Postcondition: Array is sorted
     * Return       : -
     */
    public void sort(Object[] a, IComparator c);
    
}
