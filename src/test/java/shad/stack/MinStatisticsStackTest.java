package shad.stack;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MinStatisticsStackTest {
    private MinStatisticsStack<Integer> stack;

    @Before
    public void setUp() throws Exception {
        stack = new MinStatisticsStack<Integer>();
    }

    @Test
    public void itShouldKeepTrackOnMinValueWhenPush() throws Exception {
        stack.push(1);
        stack.push(0);
        stack.push(2);

        assertThat(stack.min(), is(0));
    }

    @Test
    public void itShouldKeepTrackOnMinValueWhenPop() throws Exception {
        stack.push(1);
        stack.push(0);
        stack.push(2);

        assertThat(stack.pop(), is(2));
        assertThat(stack.min(), is(0));

        assertThat(stack.pop(), is(0));
        assertThat(stack.min(), is(1));
    }

}
