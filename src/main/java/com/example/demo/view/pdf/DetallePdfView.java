package com.example.demo.view.pdf;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Image;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

@Component("/guardias/registro")
public class DetallePdfView  extends AbstractPdfView{

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        

                PdfPTable tabla = new PdfPTable(1);
                tabla.setSpacingAfter(20);
                PdfPCell cell = null;

                Image imagen = Image.getInstance("C:\\Users\\Administrador\\Documents\\workspace-spring\\gys-001\\src\\main\\resources\\static\\img\\issste.jpg");
                imagen.scaleAbsolute(100, 60);
               
                Image imagen2 = Image.getInstance("C:\\Users\\Administrador\\Documents\\workspace-spring\\gys-001\\src\\main\\resources\\static\\img\\issste.jpg");
                imagen2.setAbsolutePosition(450, 747);
                imagen2.scaleAbsolute(100, 60);

                document.add(imagen);
                document.add(imagen2);


                cell = new PdfPCell(new Phrase("Vista de la tabla"));
                cell.setBorderWidth(0);
                // cell = new PdfPCell(Image.getInstance("img/issste.jpg"));
                // cell.setBackgroundColor(new Color(184,218,255));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setPadding(8f);
                tabla.addCell(cell);

                document.addTitle("Historico");
                document.add(tabla);
		        // document.add(tabla2);
        
    }

}
