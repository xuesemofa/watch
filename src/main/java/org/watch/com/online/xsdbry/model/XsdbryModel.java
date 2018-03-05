package org.watch.com.online.xsdbry.model;

/**
 * @author ld
 * @name 周期内由谁来带班
 * @table
 * @remarks
 */
public class XsdbryModel {
    private String uuid;
    private String dbrq;
    private String peoId;
    private String zqId;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDbrq() {
        return dbrq;
    }

    public void setDbrq(String dbrq) {
        this.dbrq = dbrq;
    }

    public String getPeoId() {
        return peoId;
    }

    public void setPeoId(String peoId) {
        this.peoId = peoId;
    }

    public String getZqId() {
        return zqId;
    }

    public void setZqId(String zqId) {
        this.zqId = zqId;
    }

    public XsdbryModel() {
        super();
    }

    public XsdbryModel(String uuid, String dbrq, String peoId, String zqId) {
        this.uuid = uuid;
        this.dbrq = dbrq;
        this.peoId = peoId;
        this.zqId = zqId;
    }

    @Override
    public String toString() {
        return "XsdbryModel{" +
                "uuid='" + uuid + '\'' +
                ", dbrq='" + dbrq + '\'' +
                ", peoId='" + peoId + '\'' +
                ", zqId='" + zqId + '\'' +
                '}';
    }
}
