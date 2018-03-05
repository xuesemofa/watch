package org.watch.com.publics.dbzbrssz.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.watch.com.publics.dbzbrssz.model.DbzbrsszModel;

import java.util.List;

public interface DbzbrsszMapper {
    String table = " dbzbrssz_table ";

    @Insert({
            "insert into " + table + " (uuid,dates,rs) values (#{model.uuid},#{model.dates},#{model.rs})"
    })
    int save(@Param("model") DbzbrsszModel model);

    @Delete({
            "delete " + table + " where uuid = #{id}"
    })
    int del(@Param("id") String id);

    @Select({
            "select * from " + table + " where dates >= #{strDate} and dates <= #{endDate}"
    })
    List<DbzbrsszModel> findByDates(@Param("strDate") String strDate, @Param("endDate") String endDate);

    @Select({
            "select * from " + table + " where dates = #{date}"
    })
    List<DbzbrsszModel> findByDates2(@Param("date") String date);

    @Select({
            "select * from " + table + " order by dates desc"
    })
    Page<DbzbrsszModel> find();
}
