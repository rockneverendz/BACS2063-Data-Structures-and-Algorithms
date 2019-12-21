package util;

public interface IArray {
    
    /*
     * Description  : Apply Merge Sorting algorithm to the array
     * Precondition :
     * Postcondition: Array is sorted at the given range 
     * Return       :
     */
    public void mergeSort(Object[] a, int low, int high, IComparator c);
    
}
