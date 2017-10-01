package itlab.module.types;

import itlab.module.exceptions.UnsuportetValueException;

/**
 * Created by mafio on 30.09.2017.
 */
public class CharT extends Type {


    Character value;

    CharT(String s) throws UnsuportetValueException {
        super(s);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CharT)) return false;

        CharT aChar = (CharT) o;

        return value != null ? value.equals(aChar.value) : aChar.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }


    @Override
    public void setValue(String s) {
    value =s.charAt(0);
    }

    @Override
    public String toString() {
        return "CharT{" +
                "value=" + value +
                '}';
    }
}
