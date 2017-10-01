package itlab.module;

import itlab.module.exceptions.NonExsistingColumnInRow;
import itlab.module.exceptions.UnsuportetValueException;
import itlab.module.types.Type;
import itlab.module.types.Types;
import itlab.module.types.ValueTypeFabric;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mafio on 25.09.2017.
 */
public class Row  implements Serializable {
    Map<String,Type> values;
    public Row(Scheme sc, Map<String,String> columnValue) throws UnsuportetValueException {
        values=new HashMap<>();
        for (Map.Entry<String,Types> col :sc.getColumns().entrySet()
             ) {
            String value=columnValue.get(col.getKey());
            if (value!=null){
            values.put(col.getKey(), ValueTypeFabric.getInstance().createCorrectType(col.getValue(),value));
            }else{
                values.put(col.getKey(), ValueTypeFabric.getInstance().createCorrectType(col.getValue()));
            }
        }
    }
    public void setValue(String column,String value,Types type) throws NonExsistingColumnInRow, UnsuportetValueException {
        Type t= values.get(column);
        if (t!=null){
        t.setValue(value);
        values.replace(column,t);
        }else{
            if (values.containsKey(column)){
            values.replace(column,ValueTypeFabric.getInstance().createCorrectType(type,value));
            }else{
            throw new NonExsistingColumnInRow("Collumn :"+column+"not exsists in row");
            }
        }
    }


    @Override
    public String toString() {
        return "Row{" +
                "values=" + values.toString() +
                '}';
    }
}
