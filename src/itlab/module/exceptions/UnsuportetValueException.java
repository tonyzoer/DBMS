package itlab.module.exceptions;

/**
 * Created by mafio on 01.10.2017.
 */
public class UnsuportetValueException extends Exception {
    public UnsuportetValueException() {
        super();
    }

    public UnsuportetValueException(String message) {
        super(message);
    }

    public UnsuportetValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsuportetValueException(Throwable cause) {
        super(cause);
    }

    protected UnsuportetValueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
