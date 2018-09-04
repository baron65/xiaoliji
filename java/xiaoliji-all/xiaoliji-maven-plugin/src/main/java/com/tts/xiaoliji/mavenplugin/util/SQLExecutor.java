package com.tts.xiaoliji.mavenplugin.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SQLExecutor {

    public static List<Map<String, String>> queryMapList(Connection conn, String sql) throws Exception {

        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();

            rs = stmt.executeQuery(sql);
            ResultSetMetaData meta = rs.getMetaData();
            int columnCount = meta.getColumnCount();

            List<Map<String, String>> list = new ArrayList<Map<String, String>>();

            while (rs.next()) {

                Map<String, String> map = new HashMap<String, String>();
                list.add(map);

                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    String key = meta.getColumnLabel(columnIndex);
                    String value = getValue(rs, columnIndex);
                    map.put(key, value);
                }
            }

            return list;
        }
        catch (Exception e) {
            throw e;
        }
        finally {
            if (null != rs) {
                rs.close();
            }
            if (null != stmt) {
                stmt.close();
            }
        }
    }

    private static String getValue(ResultSet rs, int columnIndex) throws SQLException {
        Object o = rs.getObject(columnIndex);

        if (null == o) {
            return null;
        }

        ResultSetMetaData meta = rs.getMetaData();
        int columnType = meta.getColumnType(columnIndex);

        String result = "";

        switch (columnType) {

        case Types.DATE:
            Date date = rs.getTimestamp(columnIndex);
            result = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
            break;

        default:
            result = String.valueOf(o);
            break;
        }
        return result;
    }

}
