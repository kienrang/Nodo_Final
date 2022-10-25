package entity;

public class SinhVien extends ConNguoi {
    private String maSv;
    private String lop;

    public SinhVien(String name, String address, String maSv, String lop) {
        super(name, address);
        this.maSv = maSv;
        this.lop = lop;
    }

    public SinhVien(String maSv, String lop) {
        this.maSv = maSv;
        this.lop = lop;
    }

    public SinhVien() {
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    @Override
    public String toString() {
        return "Student{" +
                "maSv='" + maSv + '\'' +
                ", lop='" + lop + '\'' +
                "name='" + getName() + '\'' +
                ", address='" + getAddress() + '\'' +
                '}';
    }
}
