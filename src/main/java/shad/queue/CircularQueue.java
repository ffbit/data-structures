package shad.queue;

public class CircularQueue<E> implements Queue<E> {
    private E[] holder;
    private int head;
    private int tail;
    private int size;

    @SuppressWarnings("unchecked")
    public CircularQueue(int capacity) {
        holder = (E[]) new Object[capacity];
    }

    @Override
    public void enqueue(E element) {
        if (size == holder.length) {
            throw new QueueOverflowException("An attempt to enqueue on a full queue");
        }

        size++;
        tail = tail % holder.length;
        holder[tail++] = element;

    }

    @Override
    public E dequeue() {
        if (size == 0) {
            throw new QueueUnderflowException("An attempt to dequeue on a empty queue");
        }

        size--;
        head = head % holder.length;
        return holder[head++];
    }

    @Override
    public int size() {
        return size;
    }

}
