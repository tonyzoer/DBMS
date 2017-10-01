package itlab.module.types;

import itlab.module.exceptions.UnsuportetValueException;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * Created by mafio on 30.09.2017.
 */
public class TimeT extends Type {
    LocalTime value;


    public TimeT(String value) throws UnsuportetValueException {
        super(value);
    }

    public LocalTime getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeT)) return false;

        TimeT timeT = (TimeT) o;

        return getValue() != null ? getValue().equals(timeT.getValue()) : timeT.getValue() == null;
    }

    @Override
    public int hashCode() {
        return getValue() != null ? getValue().hashCode() : 0;
    }


    @Override
    public void setValue(String s) throws UnsuportetValueException {
        try {
            value = LocalTime.parse(s, DateTimeFormatter.ofPattern("HH:mm:ss[.ssssss]"));
        }catch (DateTimeException ex){
            throw new UnsuportetValueException(s+" not suportet value for Time Type",ex);
        }
    }

    @Override
    public String toString() {
        return "TimeT{" +
                "value=" + value +
                '}';
    }
}
