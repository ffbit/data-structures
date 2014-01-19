package shad.queue;

public class QueueOverflowException extends RuntimeException {
    private static final long serialVersionUID = -524428879039114005L;

    public QueueOverflowException(String message) {
        super(message);
    }

}
