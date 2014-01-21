package shad.sorting;

import java.util.Arrays;

public class MergeBottomUpSort<E extends Comparable<E>> implements Sorter<E> {

    @Override
    public E[] sort(E[] source) {
        if (source.length <= 1) {
            return source;
        }

        int n = source.length;

        @SuppressWarnings("unchecked")
        E[] target = (E[]) new Comparable[n];

        for (int k = 1; k < n; k *= 2) {
            for (int i = 0; i < n; i += 2 * k) {
                merge(source, target, i, Math.min(i + k, n), Math.min(i + 2 * k, n));
            }

            source = Arrays.copyOf(target, n);
        }

        return target;
    }

    private void merge(E[] source, E[] target, int leftStart, int rightStart, int end) {
        int left = leftStart;
        int right = rightStart;

        for (int i = leftStart; i < end; i++) {
            if (right == end) {
                target[i] = source[left++];
            } else if (left == rightStart) {
                target[i] = source[right++];
            } else if (source[left].compareTo(source[right]) <= 0) {
                target[i] = source[left++];
            } else {
                target[i] = source[right++];
            }
        }
    }

}
