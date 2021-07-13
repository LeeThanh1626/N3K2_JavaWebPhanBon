/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import model.Order;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author NAM
 */
public class CartExcelExporter {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Order> listOrders;

    public CartExcelExporter(List<Order> listOrders) {
        this.listOrders = listOrders;
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Orders");
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeHeaderRow() {
     

        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(10);
        font.getFamily();
        style.setFont(font);
//            Cell cell = row.createCell(0);
//            cell.setCellValue("PHIẾU THU");
//            
//              cell = row.createCell(1);
//            cell.setCellValue("Order ID");
//            
//            cell = row.createCell(2);
//            cell.setCellValue("Số Điện Thoại");
//            
//            cell = row.createCell(3);
//            cell.setCellValue("Tên Khách Hàng");
//            
//            cell = row.createCell(4);
//            cell.setCellValue("Tên Sản Phẩm");
//            
//            cell = row.createCell(5);
//            cell.setCellValue("Giá tiền");
//            
//            cell = row.createCell(6);
//            cell.setCellValue("Số Lượng");
//            
//            cell = row.createCell(7);
//            cell.setCellValue("Tổng Tiền");
//            
//            cell = row.createCell(8);
//            cell.setCellValue("Ngày mua");
//            
//            cell = row.createCell(9);
//            cell.setCellValue("Ký tên xác nhận(Ghi rõ họ và tên)");
             createCell(row, 0, "PHIẾU THU", style);      
        createCell(row, 1, "Order ID", style);       
        createCell(row, 2, "Số Điện Thoại",style);  
        createCell(row, 3, "Tên Khách Hàng",style);
        createCell(row, 4, "Tên Sản Phẩm",style);
        createCell(row, 5, "Giá tiền",style);
        createCell(row, 6, "Số Lượng",style);
        createCell(row, 7, "Tổng Tiền",style);
        createCell(row, 8, "Ngày mua",style);
        createCell(row, 9, "Ký tên xác nhận(Ghi rõ họ và tên)", style);
       
    }

    private void writeDataRows() {
        int rowCount = 1;
//        CellStyle style = workbook.createCellStyle();
//        XSSFFont font = workbook.createFont();
//        font.setFontHeight(10);
//        style.setFont(font);
//          
        
        for (Order order : listOrders) {
            Row row = sheet.createRow(rowCount++);

            
            
            Cell cell = row.createCell(1);
            cell.setCellValue(order.getId());

            cell = row.createCell(2);
            cell.setCellValue(order.getPhone());

            cell = row.createCell(3);
            cell.setCellValue(order.getNameuser());

            cell = row.createCell(4);
            cell.setCellValue(order.getNameproduct());

            cell = row.createCell(5);
            cell.setCellValue(order.getPriceproduct());

            cell = row.createCell(6);
            cell.setCellValue(order.getAmount());

            cell = row.createCell(7);
            cell.setCellValue(order.getTotal());
            
             cell = row.createCell(8);
            cell.setCellValue(order.getDay().toString());
            
              cell = row.createCell(9);
            cell.setCellValue(" ");
        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderRow();
        writeDataRows();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

}
