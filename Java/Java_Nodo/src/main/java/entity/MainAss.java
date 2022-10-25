package entity;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainAss {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int chon;
        QLBangDiem qlBangDiem = new QLBangDiem();
        QLMonHoc qlMonHoc = new QLMonHoc();

        QLSinhVien qlSinhVien = new QLSinhVien();
        while (true) {
            System.out.println("1. Nhap thong tin mon hoc");
            System.out.println("2. Nhap thong tin sinh vien");
            System.out.println("3. Nhap thong tin bang diem");
            System.out.println("4. Xuat thong tin bang diem");
            System.out.println("Nhap lua chon: ");
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 1:
                    qlMonHoc.wirteMonHocExcel();
                    break;
                case 2:
                    qlSinhVien.wirteSinhVienExcel();
                    break;
                case 3:
                    qlBangDiem.writeDangkyExcel();
                    break;
                case 4:
                    qlBangDiem.sort();
                    break;
                default:
                    System.out.println("Nhap sai");
                    break;
            }
        }
    }
}
