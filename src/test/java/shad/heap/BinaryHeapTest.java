package shad.heap;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BinaryHeapTest {
    private Heap<Integer> heap;

    @Before
    public void setUp() throws Exception {
        heap = new BinaryHeap<Integer>();
    }

    @Test
    public void itShouldIncreaseSizeWhenInsertElement() throws Exception {
        heap.insert(0);

        assertThat(heap.size(), is(1));
    }

    @Test
    public void itShouldInsertAndGetMin() throws Exception {
        heap.insert(0);

        assertThat(heap.getMin(), is(0));
    }

    @Test
    public void itShouldSupportDynamicMinWhenInsert() throws Exception {
        heap.insert(1);
        heap.insert(-1);
        heap.insert(0);

        assertThat(heap.getMin(), is(-1));
    }

}
