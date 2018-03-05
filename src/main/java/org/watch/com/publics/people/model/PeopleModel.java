package org.watch.com.publics.people.model;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @author ld
 * @name 基础人员管理
 * @table people_table
 * @remarks
 */
public class PeopleModel implements Serializable {
    //    uuid
    private String uuid;
    //    姓名
    @NotBlank(message = "姓名不能为空")
    private String name;
    //    性别
    @NotBlank(message = "性别不能为空")
    private String sex;
    //    部门
    @NotBlank(message = "部门不能为空")
    private String department;
    //    出生年月日
    private String birth;
    //    带班值班 D带班 Z值班
    private String dz;
    private int code;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getDz() {
        return dz;
    }

    public void setDz(String dz) {
        this.dz = dz;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public PeopleModel() {
        super();
    }

    public PeopleModel(String uuid, String name, String sex, String department, String birth) {
        this.uuid = uuid;
        this.name = name;
        this.sex = sex;
        this.department = department;
        this.birth = birth;
    }

    public PeopleModel(String uuid, String name, String sex, String department, String birth, String dz, int code) {
        this.uuid = uuid;
        this.name = name;
        this.sex = sex;
        this.department = department;
        this.birth = birth;
        this.dz = dz;
        this.code = code;
    }

    @Override
    public String toString() {
        return "PeopleModel{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", department='" + department + '\'' +
                ", birth='" + birth + '\'' +
                ", dz='" + dz + '\'' +
                ", code=" + code +
                '}';
    }
}
