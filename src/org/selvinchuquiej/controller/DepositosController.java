/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.selvinchuquiej.controller;

import java.util.ArrayList;
import javax.swing.JComboBox;
import org.selvinchuquiej.model.Cuenta;
import org.selvinchuquiej.model.Transaccion;

/**
 *
 * @author Selvi
 */
public class DepositosController {

    private CrearCuentaController crearCuentaController;

    public ArrayList<Transaccion> depositos = new ArrayList<>();

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

    public Cuenta cuentaAcutal(JComboBox<Cuenta> cmbCuentas) {
        return (Cuenta) cmbCuentas.getSelectedItem();
    }

    public void crearDeposito(Transaccion transaccion) {
        Cuenta cuenta = transaccion.getIdCuenta();
        double nuevoSaldo = cuenta.getSaldo() + transaccion.getMontoAcreditado();
        cuenta.setSaldo(nuevoSaldo);
        transaccion.setSaldoDisponible(nuevoSaldo);
        cuenta.getTransacciones().add(transaccion);
        
        depositos.add(transaccion);
    }
}
