package shad.queue;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CircularQueueTest {

    @Test
    public void itShouldEnqueueAndDequeue() throws Exception {
        Queue<Integer> queue = new CircularQueue(1);

        queue.enqueue(1);

        assertThat(queue.dequeue(), is(1));
    }

}
