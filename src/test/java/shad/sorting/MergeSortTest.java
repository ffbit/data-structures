package shad.sorting;

public class MergeSortTest extends AbstractSortTest {

    public MergeSortTest(Integer[] source, Integer[] expected) {
        super(source, expected);
    }

    @Override
    public Sorter<Integer> sorter() {
        return new MergeSort<Integer>();
    }

}
