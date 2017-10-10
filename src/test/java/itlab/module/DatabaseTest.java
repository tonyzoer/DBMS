package itlab.module;


import itlab.module.exceptions.NonExistingTable;
import itlab.module.exceptions.TableAlreadyExsists;
import itlab.module.types.Types;
import org.jboss.arquillian.container.test.api.Deployment;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseTest {

    @Test
    public void tableDifference_ReturnEmptyList() throws TableAlreadyExsists, NonExistingTable {
        Database db = new Database("testDB");
        Map<String, Types> scheme = new HashMap<>(){
            {
                put("type", Types.STRING);
                put("type2", Types.STRING);
            }
        };
        db.createTable("Table1", new Scheme(scheme));
        db.createTable("Table2", new Scheme(scheme));
        List<Row> result = db.substractTables("Table1", "Table2");
        Assert.assertTrue(result.isEmpty());
    }

}
