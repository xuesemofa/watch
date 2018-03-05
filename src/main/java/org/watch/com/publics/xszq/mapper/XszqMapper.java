package org.watch.com.publics.xszq.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.watch.com.publics.xszq.model.XszqModel;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public interface XszqMapper {

    String table = " xszq_table ";

    @Insert({
            "insert into " + table + " (uuid,strDate,endDate) values (#{model.uuid},#{model.strDate},#{model.endDate})"
    })
    int save(@Param("model") XszqModel model);

    @Delete({
            "delete " + table + " where uuid = #{id}"
    })
    int del(@Param("id") String id);

    @Select({
            "select * from " + table + " where uuid = #{id}"
    })
    XszqModel getById(@Param("id") String id);

    @Select({
            "select * from " + table + ""
    })
    Page<XszqModel> find();

    @Select({
            "select * from xszq_table x where x.uuid NOT in (select t.zqId from xsdbry_table t)"
    })
    Page<XszqModel> find2();

    @Select({
            "select * from xszq_table x where x.uuid NOT in (select t.zqid from zbry_table t)"
    })
    Page<XszqModel> find3();

}
