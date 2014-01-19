package shad.sorting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class SelectionSortTest {
    private Integer[] source;
    private Integer[] expected;

    public SelectionSortTest(Integer[] source, Integer[] expected) {
        this.source = source;
        this.expected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Integer[]{}, new Integer[]{}},
                {new Integer[]{1}, new Integer[]{1}},
                {new Integer[]{2, 1}, new Integer[]{1, 2}},
                {new Integer[]{2, 1, 1, 0}, new Integer[]{0, 1, 1, 2}},
                {new Integer[]{1, 2, 3}, new Integer[]{1, 2, 3}},
        });
    }

    @Test
    public void itShouldSort() throws Exception {
        Sorter<Integer> sorter = new SelectionSort<Integer>();

        assertThat(sorter.sort(source), is(expected));
    }

}
