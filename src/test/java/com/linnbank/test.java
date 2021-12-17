package com.linnbank;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.linnbank.utilities.DatabaseUtility;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {

    @Test
    public void test() throws SQLException {
        DatabaseUtility.createConnection();
        ResultSet rs = DatabaseUtility.executeQuery("select * from tp_customer limit 10");
        List<Map> mapList = new ArrayList<>();
        int numberOfColumns = rs.getMetaData().getColumnCount();
        while (rs.next()) {
            Map<String,String> map = new HashMap<>();
            for (int i = 1; i <= numberOfColumns; i++) {
                map.put(rs.getMetaData().getColumnName(i),rs.getString(i));
            }
            mapList.add(map);
        }
        System.out.println(mapList.toString());
    }
}

