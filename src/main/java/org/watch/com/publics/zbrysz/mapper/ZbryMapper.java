package org.watch.com.publics.zbrysz.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.watch.com.publics.zbrysz.mapper.sql.SQL;
import org.watch.com.publics.zbrysz.model.ZbryModel;

import java.util.List;
import java.util.Map;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public interface ZbryMapper {

    @InsertProvider(type = SQL.class, method = "insert1")
    int save(Map<String, ZbryModel> map);

    @Delete({
            "delete zbry_table where zqid = #{id}"
    })
    int del(@Param("id") String id);

    @Select({
            "select * from zbry_table z where z.zqid = #{zqid} ORDER BY CONVERT(DATE, z.zbrq, 23)"
    })
    List<ZbryModel> query(@Param("zqid") String zqid);
}
