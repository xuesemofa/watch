package org.watch.com.publics.account.service;

import org.watch.com.publics.account.model.AccountModel;
import org.watch.com.util.resultJson.ResponseResult;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public interface AccountService {

    ResponseResult<AccountModel> add(AccountModel model);

    ResponseResult<AccountModel> updatePWD(String account, String pwd);

    ResponseResult<AccountModel> getByAccount(String account);
}
