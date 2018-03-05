package org.watch.com.publics.zbrysz.model;

import java.io.Serializable;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class ZbryModel implements Serializable {
    //    uuid
    private String uuid;
    //    ampeoid
    private String amid;
    //    pmpeoid
    private String pmid;
    //    zwpeoid
    private String zwid;
    //    zbrq
    private String zbrq;

    private String zqid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAmid() {
        return amid;
    }

    public void setAmid(String amid) {
        this.amid = amid;
    }

    public String getPmid() {
        return pmid;
    }

    public void setPmid(String pmid) {
        this.pmid = pmid;
    }

    public String getZwid() {
        return zwid;
    }

    public void setZwid(String zwid) {
        this.zwid = zwid;
    }

    public String getZbrq() {
        return zbrq;
    }

    public void setZbrq(String zbrq) {
        this.zbrq = zbrq;
    }

    public String getZqid() {
        return zqid;
    }

    public void setZqid(String zqid) {
        this.zqid = zqid;
    }

    public ZbryModel() {
        super();
    }

    public ZbryModel(String uuid, String amid, String pmid, String zwid, String zbrq, String zqid) {
        this.uuid = uuid;
        this.amid = amid;
        this.pmid = pmid;
        this.zwid = zwid;
        this.zbrq = zbrq;
        this.zqid = zqid;
    }

    @Override
    public String toString() {
        return "ZbryModel{" +
                "uuid='" + uuid + '\'' +
                ", amid='" + amid + '\'' +
                ", pmid='" + pmid + '\'' +
                ", zwid='" + zwid + '\'' +
                ", zbrq='" + zbrq + '\'' +
                ", zqid='" + zqid + '\'' +
                '}';
    }
}
