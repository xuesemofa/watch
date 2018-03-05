package org.watch.com.publics.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.watch.com.publics.account.model.AccountModel;
import org.watch.com.publics.account.service.AccountService;
import org.watch.com.util.resultJson.ResponseResult;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService service;

    @RequestMapping(value = "/toPWD", method = RequestMethod.GET)
    public ModelAndView toPWD() {
        return new ModelAndView("/account/pwd");
    }

    @RequestMapping(value = "/pwd", method = RequestMethod.POST)
    public ResponseResult pwd(@RequestParam("password") String password,
                              @RequestParam("password1") String password1,
                              @RequestParam("password2") String password2,
                              HttpServletRequest request) {

        ResponseResult<AccountModel> result = new ResponseResult<>();

        Cookie[] cookies = request.getCookies();
        String token = "";
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("token")) {
                token = cookies[i].getValue();
                continue;
            }
        }
        if (token.isEmpty()) {
            result.setSuccess(false);
            result.setCode(500);
            result.setMessage("请从新登录!");
            return result;
        }

        if (password == null
                || password1 == null
                || password2 == null
                || password1.isEmpty()
                || password.isEmpty()
                || !password1.equals(password2)) {
            result.setSuccess(false);
            result.setCode(400);
            result.setMessage("请完善信息或两次密码不一致!");
            return result;
        }

        if (password1.length() < 8 || password1.length() > 20) {
            result.setSuccess(false);
            result.setCode(400);
            result.setMessage("密码长度为8-20位!");
            return result;
        }

        result = service.getByAccount(token);
        if (result.isSuccess()) {
            if (result.getData().getPassword().equals(password)) {
                result = service.updatePWD(token, password1);
                if (result.isSuccess()) {
                    result.setSuccess(true);
                    result.setCode(200);
                    result.setMessage("修改成功!");
                } else {
                    result.setSuccess(false);
                    result.setCode(500);
                    result.setMessage("修改失败!");
                }
            } else {
                result.setSuccess(false);
                result.setCode(400);
                result.setMessage("密码错误!");
            }
        } else {
            result.setSuccess(false);
            result.setCode(404);
            result.setMessage("账号已不存在!");
        }
        return result;
    }
}
