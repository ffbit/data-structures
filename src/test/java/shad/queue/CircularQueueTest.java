package shad.queue;

import org.junit.Test;

import static com.googlecode.catchexception.CatchException.verifyException;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@SuppressWarnings("unchecked")
public class CircularQueueTest {
    private Queue<Integer> queue;

    @Test
    public void itShouldEnqueueAndDequeue() throws Exception {
        queue = new CircularQueue(1);

        queue.enqueue(1);

        assertThat(queue.dequeue(), is(1));
    }

    @Test
    public void itShouldBeFirstInputFirstOutput() throws Exception {
        queue = new CircularQueue(2);

        queue.enqueue(1);
        queue.enqueue(2);

        assertThat(queue.dequeue(), is(1));
        assertThat(queue.dequeue(), is(2));
    }

    @Test
    public void itShouldCreateEmptyQueue() throws Exception {
        queue = new CircularQueue<Integer>(1);

        assertThat(queue.size(), is(0));
    }

    @Test
    public void itShouldIncreaseSize() throws Exception {
        queue = new CircularQueue<Integer>(1);

        assertThat(queue.size(), is(0));

        queue.enqueue(2);

        assertThat(queue.size(), is(1));
    }

    @Test
    public void itShouldDecreaseSize() throws Exception {
        queue = new CircularQueue<Integer>(1);

        queue.enqueue(2);
        queue.dequeue();

        assertThat(queue.size(), is(0));
    }


    @Test
    public void itShouldBeCircular() throws Exception {
        queue = new CircularQueue<Integer>(2);

        queue.enqueue(1);
        assertThat(queue.dequeue(), is(1));

        queue.enqueue(2);
        assertThat(queue.dequeue(), is(2));

        queue.enqueue(3);
        assertThat(queue.dequeue(), is(3));
    }

    @Test
    public void itShouldNotAllowUnderflow() throws Exception {
        queue = new CircularQueue(1);

        verifyException(queue, QueueUnderflowException.class).dequeue();
    }

    @Test
    public void itShouldNotAllowOverflow() throws Exception {
        queue = new CircularQueue(1);

        queue.enqueue(1);

        verifyException(queue, QueueOverflowException.class).enqueue(2);
    }

}
