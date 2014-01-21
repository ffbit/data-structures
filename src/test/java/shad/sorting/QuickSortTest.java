package shad.sorting;

public class QuickSortTest extends AbstractSortTest {

    public QuickSortTest(Integer[] source, Integer[] expected) {
        super(source, expected);
    }

    @Override
    public Sorter<Integer> sorter() {
        return new QuickSort<Integer>();
    }

}
