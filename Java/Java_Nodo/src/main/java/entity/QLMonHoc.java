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

public class QLMonHoc {
    public void wirteMonHocExcel() throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        XSSFSheet spreadsheet = workbook.createSheet("MonHoc");
        XSSFRow row = null;
        Cell cell = null;
        row = spreadsheet.createRow(0);
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Ma mon hoc");
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Ten mon hoc");
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("So tin chi");
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so mon hoc: ");
        int n = Integer.parseInt(sc.nextLine());
        List<MonHoc> monHocList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin mon hoc thu " + (i + 1));
            System.out.println("Nhap ma mon hoc: ");
            String maMonHoc = sc.nextLine();
            System.out.println("Nhap ten mon hoc: ");
            String tenMonHoc = sc.nextLine();
            System.out.println("Nhap so tin chi: ");
            int soTinChi = Integer.parseInt(sc.nextLine());
            MonHoc monHoc = new MonHoc(maMonHoc, tenMonHoc, soTinChi);
            monHocList.add(monHoc);
        }
        for (int i = 0; i < monHocList.size(); i++) {
            row = spreadsheet.createRow(i + 1);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue(monHocList.get(i).getMaMon());
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(monHocList.get(i).getTenMon());
            cell = row.createCell(2, CellType.NUMERIC);
            cell.setCellValue(monHocList.get(i).getSoTinChi());
        }
        File file = new File("C:/Users/kienr/Desktop/Nodo/Java/Java_Nodo/MonHoc.xlsx");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        System.out.println("Done");
        System.out.println("File saved at " + file.getAbsolutePath());
        System.out.println("File name: " + file.getName());
        System.out.println(monHocList);
    }
}
