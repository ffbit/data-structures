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

        int l = 0;
        int r = 0;

        for (int i = 0; i < source.length; i++) {
            if (l == left.length) {
                source[i] = right[r++];
            } else if (r == right.length) {
                source[i] = left[l++];
            } else if (left[l].compareTo(right[r]) < 0) {
                source[i] = left[l++];
            } else {
                source[i] = right[r++];
            }
        }

        return source;
    }

}
