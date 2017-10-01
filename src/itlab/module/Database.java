package itlab.module;

import itlab.module.exceptions.TableAlreadyExsists;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by mafio on 25.09.2017.
 */
public class Database implements Serializable {
    Map<String,Table> tables;
    String name;
    public Database(String name, Map<String, Table> tables) {
        this.tables = tables;
        this.name=name;
    }

    public Database(String name) {
        this.name=name;
        tables=new HashMap<>();
    }

    public Map<String, Table> getTables() {
        return tables;
    }

//    public void setTables(Map<String, Table> tables) {
//        this.tables = tables;
//    }



    public String createTable(String name,Scheme scheme) throws TableAlreadyExsists {
        if (!tables.containsKey(name)){
        Table t=new Table(name,scheme);
        tables.put(name,t);
        return name;}
        else {
            throw new TableAlreadyExsists(name+ " table already exsists");
        }
    }
    public void deleteTable(String name){}
    public Table getTable(String name){ return tables.get(name);}
    public void save(){}
    public void load(){}

}
