package shad.sorting;

public class SelectionSortTest extends AbstractSortTest {

    public SelectionSortTest(Integer[] source, Integer[] expected) {
        super(source, expected);
    }

    @Override
    public Sorter<Integer> sorter() {
        return new SelectionSort<Integer>();
    }

}
