package by.tc.controller.exception;

public class InternalServerException extends Exception {
    private static final long serialVersionUID = 1L;

    public InternalServerException() {}

    public InternalServerException(String message) {
        super(message);
    }

    public InternalServerException(Exception e) {
        super(e);
    }

    public InternalServerException(String message, Exception e) {
        super(message, e);
    }
}
