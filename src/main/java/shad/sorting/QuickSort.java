package shad.sorting;

public class QuickSort<E extends Comparable<E>> implements Sorter<E> {

    @Override
    public E[] sort(E[] source) {
        sort(source, 0, source.length - 1);
        return source;
    }

    private void sort(E[] source, int low, int high) {
        if (high <= low) {
            return;
        }

        int pivotIndex = partition(source, low, high);
        sort(source, low, pivotIndex - 1);
        sort(source, pivotIndex + 1, high);
    }

    private int partition(E[] array, final int low, final int high) {
        E pivot = array[low];
        int left = low;
        int right = high + 1;

        while (true) {
            while (left < high && less(array[++left], pivot)) ;
            while (right > low && less(pivot, array[--right])) ;

            if (left >= right) {
                break;
            }

            swap(array, left, right);
        }

        swap(array, low, right);

        return right;
    }

    private boolean less(E x, E y) {
        return x.compareTo(y) < 0;
    }

    private void swap(E[] array, int i, int j) {
        E buffer = array[i];
        array[i] = array[j];
        array[j] = buffer;
    }

}
