package shad.sorting;

import java.util.Arrays;

public class MergeSort<E extends Comparable<E>> implements Sorter<E> {

    @Override
    public E[] sort(E[] source) {
        if (source.length <= 1) {
            return source;
        }

        E[] left = sort(Arrays.copyOfRange(source, 0, source.length / 2));
        E[] right = sort(Arrays.copyOfRange(source, left.length, source.length));

        int i = 0;
        int j = 0;
        int k = 0;

        while (k < source.length) {
            if (i == left.length) {
                source[k] = right[j++];
            } else if (j == right.length) {
                source[k] = left[i++];
            } else if (left[i].compareTo(right[j]) < 0) {
                source[k] = left[i++];
            } else {
                source[k] = right[j++];
            }

            k++;
        }

        return source;
    }

}
