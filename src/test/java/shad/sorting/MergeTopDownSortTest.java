package shad.sorting;

public class MergeTopDownSortTest extends AbstractSortTest {

    public MergeTopDownSortTest(Integer[] source, Integer[] expected) {
        super(source, expected);
    }

    @Override
    public Sorter<Integer> sorter() {
        return new MergeTopDownSort<Integer>();
    }

}
