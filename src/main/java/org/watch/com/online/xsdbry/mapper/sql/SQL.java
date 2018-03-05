package org.watch.com.online.xsdbry.mapper.sql;

import org.watch.com.util.uuidUtil.GetUuid;

import java.util.Map;
import java.util.StringJoiner;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class SQL {
    public String insert1(Map<String, String> map) {
        StringJoiner sq = new StringJoiner("");
        String zqid = map.get("0");
        map.forEach((k, v) -> {
            if (!k.equals("0")) {
                org.apache.ibatis.jdbc.SQL sql = new org.apache.ibatis.jdbc.SQL();
                sql.INSERT_INTO("xsdbry_table");
                sql.SET("uuid", "dbrq", "peoId", "zqId");
                sql.VALUES("uuid", "'" + GetUuid.getUUID() + "'");
                sql.VALUES("dbrq", "'" + k + "'");
                sql.VALUES("peoId", "'" + v + "'");
                sql.VALUES("zqId", "'" + zqid + "'");
                sq.add(sql.toString() + ";");
            }
        });
        return sq.toString();
    }
}
