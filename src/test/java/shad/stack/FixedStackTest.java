package shad.stack;

import org.junit.Test;

import java.util.NoSuchElementException;

import static com.googlecode.catchexception.CatchException.verifyException;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FixedStackTest {
    private FixedStack<Integer> stack;

    @Test
    public void itShouldCreateStackWithSpecifiedCapacity() throws Exception {
        stack = new FixedStack<Integer>(1);

        assertThat(stack.capacity(), is(1));
    }

    @Test
    public void itShouldPushAndPopElement() throws Exception {
        stack = new FixedStack<Integer>(1);

        stack.push(2);

        assertThat(stack.pop(), is(2));
    }

    @Test
    public void itShouldPushAndPeekElement() throws Exception {
        stack = new FixedStack<Integer>(1);

        stack.push(2);

        assertThat(stack.peek(), is(2));
        assertThat(stack.size(), is(1));
    }

    @Test
    public void itShouldBeFistInputLastOutput() throws Exception {
        stack = new FixedStack<Integer>(2);

        stack.push(1);
        stack.push(2);

        assertThat(stack.pop(), is(2));
        assertThat(stack.pop(), is(1));
    }

    @Test
    public void itShouldIncreaseSize() throws Exception {
        stack = new FixedStack<Integer>(1);

        assertThat(stack.size(), is(0));

        stack.push(1);
        assertThat(stack.size(), is(1));
    }

    @Test
    public void itShouldDecreaseSize() throws Exception {
        stack = new FixedStack<Integer>(1);

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
        stack = new FixedStack<Integer>(1);

        verifyException(stack, NoSuchElementException.class).pop();
    }

    @Test
    public void itShouldNotAllowPeekOnEmptyStack() throws Exception {
        stack = new FixedStack<Integer>(1);

        verifyException(stack, NoSuchElementException.class).peek();
    }

    @Test
    public void itShouldNotAllowPushInFullStack() throws Exception {
        stack = new FixedStack<Integer>(1);

        stack.push(1);

        verifyException(stack, NoSuchElementException.class).push(2);
    }

}
