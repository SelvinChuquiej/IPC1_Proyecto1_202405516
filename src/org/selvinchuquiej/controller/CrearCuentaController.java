/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.selvinchuquiej.controller;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.selvinchuquiej.model.Cuenta;
import org.selvinchuquiej.model.Cliente;

/**
 *
 * @author Selvi
 */
public class CrearCuentaController {

    private RegistroClienteController registroClienteController;
    private DefaultTableModel dtm;

    public ArrayList<Cuenta> cuentas = new ArrayList<>();

    public CrearCuentaController(RegistroClienteController registroClienteController) {
        this.registroClienteController = registroClienteController;
    }

    public void agregarCuenta(Cuenta cuenta) {
        Cliente usuario = cuenta.getUsuario();
        int cont = 0;

        for (int i = 0; i < cuentas.size(); i++) {
            if (cuentas.get(i).getUsuario().equals(usuario)) {
                cont++;
            }
        }
        if (cont >= 3) {
            JOptionPane.showMessageDialog(null, "No se puede tener mas de 3 cuentas");
            return;
        }

        Cuenta.contadorId++;

        cuentas.add(cuenta);
        usuario.agregarCuenta(cuenta);
        
        JOptionPane.showMessageDialog(null, "Cuenta creada correctamente para: " + usuario.getNombreUsuario());
    }

    public void cargarClientes(JComboBox<Cliente> cmbUsuarios) {
        cmbUsuarios.removeAllItems();
        for (int i = 0; i < registroClienteController.clientes.size(); i++) {
            Cliente cliente = registroClienteController.clientes.get(i);
            cmbUsuarios.addItem(cliente);
        }
    }

    public void cargarCuenta(JComboBox<Cuenta> cmbCuentas) {
        cmbCuentas.removeAllItems();
        for (int i = 0; i < cuentas.size(); i++) {
            Cuenta cuenta = cuentas.get(i);
            cmbCuentas.addItem(cuenta);
        }
    }

}
