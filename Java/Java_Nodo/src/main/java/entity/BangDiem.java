package entity;

import java.util.Arrays;
import java.util.Date;

public class BangDiem extends SinhVien{
    private MonHoc[] monHocs;
    private float diem;
    private Date ngayTao;

    public BangDiem(String name, String address, String maSv, String lop, MonHoc[] monHocs, float diem, Date ngayTao) {
        super(name, address, maSv, lop);
        this.monHocs = monHocs;
        this.diem = diem;
        this.ngayTao = ngayTao;
    }

    public BangDiem(String maSv, String lop, MonHoc[] monHocs, float diem, Date ngayTao) {
        super(maSv, lop);
        this.monHocs = monHocs;
        this.diem = diem;
        this.ngayTao = ngayTao;
    }

    public BangDiem(MonHoc[] monHocs, float diem, Date ngayTao) {
        this.monHocs = monHocs;
        this.diem = diem;
        this.ngayTao = ngayTao;
    }

    public BangDiem() {
    }

    public MonHoc[] getMonHocs() {
        return monHocs;
    }

    public void setMonHocs(MonHoc[] monHocs) {
        this.monHocs = monHocs;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    @Override
    public String toString() {
        return "BangDiem{" +
                "monHocs=" + Arrays.toString(monHocs) +
                ", diem=" + diem +
                ", ngayTao=" + ngayTao +
                '}';
    }
}
