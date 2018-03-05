package org.watch.com.publics.xszq.model;

/**
 * @author ld
 * @name
 * @table xsdb_table
 * @remarks
 */
public class XsdbModel {
    private String uuid;
    private String peopleId;
    private String zqId;
    private String dbrq;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(String peopleId) {
        this.peopleId = peopleId;
    }

    public String getZqId() {
        return zqId;
    }

    public void setZqId(String zqId) {
        this.zqId = zqId;
    }

    public String getDbrq() {
        return dbrq;
    }

    public void setDbrq(String dbrq) {
        this.dbrq = dbrq;
    }

    public XsdbModel() {
        super();
    }

    public XsdbModel(String uuid, String peopleId, String zqId, String dbrq) {
        this.uuid = uuid;
        this.peopleId = peopleId;
        this.zqId = zqId;
        this.dbrq = dbrq;
    }

    @Override
    public String toString() {
        return "XsdbModel{" +
                "uuid='" + uuid + '\'' +
                ", peopleId='" + peopleId + '\'' +
                ", zqId='" + zqId + '\'' +
                ", dbrq='" + dbrq + '\'' +
                '}';
    }
}
