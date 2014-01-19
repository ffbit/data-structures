package shad.sorting;

public class InsertionSort<E extends Comparable<E>> implements Sorter<E> {

    @Override
    public E[] sort(E[] source) {
        for (int i = 0; i < source.length - 1; i++) {
            int current = i;
            int next = current + 1;

            while (current >= 0 &&
                    source[next].compareTo(source[current]) < 0) {
                swap(source, current--, next--);
            }
        }

        return source;
    }

    private void swap(E[] array, int a, int b) {
        E buf = array[a];
        array[a] = array[b];
        array[b] = buf;
    }

}
