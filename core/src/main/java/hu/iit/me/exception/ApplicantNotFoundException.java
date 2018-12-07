package hu.iit.me.exception;

public class ApplicantNotFoundException extends Exception {
    public ApplicantNotFoundException() {
    }

    public ApplicantNotFoundException(String message) {
        super(message);
    }

    public ApplicantNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicantNotFoundException(Throwable cause) {
        super(cause);
    }

    public ApplicantNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
