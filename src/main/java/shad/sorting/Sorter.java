package shad.sorting;

public interface Sorter<E extends Comparable<E>> {

    E[] sort(E[] source);
}
