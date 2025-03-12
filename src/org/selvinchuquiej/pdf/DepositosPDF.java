/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.selvinchuquiej.pdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.selvinchuquiej.model.Transaccion;

/**
 *
 * @author Selvi
 */
public class DepositosPDF {

    Paragraph titulo;

    public void generarPDF(String cui, List<Transaccion> transacciones) throws FileNotFoundException {
        Document document = new Document();
        titulo = new Paragraph("Reporte de historial de Depositos");
        
        try {
            String timeStamp = new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date());
            String fileName = "reporteTransacciones_" + timeStamp + ".pdf";
            PdfWriter.getInstance(document, new FileOutputStream(fileName));

            document.open();
            
            titulo.setAlignment(1);
            document.add(titulo);
            document.add(new Paragraph("CUI del Usuario: " + cui));
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);

            table.addCell("ID Transaccion");
            table.addCell("Fecha / Hora");
            table.addCell("Detalle");
            table.addCell("Monto Acreditado");
            table.addCell("Saldo Disponible");

            for (Transaccion deposito : transacciones) {
                table.addCell(deposito.getIdTransaccion());
                table.addCell(String.valueOf(deposito.getFechaHora()));
                table.addCell(deposito.getDetalle());
                table.addCell(String.format("%.2f", deposito.getMontoAcreditado()));
                table.addCell(String.format("%.2f", deposito.getSaldoDisponible()));
            }

            document.add(table);
            document.close();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }
}
