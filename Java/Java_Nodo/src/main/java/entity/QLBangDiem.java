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
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class QLBangDiem {
    public void writeDangkyExcel() throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet("BangDiem");
        XSSFRow row = null;
        Cell cell = null;
        row = spreadsheet.createRow(0);
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Sinh viên");
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Môn học");
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Ngày tạo");
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Điểm");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so sinh vien: ");
        int n = Integer.parseInt(sc.nextLine());
        List<BangDiem> bangDiemList = new ArrayList<>();
        List<SinhVien> sinhVienList = new ArrayList<>();
        List<MonHoc> monHocList = new ArrayList<>();
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
            System.out.println("Nhap ma mon hoc: ");
            String maMonHoc = sc.nextLine();
            System.out.println("Nhap ten mon hoc: ");
            String tenMonHoc = sc.nextLine();
            System.out.println("Nhap so tin chi: ");
            int soTinChi = Integer.parseInt(sc.nextLine());
            System.out.println("Nhap diem sinh vien: ");
            double diem = Double.parseDouble(sc.nextLine());

            SinhVien sinhVien = new SinhVien(name, address, maSv, lop);
            sinhVienList.add(sinhVien);
            // monhoc get data of tenMonHoc
            MonHoc monHoc = new MonHoc(maMonHoc, tenMonHoc, soTinChi);
            monHocList.add(monHoc);
            if (0 <= diem && diem <= 10) {
                System.out.println("Done !");
            } else {
                System.out.println("Nhap sai diem");
            }
            System.out.println("Nhap ngay dang ky: ");
            Date ngayTao = sdf.parse(sc.nextLine());
            BangDiem bangDiem = new BangDiem(maSv, name, address, lop, monHocList.toArray(new MonHoc[i]), (float) diem,
                    ngayTao);
            bangDiemList.add(bangDiem);

        }
        System.out.println(bangDiemList.get(0));

        for (int i = 0; i < bangDiemList.size(); i++) {
            row = spreadsheet.createRow(i + 1);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue(sinhVienList.get(i).getName());
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(monHocList.get(i).getTenMon());
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue(sdf.format(bangDiemList.get(i).getNgayTao()));
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue(bangDiemList.get(i).getDiem());
        }
        File file = new File("C:/Users/kienr/Desktop/Nodo/Java/Java_Nodo/BangDiem.xlsx");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        System.out.println("Done");
    }

    public void sort() {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook("C:/Users/kienr/Desktop/Nodo/Java/Java_Nodo/BangDiem.xlsx");
            XSSFSheet spreadsheet = workbook.getSheetAt(0);
            for (int i = 1; i < spreadsheet.getPhysicalNumberOfRows(); i++) {
                XSSFRow row = spreadsheet.getRow(i);
                for (int j = i + 1; j < spreadsheet.getPhysicalNumberOfRows(); j++) {
                    XSSFRow row1 = spreadsheet.getRow(j);
                    if (row.getCell(0).getStringCellValue().compareTo(row1.getCell(0).getStringCellValue()) > 0) {
                        XSSFRow temp = row;
                        row = row1;
                        row1 = temp;
                    }
                }
            }
            for (int i = 1; i < spreadsheet.getPhysicalNumberOfRows(); i++) {
                XSSFRow row = spreadsheet.getRow(i);
                System.out.println("Sinh vien: " + row.getCell(0).getStringCellValue());
                System.out.println("Mon hoc: " + row.getCell(1).getStringCellValue());
                System.out.println("Ngay Tao: " + row.getCell(2).getStringCellValue());
                System.out.println("Diem: " + row.getCell(3).getNumericCellValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
