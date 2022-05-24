package com.example.demo.view.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.model.IDatosBolsaTrabajo;
import com.example.demo.service.IBolsaTrabajoGuardiasService;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
//import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.web.servlet.view.document.AbstractXlsxView;

@Component("/guardias/bolsaTrabajo.xlsx")
public class BolsaTrabajoExtXlsxView extends AbstractXlsxView {

    @Autowired
    IBolsaTrabajoGuardiasService servicioBolsaTrabGuardias;

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        response.setHeader("Content-Disposition", "attachment; filename=\"Bolsa de trabajo externo.xlsx\"");
        Sheet sheet = workbook.createSheet("Bolsa de trabajo externo");

        Row filaTitulo = sheet.createRow(0);
        Cell celda = filaTitulo.createCell(3);
        celda.setCellValue("Bolsa de trabajo externo");

        CellStyle theaderStyle = workbook.createCellStyle();
        theaderStyle.setBorderBottom(BorderStyle.MEDIUM);
        theaderStyle.setBorderTop(BorderStyle.MEDIUM);
        theaderStyle.setBorderLeft(BorderStyle.MEDIUM);
        theaderStyle.setBorderRight(BorderStyle.MEDIUM);
        theaderStyle.setAlignment(HorizontalAlignment.CENTER);
        // theaderStyle.setFillForegroundColor(IndexedColors.GOLD.index);
        // theaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        CellStyle tbodyStyle = workbook.createCellStyle();
        tbodyStyle.setBorderBottom(BorderStyle.THIN);
        tbodyStyle.setBorderTop(BorderStyle.THIN);
        tbodyStyle.setBorderLeft(BorderStyle.THIN);
        tbodyStyle.setBorderRight(BorderStyle.THIN);

        Row filaContenido = sheet.createRow(2);
        String[] columnas = { "RFC", "Nombre(s)", "Apellido Paterno", "Apellido Materno", "División geográfica",
                "Centro de trabajo" };
        for (int i = 0; i < columnas.length; i++) {
            celda = filaContenido.createCell(i);
            celda.setCellValue(columnas[i]);
            filaContenido.getCell(i).setCellStyle(theaderStyle);
            // filaContenido.setHeightInPoints( 20);
            // sheet.autoSizeColumn(i);
        }

        List<IDatosBolsaTrabajo> bolsaTrabajoExt = (List<IDatosBolsaTrabajo>) model.get("reg");

        int numFila = 3;

        int[] numCol = {0,1,2,3,4};
        int[] tam = {4000,4000,6000,6000,11000};

        for(int asig=0; asig<numCol.length; asig++){
            sheet.setColumnWidth(numCol[asig], tam[asig]);
        }

        for (IDatosBolsaTrabajo bolsaTrabajo : bolsaTrabajoExt) {
            filaContenido = sheet.createRow(numFila);
            filaContenido.createCell(0).setCellValue(bolsaTrabajo.getRfc());
            filaContenido.createCell(1).setCellValue(bolsaTrabajo.getNombre());
            filaContenido.createCell(2).setCellValue(bolsaTrabajo.getApellidoPat());
            filaContenido.createCell(3).setCellValue(bolsaTrabajo.getApellidoMat());
            filaContenido.createCell(4).setCellValue(bolsaTrabajo.getN_Div_Geografica());
            filaContenido.createCell(5).setCellValue(bolsaTrabajo.getN_Centro_Trabajo());

            sheet.autoSizeColumn(numFila);
            numFila++;
        }
    }

}
