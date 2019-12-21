package util;

public interface IFilter<T> {
    
    /**
     * Determines whether elements should be filtered or not.
     *
     */
    
    public boolean matches(T element);
}
