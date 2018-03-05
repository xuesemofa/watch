package org.watch.com.publics.account.model;

import java.io.Serializable;

/**
 * @author ld
 * @name 账户
 * @table account_table
 * @remarks
 */
public class AccountModel implements Serializable {
    //    账户
    private String account;
    //    密码
    private String password;
    //    类型
    private String types;
    //    是否锁定
    private String locking;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getLocking() {
        return locking;
    }

    public void setLocking(String locking) {
        this.locking = locking == null || locking.isEmpty() ? "N" : locking;
    }

    public AccountModel() {
        super();
    }

    public AccountModel(String account, String password, String types, String locking) {
        this.account = account;
        this.password = password;
        this.types = types;
        this.locking = locking;
    }

    @Override
    public String toString() {
        return "AccountModel{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", types='" + types + '\'' +
                ", locking='" + locking + '\'' +
                '}';
    }
}
