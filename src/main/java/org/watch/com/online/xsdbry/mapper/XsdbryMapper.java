package org.watch.com.online.xsdbry.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.watch.com.online.xsdbry.mapper.sql.SQL;
import org.watch.com.publics.people.model.PeopleModel;

import java.util.List;
import java.util.Map;

/**
 * @author ld
 * @name 周期内带班人员带班记录
 * @table
 * @remarks
 */
public interface XsdbryMapper {

    @InsertProvider(type = SQL.class, method = "insert1")
    int save(Map<String, String> map);

    @Delete({
            "delete xsdbry_table where zqId = #{id}"
    })
    int del(@Param("id") String id);

    @Select({
            "select p.name,p.sex,p.department,x.dbrq as birth from xsdbry_table x LEFT JOIN people_table p on p.uuid = x.peoId " +
                    "where x.zqId = #{zqid} ORDER BY CONVERT(DATE, x.dbrq, 23)"
    })
    List<PeopleModel> query(@Param("zqid") String zqid);
}
