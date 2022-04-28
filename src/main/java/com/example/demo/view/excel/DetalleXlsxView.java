package com.example.demo.view.excel;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import org.springframework.web.servlet.view.document.AbstractXlsxView;

@Component("/guardias/registro.xlsx")
public class DetalleXlsxView extends AbstractXlsxView{

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
            
        response.setHeader("Content-Disposition", "attachment; filename=\"historico.xlsx\"");
        Sheet sheet = workbook.createSheet("Usuarios");
        
		Row filaTitulo =  sheet.createRow(0);
		Cell celda = filaTitulo.createCell(0);
        celda.setCellValue("Historico");

        CellStyle theaderStyle = workbook.createCellStyle();
        theaderStyle.setBorderBottom(BorderStyle.MEDIUM);
        theaderStyle.setBorderTop(BorderStyle.MEDIUM);
        theaderStyle.setBorderLeft(BorderStyle.MEDIUM);
        theaderStyle.setBorderRight(BorderStyle.MEDIUM);
        // theaderStyle.setFillBackgroundColor(IndexedColors.GOLD.index);
        // theaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Row filaContenido = sheet.createRow(2);
		String[] columnas ={"Empleado", "Puesto", "Fecha de inicio", "Fecha Pago", "Horas", "Importe"};
        for(int i=0; i<columnas.length; i++){
			celda = filaContenido.createCell(i);
			celda.setCellValue(columnas[i]);
            filaContenido.getCell(i).setCellStyle(theaderStyle);
            // filaContenido.setHeightInPoints( 20);
            sheet.autoSizeColumn(i);
            
		}
        
    }






}
