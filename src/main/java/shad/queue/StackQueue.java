package shad.queue;

import shad.stack.FixedStack;

public class StackQueue<E> implements Queue<E> {
    private FixedStack<E> input;
    private FixedStack<E> output;

    public StackQueue(int capacity) {
        input = new FixedStack<E>(capacity);
        output = new FixedStack<E>(capacity);
    }

    @Override
    public void enqueue(E element) {
        input.push(element);
    }

    @Override
    public E dequeue() {
        if (output.size() == 0) {
            while (input.size() != 0) {
                output.push(input.pop());
            }
        }

        return output.pop();
    }

    @Override
    public int size() {
        return input.size() + output.size();
    }

}
