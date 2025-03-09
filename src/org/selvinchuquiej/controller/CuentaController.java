/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.selvinchuquiej.controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.selvinchuquiej.model.Cuenta;
import org.selvinchuquiej.model.Usuario;

/**
 *
 * @author Selvi
 */
public class CuentaController {

    private UsuarioController usuarioController;
    private ArrayList<Cuenta> cuentas = new ArrayList<>();
    private DefaultTableModel dtm;

    public CuentaController(UsuarioController usuarioController) {
        this.usuarioController = usuarioController;
    }

    public void agregarCuenta(Cuenta cuenta) {
        Usuario usuario = cuenta.getUsuario();
        int cont = 0;

        for (int i = 0; i < cuentas.size(); i++) {
            if (cuentas.get(i).getUsuario().equals(usuario)) {
                cont++;
            }
        }
        if (cont++ >= 3) {
            JOptionPane.showMessageDialog(null, "No se puede tener mas de 3 cuentas");
            return;
        }
        cuentas.add(cuenta);
        usuario.agregarCuenta(cuenta);
    }

    public void cargarUsuario(JTable tblClientes) {
        dtm = (DefaultTableModel) tblClientes.getModel();
        dtm.setRowCount(0);
        for (int i = 0; i < usuarioController.usuarios.size(); i++) {
            Usuario usuario = usuarioController.usuarios.get(i);
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
        for (int i = 0; i < usuarioController.usuarios.size(); i++) {
            Usuario usuario = usuarioController.usuarios.get(i);
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
