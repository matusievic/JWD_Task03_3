package by.tc.dao.exception;

public class DAOException extends Exception {
    private static final long serialVersionUID = 4145969777379543014L;

    public DAOException() {
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOException(Throwable cause) {
        super(cause);
    }
}
