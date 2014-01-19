package shad.queue;

public class QueueUnderflowException extends RuntimeException {
    private static final long serialVersionUID = -7024449970323991762L;

    public QueueUnderflowException(String message) {
        super(message);
    }

}
