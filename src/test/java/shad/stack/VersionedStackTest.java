package shad.stack;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

public class VersionedStackTest {
    private VersionedStack<Integer> stack;

    @Before
    public void setUp() throws Exception {
        stack = new VersionedStack<Integer>();
    }

    @Test
    public void itShouldReturnNewStackOnPush() throws Exception {
        assertThat(stack.push(1), is(not(sameInstance(stack))));
    }

    @Test
    public void itShouldReturnPreviousStackOnPop() throws Exception {
        VersionedStack<Integer> pushedStack = stack.push(1);

        assertThat(pushedStack.pop(), is(sameInstance(stack)));
    }

    @Test
    public void itShouldPeekValue() throws Exception {
        VersionedStack<Integer> pushedStack = stack.push(1);

        assertThat(pushedStack.peek(), is(1));
    }
}
