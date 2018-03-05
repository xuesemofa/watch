package org.watch.com.publics.people.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;
import org.watch.com.publics.people.model.PeopleModel;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public interface PeopleMapper {

    String table = " people_table ";

    @Insert({
            "insert into" + table + "(uuid,name,sex,department,birth,dz,code) " +
                    " values (#{model.uuid},#{model.name},#{model.sex},#{model.department},#{model.birth}," +
                    "#{model.dz},#{model.code})"
    })
    int save(@Param("model") PeopleModel model);

    @Delete({
            "delete from " + table + " where uuid = #{id}"
    })
    int del(@Param("id") String id);

    @Update({
            "update " + table + " set name=#{model.name},sex=#{model.sex},department=#{model.department}," +
                    "birth=#{model.birth},dz = #{model.dz},code=#{model.code}"
    })
    int update(@Param("model") PeopleModel model);

    @Select({
            "select * from " + table + " where uuid = #{id}"
    })
    PeopleModel getById(@Param("id") String id);

    @Select({
            "select * from " + table+" order by name"
    })
    Page<PeopleModel> find();

    @Select({
            "select * from " + table + " where name like #{name} order by name"
    })
    Page<PeopleModel> findByName(@Param("name") String name);
}
