package by.tc.controller.exception;

public class NotFoundException extends Exception {
    private static final long serialVersionUID = -1458196835626439066L;

    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }
}
