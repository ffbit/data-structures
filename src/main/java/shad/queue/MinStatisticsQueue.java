package shad.queue;

import shad.stack.MinStatisticsStack;

public class MinStatisticsQueue<E extends Comparable<E>> implements Queue<E> {
    private MinStatisticsStack<E> output;
    private MinStatisticsStack<E> input;

    public MinStatisticsQueue() {
        output = new MinStatisticsStack<E>();
        input = new MinStatisticsStack<E>();
    }

    @Override
    public void enqueue(E element) {
        input.push(element);
    }

    @Override
    public E dequeue() {
        if (output.isEmpty()) {
            repack();
        }

        return output.pop();
    }

    private void repack() {
        while (!input.isEmpty()) {
            output.push(input.pop());
        }
    }

    @Override
    public int size() {
        return output.size() + input.size();
    }

    public E min() {
        if (output.isEmpty()) {
            return input.min();
        } else if (input.isEmpty()) {
            return output.min();
        } else {
            if (output.min().compareTo(input.min()) < 0) {
                return output.min();
            } else {
                return input.min();
            }
        }
    }

}
