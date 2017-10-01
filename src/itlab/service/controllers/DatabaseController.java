package itlab.service.controllers;

import itlab.module.Database;
import itlab.module.Row;
import itlab.module.Scheme;


import java.util.Map;

/**
 * Created by mafio on 01.10.2017.
 */
public interface DatabaseController {
  public abstract void createDatabase(String name);
  public abstract void deleteDatabase(String name);
  public abstract Database getDatabase(String name);
  public abstract void saveDatabase(String name);
  public abstract void loadDatabase(String name);
  public abstract void addTable(String databaseName, String tableName,Map<String,String> collumns);
  public abstract Map<String , Map<String,String>> getTableRows(String databaseName, String tableName);
  public abstract Map<String,String> getTableScheme(String databaseName, String tableName);
  public abstract void removeTable(String databaseName, String tableName);
  public abstract void renameTable(String databaseName, String tableNameCurrent,String tableNameNew);
  public abstract void addRowToTable(String databaseName, String tableName, Map<String,String> collumnValues);
  public abstract void removeRowFromTable(String databaseName, String tableName,String rowUUID);
  public abstract void updateRowInTable(String databaseName, String tableName,String rowUUID,Map<String,String> collumnValues);
  public abstract void tableTntersection(String table1,String table2, String newTableName);
  public abstract void tableDifference(String table1,String table2, String newTableName);
}
