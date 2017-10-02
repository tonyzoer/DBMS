package itlab.service.controllers;

import itlab.module.Database;
import itlab.module.Row;
import itlab.module.Scheme;
import itlab.module.exceptions.TableAlreadyExsists;
import itlab.module.exceptions.UnsuportetValueException;
import itlab.module.types.Types;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mafio on 01.10.2017.
 */
public class DatabaseControllerDirect  implements DatabaseController{
    private static DatabaseControllerDirect ourInstance = new DatabaseControllerDirect();
    private Map<String,Database> dbInMemmory=new HashMap<>();
    public static DatabaseControllerDirect getInstance() {
        return ourInstance;
    }

    private DatabaseControllerDirect() {
    }

    @Override
    public void createDatabase(String name) {
    dbInMemmory.put(name,new Database(name));
    }

    @Override
    public void deleteDatabase(String name) {
    dbInMemmory.get(name).delete();
    }

    @Override
    public Database getDatabase(String name) {
        return dbInMemmory.get(name);
    }

    @Override
    public void saveDatabase(String name) {
    dbInMemmory.get(name).save();
    }

    @Override
    public void loadDatabase(String name) {
    dbInMemmory.put(name, new Database(name));
    dbInMemmory.get(name).load();
    }

    @Override
    public void addTable(String databaseName, String tableName, Map<String, String> collumns) {
    Database db= dbInMemmory.get(databaseName);
    if (db!=null){
        Map<String,Types> collumnsTypes=new HashMap<>();
        for ( Map.Entry<String,String> col:collumns.entrySet()
             ) {
            collumnsTypes.put(col.getKey(),Types.valueOf(col.getValue()));
        }
       Scheme scheme=new Scheme(collumnsTypes);
        try {
            db.createTable(tableName,scheme);
        } catch (TableAlreadyExsists tableAlreadyExsists) {
            //TODO Send another exception;
            tableAlreadyExsists.printStackTrace();
        }
    }
    }

    @Override
    public Map<String, String> getTableRows(String databaseName, String tableName) {
        Map<String,Row> rows=dbInMemmory.get(databaseName).getTable(tableName).getRows();
        Map<String,String> rowsMap=new HashMap<>();
        for (Map.Entry<String,Row> row:rows.entrySet()
             ) {
            rowsMap.put(row.getKey(),row.getValue().toString());
        }
        return rowsMap;
    }

    @Override
    public Map<String, String> getTableScheme(String databaseName, String tableName) {
        Map<String,String> collums=new HashMap<>();
        for (Map.Entry<String,Types> col:dbInMemmory.get(databaseName).getTable(tableName).getScheme().getColumns().entrySet()
             ) {
            collums.put(col.getKey(),col.getValue().toString());
        }
        return collums;
    }

    @Override
    public void removeTable(String databaseName, String tableName) {
    dbInMemmory.get(databaseName).deleteTable(tableName);
    }

    @Override
    public void renameTable(String databaseName, String tableNameCurrent, String tableNameNew) {
    dbInMemmory.get(databaseName).getTable(tableNameCurrent).setName(tableNameNew);
    }

    @Override
    public void addRowToTable(String databaseName, String tableName, Map<String, String> collumnValues) throws UnsuportetValueException {
    dbInMemmory.get(databaseName).getTable(tableName).addRow(collumnValues);
    }

    @Override
    public void removeRowFromTable(String databaseName, String tableName, String rowUUID) {

    }

    @Override
    public void updateRowInTable(String databaseName, String tableName, String rowUUID, Map<String, String> collumnValues) {

    }

    @Override
    public void tableTntersection(String table1, String table2, String newTableName) {

    }

    @Override
    public void tableDifference(String table1, String table2, String newTableName) {

    }

    @Override
    public List<String> getAllDatabases() {
        return null;
    }
}
