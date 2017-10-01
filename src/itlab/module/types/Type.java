package itlab.module.types;

import itlab.module.exceptions.UnsuportetValueException;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by mafio on 30.09.2017.
 */
public abstract class Type implements Serializable {
    Type(String s) throws UnsuportetValueException { setValue(s);}
    public abstract void setValue(String s) throws UnsuportetValueException;
    @Override
    public String toString() {
        return "Type{}";
    }
}
