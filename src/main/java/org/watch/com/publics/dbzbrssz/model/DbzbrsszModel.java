package org.watch.com.publics.dbzbrssz.model;

import java.io.Serializable;

public class DbzbrsszModel implements Serializable {
    private String uuid;
    private String dates;
    private String rs;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getRs() {
        return rs;
    }

    public void setRs(String rs) {
        this.rs = rs;
    }

    public DbzbrsszModel() {
        super();
    }

    public DbzbrsszModel(String uuid, String dates, String rs) {
        super();
        this.uuid = uuid;
        this.dates = dates;
        this.rs = rs;
    }

    @Override
    public String toString() {
        return "DbzbrsszModel [uuid=" + uuid + ", dates=" + dates + ", rs=" + rs + "]";
    }
}
