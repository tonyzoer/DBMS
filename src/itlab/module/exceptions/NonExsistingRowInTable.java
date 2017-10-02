package itlab.module.exceptions;

/**
 * Created by mafio on 02.10.2017.
 */
public class NonExsistingRowInTable extends Exception {
    public NonExsistingRowInTable() {
        super();
    }

    public NonExsistingRowInTable(String message) {
        super(message);
    }

    public NonExsistingRowInTable(String message, Throwable cause) {
        super(message, cause);
    }

    public NonExsistingRowInTable(Throwable cause) {
        super(cause);
    }

    protected NonExsistingRowInTable(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
