package org.watch.com.publics.sxdzmax.model;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class sxdzmax {
    private String sorx;
    private String dorz;
    private String max;

    public String getSorx() {
        return sorx;
    }

    public void setSorx(String sorx) {
        this.sorx = sorx;
    }

    public String getDorz() {
        return dorz;
    }

    public void setDorz(String dorz) {
        this.dorz = dorz;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public sxdzmax() {
        super();
    }

    public sxdzmax(String sorx, String dorz, String max) {
        this.sorx = sorx;
        this.dorz = dorz;
        this.max = max;
    }

    @Override
    public String toString() {
        return "sxdzmax{" +
                "sorx='" + sorx + '\'' +
                ", dorz='" + dorz + '\'' +
                ", max='" + max + '\'' +
                '}';
    }
}
