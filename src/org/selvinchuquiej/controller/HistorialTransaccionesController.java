/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.selvinchuquiej.controller;

import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.selvinchuquiej.model.Cuenta;
import org.selvinchuquiej.model.Transaccion;

/**
 *
 * @author Selvi
 */
public class HistorialTransaccionesController {

    private CrearCuentaController crearCuentaController;
    private BitacoraController bitacoraController;
    private DefaultTableModel dtm;

    public HistorialTransaccionesController(CrearCuentaController crearCuentaController, BitacoraController bitacoraController) {
        this.crearCuentaController = crearCuentaController;
        this.bitacoraController = bitacoraController;
    }

    public void cargarTransacciones(JTable tblTransacciones, String idCuenta) {

        String accion = "Historial Transacciones";
        String detalleExito = "Transacciones cargadas correctamente para la cuenta '" + idCuenta + "'";

        dtm = (DefaultTableModel) tblTransacciones.getModel();
        dtm.setRowCount(0);
        for (int i = 0; i < crearCuentaController.cuentas.size(); i++) {
            Cuenta cuentaT = crearCuentaController.cuentas.get(i);
            if (cuentaT.getIdCuenta().equals(idCuenta)) {
                Collections.reverse(cuentaT.getTransacciones());
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
                JOptionPane.showMessageDialog(null, "Transacciones cargadas correctamente");
                bitacoraController.registrarEvento(accion, bitacoraController.exito, detalleExito);
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

}
