package shad.stack;

import org.junit.Test;

import static com.googlecode.catchexception.CatchException.verifyException;
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
    public void itShouldPushAndPeekElement() throws Exception {
        FixedStack<Integer> stack = new FixedStack<Integer>(1);

        stack.push(2);

        assertThat(stack.peek(), is(2));
        assertThat(stack.size(), is(1));
    }

    @Test
    public void itShouldBeFistInputLastOutput() throws Exception {
        FixedStack<Integer> stack = new FixedStack<Integer>(2);

        stack.push(1);
        stack.push(2);

        assertThat(stack.pop(), is(2));
        assertThat(stack.pop(), is(1));
    }

    @Test
    public void itShouldIncreaseSize() throws Exception {
        FixedStack<Integer> stack = new FixedStack<Integer>(1);

        assertThat(stack.size(), is(0));

        stack.push(1);
        assertThat(stack.size(), is(1));
    }

    @Test
    public void itShouldDecreaseSize() throws Exception {
        FixedStack<Integer> stack = new FixedStack<Integer>(1);

        stack.push(1);
        assertThat(stack.size(), is(1));

        stack.pop();
        assertThat(stack.size(), is(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void itShouldNotAllowToCreateStackWithNonPositiveCapacity() throws Exception {
        new FixedStack<Integer>(0);
    }

    @Test
    public void itShouldNotAllowPopOnEmptyStack() throws Exception {
        FixedStack<Integer> stack = new FixedStack<Integer>(1);

        verifyException(stack, IllegalArgumentException.class).pop();
    }

    @Test
    public void itShouldNotAllowPeekOnEmptyStack() throws Exception {
        FixedStack<Integer> stack = new FixedStack<Integer>(1);

        verifyException(stack, IllegalArgumentException.class).peek();
    }

    @Test
    public void itShouldNotAllowPushInFullStack() throws Exception {
        FixedStack<Integer> stack = new FixedStack<Integer>(1);

        stack.push(1);

        verifyException(stack, IllegalArgumentException.class).push(2);
    }

}
