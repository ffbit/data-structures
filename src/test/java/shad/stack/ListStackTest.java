package shad.stack;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static com.googlecode.catchexception.CatchException.verifyException;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ListStackTest {

    private ListStack<Integer> stack;

    @Before
    public void setUp() throws Exception {
        stack = new ListStack<Integer>();
    }

    @Test
    public void itShouldPushAndPopElement() throws Exception {
        stack.push(1);

        assertThat(stack.pop(), is(1));
    }

    @Test
    public void itShouldCreateEmptyStack() throws Exception {
        assertThat(stack.size(), is(0));
        assertThat(stack.isEmpty(), is(true));
    }

    @Test
    public void itShouldIncreaseSize() throws Exception {
        assertThat(stack.size(), is(0));

        stack.push(1);

        assertThat(stack.size(), is(1));
        assertThat(stack.isEmpty(), is(false));
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
    public void itShouldBeFistInputLastOutput() throws Exception {
        stack.push(1);
        stack.push(2);

        assertThat(stack.pop(), is(2));
        assertThat(stack.pop(), is(1));
    }

    @Test
    public void itShouldPushAndPeekElement() throws Exception {
        stack.push(1);

        assertThat(stack.peek(), is(1));
    }

    @Test
    public void itShouldNotRemoveTopElementOnPeek() throws Exception {
        stack.push(1);
        stack.peek();

        assertThat(stack.pop(), is(1));
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
