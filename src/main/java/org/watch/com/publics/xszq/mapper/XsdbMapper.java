package org.watch.com.publics.xszq.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.watch.com.publics.xszq.model.XsdbModel;

import java.util.List;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public interface XsdbMapper {

    String table = " xsdb_table ";

    @Insert({
            "insert into " + table + " (uuid,peopleId,zqId,dbrq) values (#{model.uuid},#{model.peopleId},#{model.zqId},#{model.dbrq})"
    })
    int save(@Param("model") XsdbModel model);

    @Select({
            "select * from " + table + " where zqId = #{zqid}"
    })
    List<XsdbModel> findAll(@Param("zqid") String zaid);
}
