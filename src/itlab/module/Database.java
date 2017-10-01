package itlab.module;

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



    public String createTable(String name,Scheme scheme){
        Table t=new Table(name,scheme);
        String uuid=UUID.randomUUID().toString();
        tables.put(uuid,t);
        return uuid;
    }
    public void deleteTable(String uuid){}
    public Table getTable(String uuid){ return tables.get(uuid);}
    public void save(){}
    public void load(){}

}
