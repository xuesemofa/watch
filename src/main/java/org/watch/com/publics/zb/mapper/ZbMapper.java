package org.watch.com.publics.zb.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;
import org.watch.com.publics.people.model.PeopleModel;
import org.watch.com.publics.zb.mapper.sql.SQL;
import org.watch.com.publics.zb.model.ZbModel;

import java.util.Map;

public interface ZbMapper {

    String table = " zb_table ";

    @Insert({
            "insert into " + table + " (uuid,people_id,code) values (#{model.uuid},#{model.people_id},#{model.code})"
    })
    int add(@Param("model") ZbModel model);

    @Delete({
            "delete " + table + " where people_id = #{id}"
    })
    int del(@Param("id") String id);

    @Update({
            "update " + table + " set code = #{code} where people_id = #{id}"
    })
    int update(@Param("id") String id, @Param("code") int code);

    @UpdateProvider(type = SQL.class, method = "updates")
    int updates(Map<String, Integer> map);

    @Select({
            "select p.uuid,p.name,p.sex,p.department,p.dz,d.code as code from " + table
                    + " d left join people_table p on p.uuid = d.people_id ORDER BY d.code"
    })
    Page<PeopleModel> find();

    @Select({
            "select p.uuid,p.name,p.sex,p.department,p.dz,d.code as code from " + table
                    + " d left join people_table p on p.uuid = d.people_id where p.name " +
                    "like #{name} or p.sex like #{name} ORDER BY d.code"
    })
    Page<PeopleModel> findByName(@Param("name") String name);

    @Select({
            "select p.uuid,p.name,p.sex,p.department,p.dz,d.code as code from " + table
                    + " d left join people_table p on p.uuid = d.people_id where p.dz " +
                    "= #{dz} and p.sex = #{sex} ORDER BY d.code"
    })
    Page<PeopleModel> findByName2(@Param("dz") String dz, @Param("sex") String sex);

    @Select({
            "select * from " + table + " where people_id = #{id}"
    })
    ZbModel getByPId(@Param("id") String id);
}
