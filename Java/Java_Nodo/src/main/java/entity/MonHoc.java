package entity;

import java.util.Scanner;

public class MonHoc {
    private String maMon;
    private String tenMon;
    private int soTinChi;

     public MonHoc(String maMon, String tenMon, int soTinChi) {
          this.maMon = maMon;
          this.tenMon = tenMon;
          this.soTinChi = soTinChi;
     }

    public MonHoc() {
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }

    @Override
    public String toString() {
        return "MonHoc{" +
                "maMon='" + maMon + '\'' +
                ", tenMon='" + tenMon + '\'' +
                ", soTinChi=" + soTinChi +
                '}';
    }
}
