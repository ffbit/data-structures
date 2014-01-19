package shad.sorting;

public class InsertionSortTest extends AbstractSortTest {

    public InsertionSortTest(Integer[] source, Integer[] expected) {
        super(source, expected);
    }

    @Override
    public Sorter<Integer> sorter() {
        return new InsertionSort<Integer>();
    }

}
