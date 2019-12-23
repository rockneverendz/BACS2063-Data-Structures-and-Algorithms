package util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Soo Cia Yang
 */
public class FilterImpl<T> implements Iterator<T> {

    private Iterator<? extends T> iterator;
    private IFilter<T> filter;
    private T nextElement;
    private boolean hasNext;

    public FilterImpl(Iterator<? extends T> iterator, IFilter<T> filter) {
        this.iterator = iterator;
        this.filter = filter;

        nextMatch();
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }

    @Override
    public T next() {
        if (!hasNext) {
            throw new NoSuchElementException();
        }

        return nextMatch();
    }

    private T nextMatch() {
        T oldMatch = nextElement;

        while (iterator.hasNext()) {
            T o = iterator.next();

            if (filter.matches(o)) {
                hasNext = true;
                nextElement = o;

                return oldMatch;
            }
        }

        hasNext = false;

        return oldMatch;
    }
}