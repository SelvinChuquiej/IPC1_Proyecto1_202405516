/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.selvinchuquiej.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.html.ParaGraph;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.selvinchuquiej.model.Transaccion;
import org.selvinchuquiej.system.Principal;

/**
 *
 * @author Selvi
 */
public class HistorialTransaccionesPDF {

    public void generarPDF(String cui, List<Transaccion> transacciones) throws FileNotFoundException {
        Document document = new Document();
        try {
            String timeStamp = new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date());
            String fileName = "reporteTransacciones_" + timeStamp + ".pdf";
            PdfWriter.getInstance(document, new FileOutputStream(fileName));

            document.open();
            document.add(new Paragraph("Reporte de Historial de Transacciones"));
            document.add(new Paragraph("CUI del Usuario: " + cui));

            PdfPTable table = new PdfPTable(4); // 4 columnas
            table.addCell("Tipo");
            table.addCell("Monto");
            table.addCell("Fecha");
            table.addCell("Descripción");

            for (Transaccion transaccion : transacciones) {
                table.addCell(transaccion.getIdTransaccion());
                table.addCell(String.valueOf(transaccion.getFechaHora()));
                table.addCell(transaccion.getDetalle());
                table.addCell(String.format("%.2f", transaccion.getMontoDebitado()));
                table.addCell(String.format("%.2f", transaccion.getMontoAcreditado()));
                table.addCell(String.format("%.2f", transaccion.getSaldoDisponible()));
            }

            document.add(table);
            document.close();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }

    }
}
