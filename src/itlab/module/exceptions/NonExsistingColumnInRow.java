package itlab.module.exceptions;

/**
 * Created by mafio on 01.10.2017.
 */
public class NonExsistingColumnInRow extends Exception {
    public NonExsistingColumnInRow() {
        super();
    }

    public NonExsistingColumnInRow(String message) {
        super(message);
    }

    public NonExsistingColumnInRow(String message, Throwable cause) {
        super(message, cause);
    }

    public NonExsistingColumnInRow(Throwable cause) {
        super(cause);
    }

    protected NonExsistingColumnInRow(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
