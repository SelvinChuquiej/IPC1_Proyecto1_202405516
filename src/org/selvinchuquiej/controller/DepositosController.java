/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.selvinchuquiej.controller;

import javax.swing.JComboBox;
import org.selvinchuquiej.model.Cuenta;

/**
 *
 * @author Selvi
 */
public class DepositosController {

    private CrearCuentaController crearCuentaController;

    public DepositosController(CrearCuentaController crearCuentaController) {
        this.crearCuentaController = crearCuentaController;
    }

    public void cargarCuenta(JComboBox<Cuenta> cmbCuentas) {
        cmbCuentas.removeAllItems();
        for (int i = 0; i < crearCuentaController.cuentas.size(); i++) {
            Cuenta cuenta = crearCuentaController.cuentas.get(i);
            cmbCuentas.addItem(cuenta);
        }
    }
}
