package itlab.module.types;

import itlab.module.exceptions.UnsuportetValueException;

/**
 * Created by mafio on 30.09.2017.
 */
public class StringT extends Type {
    String value;

    StringT(String s) throws UnsuportetValueException {
        super(s);
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StringT)) return false;

        StringT stringT = (StringT) o;

        return getValue() != null ? getValue().equals(stringT.getValue()) : stringT.getValue() == null;
    }

    @Override
    public int hashCode() {
        return getValue() != null ? getValue().hashCode() : 0;
    }

    public static boolean supports(String value){ return true; }

    @Override
    public String toString() {
        return "StringT{" +
                "value='" + value + '\'' +
                '}';
    }
}
