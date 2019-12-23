package util;

/**
 * @author Soo Cia Yang
 */
public interface IFilter<T> {
    
    /**
     * Description  : Determines whether elements should be filtered or not.
     * Precondition : -
     * Postcondition: -
     * Return       : true  = satisfy all criteria
     *                false = does not satisfy one or more criteria
     */
    
    public boolean matches(T element);
}
