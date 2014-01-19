package shad.queue;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StackQueueTest {
    private Queue<Integer> queue;

    @Test
    public void itShouldEnqueueAndDequeue() throws Exception {
        queue = new StackQueue<Integer>(1);

        queue.enqueue(2);

        assertThat(queue.dequeue(), is(2));
    }

    @Test
    public void itShouldBeFirstInputFirstOutput() throws Exception {
        queue = new StackQueue<Integer>(2);

        queue.enqueue(1);
        queue.enqueue(2);

        assertThat(queue.dequeue(), is(1));
        assertThat(queue.dequeue(), is(2));
    }

    @Test
    public void itShouldCreateEmptyQueue() throws Exception {
        queue = new StackQueue<Integer>(1);

        assertThat(queue.size(), is(0));
    }

}
