package util;

@FunctionalInterface
public interface IComparator<T> {

    /*
     * Description  : Comapre the first object with the second object
     * Precondition : 
     * Postcondition: 
     * Return       :     1 - First object is larger than second
     *                    0 - Both object are equal
     *                   -1 - First object is smaller than second
     */
    int compare(T o1, T o2);

}
