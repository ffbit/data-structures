package shad.sorting;

public class MergeBottomUpSortTest extends AbstractSortTest {

    public MergeBottomUpSortTest(Integer[] source, Integer[] expected) {
        super(source, expected);
    }

    @Override
    public Sorter<Integer> sorter() {
        return new MergeBottomUpSort<Integer>();
    }

}
