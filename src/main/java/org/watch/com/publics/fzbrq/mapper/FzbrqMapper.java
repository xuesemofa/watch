package org.watch.com.publics.fzbrq.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.watch.com.publics.fzbrq.model.FzbrqModel;

import java.util.List;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public interface FzbrqMapper {

    String table = " fzbrq_table ";

    @Insert({
            "insert into " + table + " (uuid,dates,lx) values (#{model.uuid},#{model.dates},#{model.lx})"
    })
    int save(@Param("model") FzbrqModel model);

    @Delete({
            "delete " + table + " where uuid = #{id}"
    })
    int del(@Param("id") String id);

    @Select({
            "select * from " + table + " where dates >= #{strDate} and dates <= #{endDate}"
    })
    List<FzbrqModel> findByDates(@Param("strDate") String strDate, @Param("endDate") String endDate);

    @Select({
            "select * from " + table + " where dates = #{date}"
    })
    List<FzbrqModel> findByDates2(@Param("date") String date);


    @Select({
            "select * from " + table + " order by dates desc"
    })
    Page<FzbrqModel> find();
}
