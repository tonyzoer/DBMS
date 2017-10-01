package itlab.module.types;

import itlab.module.exceptions.UnsuportetValueException;

/**
 * Created by mafio on 30.09.2017.
 */
public class CharT extends Type {


    Character character;

    CharT(String s) throws UnsuportetValueException {
        super(s);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CharT)) return false;

        CharT aChar = (CharT) o;

        return character != null ? character.equals(aChar.character) : aChar.character == null;
    }

    @Override
    public int hashCode() {
        return character != null ? character.hashCode() : 0;
    }

    public static boolean supports(String value){ return true; }

    @Override
    public void setValue(String s) {
    character=s.charAt(0);
    }

    @Override
    public String toString() {
        return "CharT{" +
                "character=" + character +
                '}';
    }
}
