package itlab;

import itlab.module.Database;
import itlab.module.Scheme;
import itlab.module.Table;
import itlab.module.exceptions.TableAlreadyExsists;
import itlab.module.exceptions.UnsuportetValueException;
import itlab.module.types.Types;

import java.util.HashMap;

/**
 * Created by mafio on 01.10.2017.
 */
public class test {
    public static void main(String[] args) throws UnsuportetValueException, TableAlreadyExsists {
        Database database=new Database("first data base");
        HashMap<String,Types> schemeMap=new HashMap<>();
        schemeMap.put("id",Types.INTEGER);
        schemeMap.put("user",Types.STRING);
        String currtableUuid= database.createTable("first table",new Scheme(schemeMap));
        Table t= database.getTable(currtableUuid);
        HashMap<String,String> columnValue=new HashMap<>();
        columnValue.put("id","1");
        columnValue.put("user","TOHA");
        String rowUuid=t.addRow(columnValue);
        System.out.println(t.getRow(rowUuid));
    }
}
