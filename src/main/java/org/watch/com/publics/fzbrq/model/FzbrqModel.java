package org.watch.com.publics.fzbrq.model;

import java.io.Serializable;

/**
 * @author ld
 * @name 非值班日期，设置哪些日期不需要生成值班
 * @table
 * @remarks
 */
public class FzbrqModel implements Serializable {

    private String uuid;
    private String dates;
    private String lx;

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

    public String getLx() {
        return lx;
    }

    public void setLx(String lx) {
        this.lx = lx;
    }

    public FzbrqModel() {
        super();
    }

    public FzbrqModel(String uuid, String dates, String lx) {
        this.uuid = uuid;
        this.dates = dates;
        this.lx = lx;
    }

    @Override
    public String toString() {
        return "FzbrqModel{" +
                "uuid='" + uuid + '\'' +
                ", dates='" + dates + '\'' +
                ", lx='" + lx + '\'' +
                '}';
    }
}
