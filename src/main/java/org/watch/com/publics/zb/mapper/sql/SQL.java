package org.watch.com.publics.zb.mapper.sql;


import java.util.Map;
import java.util.StringJoiner;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class SQL {
    public String updates(Map<String, Integer> map) {
        StringJoiner sj = new StringJoiner("");
        map.forEach((k, v) -> {
            org.apache.ibatis.jdbc.SQL sql = new org.apache.ibatis.jdbc.SQL();
            sql.UPDATE("zb_table");
            sql.SET("code = " + v);
            sql.WHERE("people_id = '" + k+"'");
            sj.add(sql.toString() + ";");
        });
        return sj.toString();
    }

}
