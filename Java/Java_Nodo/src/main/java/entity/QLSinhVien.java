package entity;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QLSinhVien {
    public void wirteSinhVienExcel() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet("SinhVien");
        XSSFRow row = null;
        Cell cell = null;
        row = spreadsheet.createRow(0);
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Ma sinh vien");
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Ten sinh vien");
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Địa chỉ");
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Lop");

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so sinh vien: ");
        int n = Integer.parseInt(sc.nextLine());
        List<SinhVien> sinhVienList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin sinh vien thu " + (i + 1));
            System.out.println("Nhap ma sinh vien: ");
            String maSv = sc.nextLine();
            System.out.println("Nhap ten sinh vien: ");
            String name = sc.nextLine();
            System.out.println("Nhap dia chi sinh vien: ");
            String address = sc.nextLine();
            System.out.println("Nhap lop sinh vien: ");
            String lop = sc.nextLine();
            SinhVien sinhVien = new SinhVien(name, address, maSv, lop);
            sinhVienList.add(sinhVien);
        }
        for (int i = 0; i < sinhVienList.size(); i++) {
            row = spreadsheet.createRow(i + 1);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue(sinhVienList.get(i).getMaSv());
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(sinhVienList.get(i).getName());
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue(sinhVienList.get(i).getAddress());
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue(sinhVienList.get(i).getLop());
        }
        File file = new File("C:/Users/kienr/Desktop/Nodo/Java/Java_Nodo/SinhVien.xlsx");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        System.out.println("Done");
    }
}
