package org.watch.com.publics.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.watch.com.publics.account.mapper.AccountMapper;
import org.watch.com.publics.account.model.AccountModel;
import org.watch.com.publics.account.service.AccountService;
import org.watch.com.util.resultJson.ResponseResult;

import javax.annotation.Resource;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper mapper;
    @Autowired
    private ResponseResult<AccountModel> result;

    @Override
    public ResponseResult<AccountModel> add(AccountModel model) {
        AccountModel model1 = mapper.getByAccount(model.getAccount());
        if (model1 == null || model.getAccount() == null || model1.getAccount().isEmpty()) {
            result.setSuccess(false);
            result.setCode(501);
            result.setMessage("账号重复");
            result.setData(null);
            return result;
        }
        model.setTypes("user");
        int i = mapper.add(model);
        switch (i) {
            case 1:
                result.setSuccess(true);
                result.setCode(200);
                result.setMessage("成功");
                result.setData(null);
                break;
            default:
                result.setSuccess(false);
                result.setCode(500);
                result.setMessage("账号添加失败");
                result.setData(null);
        }
        return result;
    }

    @Override
    public ResponseResult<AccountModel> updatePWD(String account, String pwd) {
        int i = mapper.updatePWD(account, pwd);
        switch (i) {
            case 1:
                result.setSuccess(true);
                result.setCode(200);
                result.setMessage("成功");
                result.setData(null);
                break;
            default:
                result.setSuccess(false);
                result.setCode(500);
                result.setMessage("账号修改失败");
                result.setData(null);
        }
        return result;
    }

    @Override
    public ResponseResult<AccountModel> getByAccount(String account) {
        AccountModel model = mapper.getByAccount(account);
        if (model == null) {
            result.setSuccess(false);
            result.setCode(404);
            result.setMessage("未找到账号");
            result.setData(null);
        } else {
            result.setSuccess(true);
            result.setCode(200);
            result.setMessage("成功");
            result.setData(model);
        }
        return result;
    }
}
