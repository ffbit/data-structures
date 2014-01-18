package shad.stack;

public class DynamicStack {
    private final int capacity;

    public DynamicStack(int initialCapacity) {
        capacity = initialCapacity;
    }

    public int capacity() {
        return capacity;
    }

    public int size() {
        return 0;
    }

}
