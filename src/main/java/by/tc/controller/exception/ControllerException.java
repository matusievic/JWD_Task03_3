package by.tc.controller.exception;

public class ControllerException extends Exception {
    private static final long serialVersionUID = 1L;

    public ControllerException() {}

    public ControllerException(String message) {
        super(message);
    }

    public ControllerException(Exception e) {
        super(e);
    }

    public ControllerException(String message, Exception e) {
        super(message, e);
    }
}
