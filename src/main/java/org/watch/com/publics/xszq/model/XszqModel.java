package org.watch.com.publics.xszq.model;

/**
 * @author ld
 * @name 周期管理
 * @table xszq_table
 * @remarks
 */
public class XszqModel {
    //    uuid
    private String uuid;
    //    周期开始时间
    private String strDate;
    //    周期结束时间
    private String endDate;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getStrDate() {
        return strDate;
    }

    public void setStrDate(String strDate) {
        this.strDate = strDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public XszqModel() {
        super();
    }

    public XszqModel(String uuid, String strDate, String endDate) {
        this.uuid = uuid;
        this.strDate = strDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "XszqModel{" +
                "uuid='" + uuid + '\'' +
                ", strDate=" + strDate +
                ", endDate=" + endDate +
                '}';
    }
}
