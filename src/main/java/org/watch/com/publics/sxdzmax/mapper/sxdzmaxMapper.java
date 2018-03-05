package org.watch.com.publics.sxdzmax.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.watch.com.publics.sxdzmax.model.sxdzmax;

import java.util.List;

/**
 * @author ld
 * @name 带班值班最大值维护
 * @table
 * @remarks
 */
public interface sxdzmaxMapper {

    @Update({
            "update sxdzmax_table set max = #{max} where sorx = #{sorx} and dorz = #{dorz}"
    })
    int update(@Param("max") String max, @Param("sorx") String sorx, @Param("dorz") String dorz);

    @Select({
            "select * from sxdzmax_table"
    })
    List<sxdzmax> finds();
}
