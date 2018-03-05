package org.watch.com.publics.account.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.watch.com.publics.account.model.AccountModel;

/**
 * @author ld
 * @name
 * @table account_table
 * @remarks
 */
public interface AccountMapper {

    @Insert({
            "insert into account_table (uuid,account,password,types,locking) values (#{model.uuid},#{model.account}," +
                    "@{model.password},#{model.types},#{model.locking})"
    })
    int add(@Param("model") AccountModel model);

    @Update({
            "update account_table set password = #{pwd} where account = #{account}"
    })
    int updatePWD(@Param("account") String account, @Param("pwd") String pwd);

    @Select({
            "select * from account_table where account = #{account}"
    })
    AccountModel getByAccount(@Param("account") String account);
}
