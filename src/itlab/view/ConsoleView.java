package itlab.view;

import itlab.module.exceptions.TableNotExsisits;
import itlab.module.exceptions.UnsuportetValueException;
import itlab.service.controllers.DatabaseController;
import itlab.service.controllers.DatabaseControllerDirect;

import java.io.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mafio on 02.10.2017.
 */
public class ConsoleView implements IView {
    static ConsoleView cv=new ConsoleView();
    String db;
    String table;
    public static void main(String[] args) {
    cv.help();
        Console console=System.console();
        cv.proccesInput();
    return;
    }

    private void proccesInput(){
        String input = System.console().readLine();
        switch (input){
            case "showAllDatabases": showAllDatabases();break;
            case "CreateDB": createDatabase(readString("Enter name of new Database")); break;
            case "DeleteDB":deleteDatabase(readString("Enter name of Database")); break;
            case "ShowDB":showDatabase(readString("Enter name of Database"));break;
            case "SaveeDB":saveDatabase(readString("Enter name of Database"));break;
            case "LoadDB": loadDatabase(readString("Enter name of Database"));break;
            case "CreateTable":createTable(readString("Enter name of Database"),readString("Enter name of new Table"),mapFromString(readString("Enter scheme in format 'name:TYPE;...;name:TYPE'"))); break;
            case "ShowTable":showTable(readString("Enter name of Database"),readString("Enter name of Table"));break;
            case "ShowTableScheme":showTableScheme(readString("Enter name of Database"),readString("Enter name of Table"));break;
            case "AddRowToTable":addRowToTable(readString("Enter name of Database"),readString("Enter name of Table"),mapFromString(readString("Enter Row in format 'collumnName:Value;...;collumnName:Value'")));break;
            case "RemoveRowFromTable":removeRowFromTable(readString("Enter name of Database"),readString("Enter name of new Table"),readString("Enter UUID of ROW"));break;
            case "UpdateRowInTable":updateRowInTable(readString("Enter name of Database"),readString("Enter name of Table"),readString("Enter UUID of ROW"),mapFromString(readString("Enter Row in format 'collumnName:Value;...;collumnName:Value'")));break;
            case "TableIntersection":tableIntersection(readString("Enter name of Table 1"),readString("Enter name of Table 2"),readString("Enter name of new Table"));break;
            case "TableDiference":tableDifference(readString("Enter name of Table 1"),readString("Enter name of Table 2"),readString("Enter name of new Table")); break;
            case "SelectDB":break;
            case "UnselectDB":break;
            case "SelectTable":break;
            case "UnselectTable":break;
        }
        proccesInput();
    }

    @Override
    public void createDatabase(String name) {
        DatabaseControllerDirect.getInstance().createDatabase(name);
    }

    @Override
    public void deleteDatabase(String name) {
    DatabaseControllerDirect.getInstance().deleteDatabase(name);
    }

    @Override
    public void showDatabase(String name) {
    //TODO make it beatyfull
        System.out.println(DatabaseControllerDirect.getInstance().getDatabase(name));
    }

    @Override
    public void saveDatabase(String name) {
    DatabaseControllerDirect.getInstance().saveDatabase(name);
    }

    @Override
    public void loadDatabase(String name) {
    DatabaseControllerDirect.getInstance().loadDatabase(name);
    }

    @Override
    public void createTable(String databaseName, String tableName, Map<String, String> collumns) {
    DatabaseControllerDirect.getInstance().addTable(databaseName,tableName,collumns);
    }

    @Override
    public void showTable(String databaseName, String tableName) {
        //TODO make it beatyfull
        try {
            System.out.println(DatabaseControllerDirect.getInstance().getTableRows(databaseName,tableName));
        } catch (TableNotExsisits tableNotExsisits) {
            tableNotExsisits.printStackTrace();
        }
    }

    @Override
    public void showTableScheme(String databaseName, String tableName) {
    //TODO make it beatyfull
        try {
            System.out.println(DatabaseControllerDirect.getInstance().getTableScheme(databaseName,tableName));
        } catch (TableNotExsisits tableNotExsisits) {
            tableNotExsisits.printStackTrace();
        }
    }

    @Override
    public void removeTable(String databaseName, String tableName) {
    DatabaseControllerDirect.getInstance().removeTable(databaseName,tableName);
    }

    @Override
    public void renameTable(String databaseName, String tableNameCurrent, String tableNameNew) {
    renameTable(databaseName,tableNameCurrent,tableNameNew);
    }

    @Override
    public void addRowToTable(String databaseName, String tableName, Map<String, String> collumnValues) {
        try {
            DatabaseControllerDirect.getInstance().addRowToTable(databaseName,tableName,collumnValues);
        } catch (UnsuportetValueException e) {
            e.printStackTrace();
        } catch (TableNotExsisits tableNotExsisits) {
            tableNotExsisits.printStackTrace();
        }
    }

    @Override
    public void removeRowFromTable(String databaseName, String tableName, String rowUUID) {
        try {
            DatabaseControllerDirect.getInstance().removeRowFromTable(databaseName,tableName,rowUUID);
        } catch (TableNotExsisits tableNotExsisits) {
            tableNotExsisits.printStackTrace();
        }
    }

    @Override
    public void updateRowInTable(String databaseName, String tableName, String rowUUID, Map<String, String> collumnValues) {
        try {
            DatabaseControllerDirect.getInstance().updateRowInTable(databaseName,tableName,rowUUID,collumnValues);
        } catch (UnsuportetValueException e) {
            e.printStackTrace();
        } catch (TableNotExsisits tableNotExsisits) {
            tableNotExsisits.printStackTrace();
        }
    }

    @Override
    public void tableIntersection(String table1, String table2, String newTableName) {

    }

    @Override
    public void tableDifference(String table1, String table2, String newTableName) {

    }

    @Override
    public void showAllDatabases() {

    }

    @Override
    public void showAllExsistingTypes() {

    }

    @Override
    public void help() {

    }
    public void selectDB(String name){}
    public void unselectDB(){}
    public void selectTable(String name){}
    public void unselectTable(){}
    private String readString(String s){
        System.out.println(s);
        String input = System.console().readLine();
        return input;
    }
    private Map<String,String> mapFromString(String s){
        Map<String,String> map=new HashMap();
        String pairs[]= s.split(";");
        for (String pair:pairs
             ) {
            String curpair[] =pair.split(":");
            map.put(curpair[0],curpair[1]);
        }
        return map;
    };
}
