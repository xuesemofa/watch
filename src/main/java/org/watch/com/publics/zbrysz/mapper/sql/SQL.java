package org.watch.com.publics.zbrysz.mapper.sql;

import org.watch.com.publics.zbrysz.model.ZbryModel;
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
    public String insert1(Map<String, ZbryModel> map) {
        StringJoiner sq = new StringJoiner("");
        map.forEach((k, v) -> {
            org.apache.ibatis.jdbc.SQL sql = new org.apache.ibatis.jdbc.SQL();
            sql.INSERT_INTO("zbry_table");
            sql.SET("uuid", "amid", "pmid", "zwid", "zbrq", "zqid");
            sql.VALUES("uuid", "'" + GetUuid.getUUID() + "'");
            sql.VALUES("amid", "'" + v.getAmid() + "'");
            sql.VALUES("pmid", "'" + v.getPmid() + "'");
            sql.VALUES("zwid", "'" + v.getZwid() + "'");
            sql.VALUES("zbrq", "'" + v.getZbrq() + "'");
            sql.VALUES("zqid", "'" + v.getZqid() + "'");
            sq.add(sql.toString() + ";");
        });
        return sq.toString();
    }

}
