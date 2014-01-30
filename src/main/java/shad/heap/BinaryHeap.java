package shad.heap;

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
        int parentIndex = getParentIndex(i);

        while (less(currentIndex, parentIndex)) {
            swap(currentIndex, parentIndex);
            currentIndex = parentIndex;
            parentIndex = getParentIndex(currentIndex);
        }
    }

    private int getParentIndex(int i) {
        return (i - 1) / 2;
    }

    private boolean less(int i, int j) {
        return holder[i].compareTo(holder[j]) < 0;
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
    public E remove() {
        E e = holder[0];
        siftDown();

        return e;
    }

    private void siftDown() {
        holder[0] = holder[--size];

        int currentIndex = 0;

        while (currentIndex < size / 2) {
            int leftChildIndex = getLeftChildIndex(currentIndex);
            int rightChildIndex = getRightChildIndex(currentIndex);

            if (rightChildIndex < size
                    && less(rightChildIndex, leftChildIndex)) {
                swap(currentIndex, rightChildIndex);
                currentIndex = rightChildIndex;
            } else if (less(leftChildIndex, currentIndex)) {
                swap(currentIndex, leftChildIndex);
                currentIndex = leftChildIndex;
            } else {
                break;
            }
        }
    }

    private int getLeftChildIndex(int currentIndex) {
        return 2 * currentIndex + 1;
    }

    private int getRightChildIndex(int currentIndex) {
        return 2 * currentIndex + 2;
    }

    @Override
    public int size() {
        return size;
    }

}
