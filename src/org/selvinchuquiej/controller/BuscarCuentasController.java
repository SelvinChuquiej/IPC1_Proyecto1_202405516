/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.selvinchuquiej.controller;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.selvinchuquiej.model.Cliente;
import org.selvinchuquiej.model.Cuenta;

/**
 *
 * @author Selvi
 */
public class BuscarCuentasController {

    private RegistroClienteController registroClienteController;
    private BitacoraController bitacoraController;
    private DefaultTableModel dtm;

    public BuscarCuentasController(RegistroClienteController registroClienteController, BitacoraController bitacoraController) {
        this.registroClienteController = registroClienteController;
        this.bitacoraController = bitacoraController;
    }

    public void cargarUsuario(JTable tblClientes) {
        dtm = (DefaultTableModel) tblClientes.getModel();
        dtm.setRowCount(0);
        for (int i = 0; i < registroClienteController.clientes.size(); i++) {
            Cliente usuario = registroClienteController.clientes.get(i);
            Object[] datos = {
                usuario.getCUI(),
                usuario.getNombreUsuario(),
                usuario.getApellidoUsuario()
            };
            dtm.addRow(datos);
        }
    }

    public void buscarCuentas(JTable tblCuentasAsociadas, String CUI) {

        String accion = "Buscar Cuentas";
        String detallesFallidoCUI = "CUI (" + CUI + ") no existe en el sistema";

        dtm = (DefaultTableModel) tblCuentasAsociadas.getModel();
        dtm.setRowCount(0);
        for (int i = 0; i < registroClienteController.clientes.size(); i++) {
            Cliente usuario = registroClienteController.clientes.get(i);
            if (usuario.getCUI().equals(CUI.trim())) {
                int numCuentas = usuario.getCuentasAsociadas().size();

                String detallesExito = "Se encontraron (" + numCuentas + ") cuentas asociada a (" + usuario.getNombreUsuario() + ")";

                for (int j = 0; j < usuario.getCuentasAsociadas().size(); j++) {
                    Cuenta cuenta = usuario.getCuentasAsociadas().get(j);
                    Object[] datos = {
                        cuenta.getIdCuenta()
                    };
                    dtm.addRow(datos);
                }
                JOptionPane.showMessageDialog(null, detallesExito);
                bitacoraController.registrarEvento(accion, bitacoraController.exito, detallesExito);
                return;
            } else {
                JOptionPane.showMessageDialog(null, detallesFallidoCUI);
                bitacoraController.registrarEvento(accion, bitacoraController.error, detallesFallidoCUI);
            }
        }
    }
}
