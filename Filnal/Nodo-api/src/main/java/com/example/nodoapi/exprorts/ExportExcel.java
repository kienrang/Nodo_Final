package com.example.nodoapi.exprorts;

import com.example.nodoapi.entities.DanhMucEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExportExcel {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<DanhMucEntity> ls;

    public ExportExcel(List<DanhMucEntity> list) {
        this.ls = list;
        workbook = new XSSFWorkbook();
    }


    private void writeHeaderLine() {
        sheet = workbook.createSheet("");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "ID", style);
        createCell(row, 1, "Tên", style);
        createCell(row, 2, "Mã", style);
//        createCell(row, 3, "Ngày tạo", style);
        createCell(row, 4, "Thứ tự", style);
        createCell(row, 5, "Nhóm", style);
        createCell(row, 6, "Trạng thái", style);
        createCell(row, 7, "Loại danh mục", style);

    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeDataLines() {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (DanhMucEntity entity : this.ls) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, entity.getId(), style);
            createCell(row, columnCount++, entity.getTen(), style);
            createCell(row, columnCount++, entity.getMa(), style);
//            createCell(row, columnCount++, entity.getNgayTao(), style);
            createCell(row, columnCount++, entity.getThuTu(), style);
            createCell(row, columnCount++, entity.getNhom(), style);
            createCell(row, columnCount++, entity.getTrangThai(), style);
            createCell(row, columnCount++, entity.getLoaiDanhMuc().getTen(), style);

        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
