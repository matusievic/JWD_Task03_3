package by.tc.service.exception;

public class ServiceException extends Exception {
    private static final long serialVersionUID = 7229078331560953969L;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }
}
