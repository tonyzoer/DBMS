package itlab;

import itlab.module.Database;
import itlab.module.Scheme;
import itlab.module.Table;
import itlab.module.exceptions.TableAlreadyExsists;
import itlab.module.exceptions.UnsuportetValueException;
import itlab.module.types.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mafio on 01.10.2017.
 */
public class test {
    public static void main(String[] args) throws UnsuportetValueException, TableAlreadyExsists {
    delete();
    }
    private static void load(){
        Database database=new Database("shit");
        database.load();
        Map<String,Table> tables =database.getTables();
        Table tb=tables.get("first table");
        System.out.println(tb.getRows());
    }
    private static void save() throws TableAlreadyExsists, UnsuportetValueException {
        Database database=new Database("shit");
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
        database.save();
    }
    private static void delete(){
        Database database=new Database("shit");
        database.delete();
    }
}
