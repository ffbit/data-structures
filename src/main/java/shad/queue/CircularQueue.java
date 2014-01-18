package shad.queue;

public class CircularQueue<E> implements Queue<E> {
    private E[] holder;
    private int head;
    private int tail;

    @SuppressWarnings("unchecked")
    public CircularQueue(int capacity) {
        holder = (E[]) new Object[capacity];
    }

    @Override
    public void enqueue(E element) {
        holder[tail++] = element;
    }

    @Override
    public E dequeue() {
        return holder[head++];
    }

}
