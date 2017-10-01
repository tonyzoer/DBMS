package itlab.module;

import itlab.module.types.Type;
import itlab.module.types.Types;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by mafio on 30.09.2017.
 */
public class Scheme implements Serializable {
    Map<String, Types> columns;

    public Scheme(Map<String, Types> columns) {
        this.columns = columns;
    }

    public Map<String, Types> getColumns() {
        return columns;
    }

    //TODO
    @Override
    public boolean equals(Object obj) {
        try {
            Scheme another = (Scheme) obj;
            return this.columns.equals(another.columns);
        } catch (ClassCastException ex) {
            return false;
        }
    }
}
