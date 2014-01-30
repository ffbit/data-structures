package shad.heap;

import java.util.Arrays;

public class BinaryHeap<E extends Comparable<E>> implements Heap<E> {
    private int size;
    private E[] holder;

    @SuppressWarnings("unchecked")
    public BinaryHeap(int capacity) {
        holder = (E[]) new Comparable[capacity];
    }

    public BinaryHeap() {
        this(16);
    }

    @Override
    public void insert(E e) {
        holder[size++] = e;
        siftUp(size - 1);
    }

    private void siftUp(int i) {
        int currentIndex = i;
        int parentIndex = (i - 1) / 2;

        while (holder[parentIndex].compareTo(holder[currentIndex]) > 0) {
            swap(currentIndex, parentIndex);
        }
    }

    private void swap(int i, int j) {
        E tmp = holder[i];
        holder[i] = holder[j];
        holder[j] = tmp;
    }

    @Override
    public E getMin() {
        return holder[0];
    }

    @Override
    public int size() {
        return size;
    }

}
