/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.selvinchuquiej.controller;

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
    private DefaultTableModel dtm;

    public BuscarCuentasController(RegistroClienteController registroClienteController) {
        this.registroClienteController = registroClienteController;
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

    public void buscarCuentas(JTable tblCuentasAsociadas, int CUI) {
        dtm = (DefaultTableModel) tblCuentasAsociadas.getModel();
        dtm.setRowCount(0);
        for (int i = 0; i < registroClienteController.clientes.size(); i++) {
            Cliente usuario = registroClienteController.clientes.get(i);
            if (usuario.getCUI() == CUI) {
                for (int j = 0; j < usuario.getCuentasAsociadas().size(); j++) {
                    Cuenta cuenta = usuario.getCuentasAsociadas().get(j);
                    Object[] datos = {
                        cuenta.getIdCuenta()
                    };
                    dtm.addRow(datos);
                }
                return;
            }
        }
    }
}
