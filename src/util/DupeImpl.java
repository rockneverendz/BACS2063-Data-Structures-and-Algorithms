package util;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DupeImpl<T> implements Iterator<T> {

    private Iterator<? extends T> iterator;
    HashSetImpl<T> hashSet;
    private T nextElement;
    private boolean hasNext;

    public DupeImpl(Iterator<? extends T> iterator) {
        this.iterator = iterator;
        hashSet = new HashSetImpl();
        nextDupe();
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

        return nextDupe();
    }

    private T nextDupe() {
        T oldMatch = nextElement;

        while (iterator.hasNext()) {
            T o = iterator.next();

            if (!hashSet.add(o)) {
                hasNext = true;
                nextElement = o;

                return oldMatch;
            }
        }

        hasNext = false;

        return oldMatch;
    }
}
