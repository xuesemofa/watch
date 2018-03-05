package org.watch.com.publics.login.model;


import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class LoginModel {

    @NotBlank(message = "账户不能为空")
    @Length(message = "密码长度为8-20", min = 7, max = 20)
    private String username;

    @NotBlank(message = "密码不能为空")
    @Length(message = "密码长度为8-20", min = 7, max = 20)
    private String password;

    private String yzm;

    private int types;

    public LoginModel() {
        super();
    }

    public LoginModel(String username, String password, String yzm, int types) {
        this.username = username;
        this.password = password;
        this.yzm = yzm;
        this.types = types;
    }

    public int getTypes() {
        return types;
    }

    public void setTypes(int types) {
        this.types = types;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getYzm() {
        return yzm;
    }

    public void setYzm(String yzm) {
        this.yzm = yzm;
    }

    @Override
    public String toString() {
        return "LoginModel{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", yzm='" + yzm + '\'' +
                '}';
    }
}
