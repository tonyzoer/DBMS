package itlab.service.controllers;

import itlab.module.Database;
import itlab.module.Row;
import itlab.module.Scheme;
import itlab.module.exceptions.*;


import java.util.List;
import java.util.Map;

/**
 * Created by mafio on 01.10.2017.
 */
public interface DatabaseController {
  public abstract void createDatabase(String name);
  public abstract void deleteDatabase(String name);
  public abstract Database getDatabase(String name);
  public abstract void saveDatabase(String name);
  public abstract void loadDatabase(String name) throws DatabaseNotExsists;
  public abstract void addTable(String databaseName, String tableName,Map<String,String> collumns) ;
  public abstract Map<String , String> getTableRows(String databaseName, String tableName) throws TableNotExsisits;
  public abstract Map<String,String> getTableScheme(String databaseName, String tableName) throws TableNotExsisits;
  public abstract void removeTable(String databaseName, String tableName) throws TableNotExsisits;
  public abstract void renameTable(String databaseName, String tableNameCurrent,String tableNameNew) throws TableNotExsisits;
  public abstract void addRowToTable(String databaseName, String tableName, Map<String,String> collumnValues) throws NonExsistingColumnInRow, UnsuportetValueException,TableNotExsisits;
  public abstract void removeRowFromTable(String databaseName, String tableName,String rowUUID) throws NonExsistingRowInTable, TableNotExsisits;
  public abstract void updateRowInTable(String databaseName, String tableName,String rowUUID,Map<String,String> collumnValues) throws TableNotExsisits,NonExsistingColumnInRow,UnsuportetValueException;
  public abstract void tableIntersection(String table1, String table2, String newTableName) throws TableNotExsisits;
  public abstract void tableDifference(String table1,String table2, String newTableName)throws TableNotExsisits;
  public List<String> getAllDatabases();
}
