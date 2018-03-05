package org.watch.com.publics.zbrysz.model;

import java.io.Serializable;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class ZbryModel2 implements Serializable {
    private String am1;
    private String am2;
    private String am3;
    private String pm1;
    private String pm2;
    private String pm3;
    private String zw1;
    private String zw2;
    private String zw3;
    private String birth;

    public String getAm1() {
        return am1;
    }

    public void setAm1(String am1) {
        this.am1 = am1;
    }

    public String getAm2() {
        return am2;
    }

    public void setAm2(String am2) {
        this.am2 = am2;
    }

    public String getAm3() {
        return am3;
    }

    public void setAm3(String am3) {
        this.am3 = am3;
    }

    public String getPm1() {
        return pm1;
    }

    public void setPm1(String pm1) {
        this.pm1 = pm1;
    }

    public String getPm2() {
        return pm2;
    }

    public void setPm2(String pm2) {
        this.pm2 = pm2;
    }

    public String getPm3() {
        return pm3;
    }

    public void setPm3(String pm3) {
        this.pm3 = pm3;
    }

    public String getZw1() {
        return zw1;
    }

    public void setZw1(String zw1) {
        this.zw1 = zw1;
    }

    public String getZw2() {
        return zw2;
    }

    public void setZw2(String zw2) {
        this.zw2 = zw2;
    }

    public String getZw3() {
        return zw3;
    }

    public void setZw3(String zw3) {
        this.zw3 = zw3;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public ZbryModel2() {
        super();
    }

    public ZbryModel2(String am1, String am2, String am3, String pm1, String pm2, String pm3, String zw1, String zw2, String zw3, String birth) {
        this.am1 = am1;
        this.am2 = am2;
        this.am3 = am3;
        this.pm1 = pm1;
        this.pm2 = pm2;
        this.pm3 = pm3;
        this.zw1 = zw1;
        this.zw2 = zw2;
        this.zw3 = zw3;
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "ZbryModel2{" +
                "am1='" + am1 + '\'' +
                ", am2='" + am2 + '\'' +
                ", am3='" + am3 + '\'' +
                ", pm1='" + pm1 + '\'' +
                ", pm2='" + pm2 + '\'' +
                ", pm3='" + pm3 + '\'' +
                ", zw1='" + zw1 + '\'' +
                ", zw2='" + zw2 + '\'' +
                ", zw3='" + zw3 + '\'' +
                ", birth='" + birth + '\'' +
                '}';
    }
}
