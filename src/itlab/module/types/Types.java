package itlab.module.types;

/**
 * Created by mafio on 30.09.2017.
 */
public enum Types {
    CHAR,CHARINTERVAL,DOUBLE,INTEGER,STRING,TIMEINTERVAL,TIME;
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
