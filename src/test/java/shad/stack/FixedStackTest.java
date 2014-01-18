package shad.stack;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FixedStackTest {

    @Test
    public void itShouldCreateStackWithSpecifiedCapacity() throws Exception {
        FixedStack stack = new FixedStack(1);

        assertThat(stack.capacity(), is(1));
    }

    @Test
    public void itShouldPushAndPopElement() throws Exception {
        FixedStack<Integer> stack = new FixedStack<Integer>(1);

        stack.push(2);

        assertThat(stack.pop(), is(2));
    }

    @Test
    public void itShouldBeFistInputLastOutput() throws Exception {
        FixedStack<Integer> stack = new FixedStack<Integer>(2);

        stack.push(1);
        stack.push(2);

        assertThat(stack.pop(), is(2));
        assertThat(stack.pop(), is(1));
    }

}
