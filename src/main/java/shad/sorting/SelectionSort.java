package shad.sorting;

public class SelectionSort<E extends Comparable<E>> implements Sorter<E> {

    @Override
    public E[] sort(E[] source) {
        for (int i = 0; i < source.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < source.length; j++) {
                if (source[j].compareTo(source[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            swap(source, i, minIndex);
        }

        return source;
    }

    private void swap(E[] array, int a, int b) {
        E buf = array[a];
        array[a] = array[b];
        array[b] = buf;
    }

}
