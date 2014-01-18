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

}
