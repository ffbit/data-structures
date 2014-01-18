package shad.stack;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DynamicStackTest {

    @Test
    public void itShouldCreateStackWithSpecifiedInitialCapacity() throws Exception {
        DynamicStack stack = new DynamicStack(1);

        assertThat(stack.capacity(), is(1));
    }

    @Test
    public void itShouldCreateEmptyStack() throws Exception {
        DynamicStack stack = new DynamicStack(1);

        assertThat(stack.size(), is(0));
    }

}
