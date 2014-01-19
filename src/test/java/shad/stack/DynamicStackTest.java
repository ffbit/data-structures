package shad.stack;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static com.googlecode.catchexception.CatchException.verifyException;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DynamicStackTest {
    private DynamicStack<Integer> stack;

    @Before
    public void setUp() throws Exception {
        stack = new DynamicStack<Integer>();
    }

    @Test
    public void itShouldCreateStackWithSpecifiedInitialCapacity() throws Exception {
        stack = new DynamicStack<Integer>(1);

        assertThat(stack.capacity(), is(1));
    }

    @Test
    public void itShouldCreateEmptyStack() throws Exception {
        assertThat(stack.size(), is(0));
        assertThat(stack.isEmpty(), is(true));
    }

    @Test
    public void itShouldPushAndPopElement() throws Exception {
        stack.push(2);

        assertThat(stack.pop(), is(2));
    }

    @Test
    public void itShouldIncreaseSize() throws Exception {
        assertThat(stack.size(), is(0));

        stack.push(1);

        assertThat(stack.size(), is(1));
        assertThat(stack.isEmpty(), is(false));
    }

    @Test
    public void itShouldPushAndPeekElement() throws Exception {
        stack.push(2);

        assertThat(stack.peek(), is(2));
    }

    @Test
    public void itShouldNotDecreaseSizeOnPeek() throws Exception {
        stack.push(2);
        stack.peek();

        assertThat(stack.size(), is(1));
    }

    @Test
    public void itShouldDecreaseSizeOnPop() throws Exception {
        stack.push(2);
        stack.pop();

        assertThat(stack.size(), is(0));
    }

    @Test
    public void itShouldIncreaseCapacityWhenPushOnFullStack() throws Exception {
        stack = new DynamicStack<Integer>(1);

        stack.push(2);
        assertThat(stack.capacity(), is(1));

        stack.push(3);
        assertThat("capacity should be increased from 1 to 2", stack.capacity(), is(2));

        stack.push(5);
        assertThat("capacity should be increased from 2 to 4", stack.capacity(), is(4));
    }

    @Test
    public void itShouldBeFistInputLastOutput() throws Exception {
        stack.push(1);
        stack.push(2);

        assertThat(stack.pop(), is(2));
        assertThat(stack.pop(), is(1));
    }

    @Test
    public void itShouldDecreaseCapacityWhenPopAndQuarterOfStackFilled() throws Exception {
        stack = new DynamicStack<Integer>(4);

        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.pop();
        stack.pop();
        stack.pop();

        assertThat(stack.capacity(), is(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void itShouldNotAllowToCreateStackWithNonPositiveCapacity() throws Exception {
        new DynamicStack<Integer>(0);
    }

    @Test
    public void itShouldNotAllowPopOnEmptyStack() throws Exception {
        verifyException(stack, NoSuchElementException.class).pop();
    }

    @Test
    public void itShouldNotAllowPeekOnEmptyStack() throws Exception {
        verifyException(stack, NoSuchElementException.class).peek();
    }

}
