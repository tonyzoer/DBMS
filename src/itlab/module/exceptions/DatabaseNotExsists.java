package itlab.module.exceptions;

/**
 * Created by mafio on 02.10.2017.
 */
public class DatabaseNotExsists extends Exception {
    public DatabaseNotExsists() {
        super();
    }

    public DatabaseNotExsists(String message) {
        super(message);
    }

    public DatabaseNotExsists(String message, Throwable cause) {
        super(message, cause);
    }

    public DatabaseNotExsists(Throwable cause) {
        super(cause);
    }

    protected DatabaseNotExsists(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
