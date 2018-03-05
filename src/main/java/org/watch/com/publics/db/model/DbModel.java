package org.watch.com.publics.db.model;

import java.io.Serializable;

/**
 * @author ld
 * @name 带班人员及顺序
 * @table db_table
 * @remarks
 */
public class DbModel implements Serializable {
    //    uuid
    private String uuid;
    //    people id
    private String people_id;
    //    顺序
    private int code;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPeople_id() {
        return people_id;
    }

    public void setPeople_id(String people_id) {
        this.people_id = people_id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DbModel() {
        super();
    }

    public DbModel(String uuid, String people_id, int code) {
        this.uuid = uuid;
        this.people_id = people_id;
        this.code = code;
    }

    @Override
    public String toString() {
        return "DbModel{" +
                "uuid='" + uuid + '\'' +
                ", people_id='" + people_id + '\'' +
                ", code=" + code +
                '}';
    }
}
