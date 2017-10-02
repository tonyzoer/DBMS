package itlab.module.exceptions;

/**
 * Created by mafio on 02.10.2017.
 */
public class TableNotExsisits extends Exception {
    public TableNotExsisits() {
        super();
    }

    public TableNotExsisits(String message) {
        super(message);
    }

    public TableNotExsisits(String message, Throwable cause) {
        super(message, cause);
    }

    public TableNotExsisits(Throwable cause) {
        super(cause);
    }

    protected TableNotExsisits(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
