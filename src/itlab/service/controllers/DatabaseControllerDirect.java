package itlab.service.controllers;

import itlab.module.Database;

import java.util.Map;

/**
 * Created by mafio on 01.10.2017.
 */
public class DatabaseControllerDirect  implements DatabaseController{
    private static DatabaseControllerDirect ourInstance = new DatabaseControllerDirect();

    public static DatabaseControllerDirect getInstance() {
        return ourInstance;
    }

    private DatabaseControllerDirect() {
    }

    @Override
    public void createDatabase(String name) {

    }

    @Override
    public void deleteDatabase(String name) {

    }

    @Override
    public Database getDatabase(String name) {
        return null;
    }

    @Override
    public void saveDatabase(String name) {

    }

    @Override
    public void loadDatabase(String name) {

    }

    @Override
    public void addTable(String databaseName, String tableName, Map<String, String> collumns) {

    }

    @Override
    public Map<String, Map<String, String>> getTableRows(String databaseName, String tableName) {
        return null;
    }

    @Override
    public Map<String, String> getTableScheme(String databaseName, String tableName) {
        return null;
    }

    @Override
    public void removeTable(String databaseName, String tableName) {

    }

    @Override
    public void renameTable(String databaseName, String tableNameCurrent, String tableNameNew) {

    }

    @Override
    public void addRowToTable(String databaseName, String tableName, Map<String, String> collumnValues) {

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
}
