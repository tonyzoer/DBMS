package itlab.module.types;

import itlab.module.exceptions.UnsuportetValueException;

/**
 * Created by mafio on 30.09.2017.
 */
public class DoubleT extends Type {
    Double value;

    DoubleT(String s) throws UnsuportetValueException {
        super(s);
    }


    @Override
    public void setValue(String s) throws UnsuportetValueException {
        try {
            value = Double.parseDouble(s);
        } catch (NumberFormatException e) {
            throw new UnsuportetValueException(value + "not suported for class Double", e);
        }
    }


    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DoubleT)) return false;

        DoubleT doubleT = (DoubleT) o;

        return getValue() != null ? getValue().equals(doubleT.getValue()) : doubleT.getValue() == null;
    }

    @Override
    public int hashCode() {
        return getValue() != null ? getValue().hashCode() : 0;
    }

    public static boolean supports(String value) {
        return true;
    }

    @Override
    public String toString() {
        return "DoubleT{" +
                "value=" + value +
                '}';
    }
}
