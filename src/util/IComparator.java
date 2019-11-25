package util;

@FunctionalInterface
public interface IComparator<T> {
    int compare(T o1, T o2);
}
