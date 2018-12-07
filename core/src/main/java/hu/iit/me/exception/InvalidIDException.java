package hu.iit.me.exception;

public class InvalidIDException extends Exception{
    public InvalidIDException() {
    }

    public InvalidIDException(String message) {
        super(message);
    }

    public InvalidIDException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidIDException(Throwable cause) {
        super(cause);
    }

    public InvalidIDException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
