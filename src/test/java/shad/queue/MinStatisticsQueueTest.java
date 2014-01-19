package shad.queue;

import org.junit.Before;
import org.junit.Test;

import static com.googlecode.catchexception.CatchException.verifyException;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MinStatisticsQueueTest {
    private MinStatisticsQueue<Integer> queue;

    @Before
    public void setUp() throws Exception {
        queue = new MinStatisticsQueue<Integer>();
    }

    @Test
    public void itShouldEnqueueAndDequeue() throws Exception {
        queue.enqueue(2);

        assertThat(queue.dequeue(), is(2));
    }

    @Test
    public void itShouldBeFirstInputFirstOutput() throws Exception {
        queue.enqueue(1);
        queue.enqueue(2);

        assertThat(queue.dequeue(), is(1));
        assertThat(queue.dequeue(), is(2));
    }

    @Test
    public void itShouldCreateEmptyQueue() throws Exception {
        assertThat(queue.size(), is(0));
    }

    @Test
    public void itShouldKeepTrackOnMinValueWhenEnqueue() throws Exception {
        queue.enqueue(1);
        queue.enqueue(0);
        queue.enqueue(2);

        assertThat(queue.min(), is(0));
    }

    @Test
    public void itShouldKeepTrackOnMinValueWhenDequeue() throws Exception {
        queue.enqueue(1);
        queue.enqueue(0);
        queue.enqueue(2);

        assertThat(queue.dequeue(), is(1));
        assertThat(queue.min(), is(0));

        queue.enqueue(5);

        assertThat(queue.dequeue(), is(0));
        assertThat(queue.min(), is(2));

        assertThat(queue.dequeue(), is(2));
        assertThat(queue.min(), is(5));
    }

    @Test
    public void itShouldNotAllowMinOnEmptyQueue() throws Exception {
        verifyException(queue, QueueUnderflowException.class).min();
    }

}
