package shad.heap;

public interface Heap<E extends Comparable<E>> {

    void insert(E e);

    int size();

    E getMin();

}
