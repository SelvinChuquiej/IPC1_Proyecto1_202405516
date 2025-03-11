/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.selvinchuquiej.controller;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.selvinchuquiej.model.Cuenta;
import org.selvinchuquiej.model.Transaccion;
import org.selvinchuquiej.pdf.HistorialTransaccionesPDF;
import org.selvinchuquiej.system.Principal;

/**
 *
 * @author Selvi
 */
public class HistorialTransaccionesController {

    private RegistroClienteController registroClienteController;
    private CrearCuentaController crearCuentaController;
    private DepositosController depositosController;
    private Cuenta cuenta;
    private DefaultTableModel dtm;

    public HistorialTransaccionesController(CrearCuentaController crearCuentaController) {
        this.crearCuentaController = crearCuentaController;
    }

    public void cargarTransacciones(JTable tblTransacciones, String idCuenta) {
        dtm = (DefaultTableModel) tblTransacciones.getModel();
        dtm.setRowCount(0);
        for (int i = 0; i < crearCuentaController.cuentas.size(); i++) {
            Cuenta cuentaT = crearCuentaController.cuentas.get(i);
            if (cuentaT.getIdCuenta().equals(idCuenta)) {
                for (int j = 0; j < cuentaT.getTransacciones().size(); j++) {
                    Transaccion transaccion = cuentaT.getTransacciones().get(j);
                    Object[] datos = {
                        transaccion.getIdTransaccion(),
                        transaccion.getFechaHora(),
                        transaccion.getDetalle(),
                        transaccion.getMontoDebitado(),
                        transaccion.getMontoAcreditado(),
                        transaccion.getSaldoDisponible()
                    };
                    dtm.addRow(datos);
                }
                return;
            }
        }

    }

    public Cuenta obtenerCuenta(String id) {
        for (int i = 0; i < crearCuentaController.cuentas.size(); i++) {
            Cuenta cuenta = crearCuentaController.cuentas.get(i);
            if (cuenta.getIdCuenta().equals(id)) {
                return cuenta;
            }
        }
        return null;
    }

    public void crearPDFHistoraial(String cui, List<Transaccion> transacciones) throws FileNotFoundException {
        HistorialTransaccionesPDF pdfGenerator = new HistorialTransaccionesPDF();
        pdfGenerator.generarPDF(cui, transacciones);
    }

}
