package com.example.demo.view.pdf;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.model.IDatosBolsaTrabajo;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

@Component("/guardias/bolsaTrabajo")
public class BolsaTrabajoExtPdfView extends AbstractPdfView {

        @Override
        protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
                        HttpServletRequest request, HttpServletResponse response) throws Exception {

                Image imagen = Image.getInstance("C:\\Users\\Administrador\\Documents\\workspace-spring\\gys-001\\src\\main\\resources\\static\\img\\issste.jpg");
                // Image imagen = Image.getInstance("./static/img/issste.jpg");
                imagen.scaleAbsolute(100, 60);

                // Image imagen2 = Image.getInstance("C:\\Users\\Administrador\\Documents\\workspace-spring\\gys-001\\src\\main\\resources\\static\\img\\issste.jpg");
                // imagen2.setAbsolutePosition(450, 747);
                // imagen2.scaleAbsolute(100, 60);
                document.setPageSize(PageSize.LETTER.rotate());
                document.open();

                PdfPTable titulo = new PdfPTable(1);
                PdfPCell celda = null;
                celda = new PdfPCell(new Phrase("Registro de bolsa de trabajo externo ISSSTE"));
                celda.setBorder(0);
                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda.setVerticalAlignment(Element.ALIGN_CENTER);
                titulo.addCell(celda);
                titulo.setSpacingAfter(20);

                //Campos de la tabla(titulos)

                PdfPTable campos = new PdfPTable(6);
                // PdfPCell celdaCampos = null;

                String[] col = { "RFC", "Nombre(s)", "Apellido Paterno", "Apellido Materno", "División geográfica",
                "Centro de trabajo" };

                for(int asig = 0; asig<col.length; asig++){
                        campos.addCell(col[asig]);
                }

                PdfPTable tabla = new PdfPTable(6);

                List<IDatosBolsaTrabajo> bolsaTrabajoExt = (List<IDatosBolsaTrabajo>) model.get("reg");

                bolsaTrabajoExt.forEach(bolsaTrabajo -> {
                        tabla.addCell(bolsaTrabajo.getRfc());
                        tabla.addCell(bolsaTrabajo.getNombre());
                        tabla.addCell(bolsaTrabajo.getApellidoPat());
                        tabla.addCell(bolsaTrabajo.getApellidoMat());
                        tabla.addCell(bolsaTrabajo.getN_Div_Geografica());
                        tabla.addCell(bolsaTrabajo.getN_Centro_Trabajo());
                });

                document.addTitle("Bolsa de trabajo externo");
                document.add(imagen);
                document.add(titulo);
                document.add(campos);
                document.add(tabla);

        }
}
