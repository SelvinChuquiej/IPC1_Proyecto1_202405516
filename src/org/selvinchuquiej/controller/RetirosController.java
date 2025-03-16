/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.selvinchuquiej.controller;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import org.selvinchuquiej.model.Cuenta;
import org.selvinchuquiej.model.Transaccion;

/**
 *
 * @author Selvi
 */
public class RetirosController {

    private CrearCuentaController crearCuentaController;
    private BitacoraController bitacoraController;

    public ArrayList<Transaccion> retiros = new ArrayList<>();

    public RetirosController(CrearCuentaController crearCuentaController, BitacoraController bitacoraController) {
        this.crearCuentaController = crearCuentaController;
        this.bitacoraController = bitacoraController;
    }


    public Cuenta cuentaActual(JComboBox<Cuenta> cmbCuentasRe) {
        return (Cuenta) cmbCuentasRe.getSelectedItem();
    }

    public void crearRetiro(Transaccion transaccionRe) {
        Cuenta cuenta = transaccionRe.getIdCuenta();

        String accionRe = "Retiro";
        String detalleFallidoCantidad = "No se puede hacer mas de 25 Transacciones para '" + cuenta.getIdCuenta() + "'";
        String detalleExito = "Se retiro Q." + transaccionRe.getMontoDebitado() + " a la cuenta '" + cuenta.getIdCuenta() + "'";

        if (cuenta == null) {
            JOptionPane.showMessageDialog(null, "No se encontro ninguna cuenta");
            return;
        }

        if (cuenta.getTransacciones().size() > 25) {
            JOptionPane.showMessageDialog(null, detalleFallidoCantidad);
            bitacoraController.registrarEvento(accionRe, bitacoraController.error, detalleFallidoCantidad);
            return;
        }

        double nuevoSaldo = cuenta.getSaldo() - transaccionRe.getMontoDebitado();
        if (nuevoSaldo < 0) {
            String mensajeError = "Saldo insuficiente en la cuenta '" + cuenta.getIdCuenta() + "'";
            JOptionPane.showMessageDialog(null, "Saldo insuficiente para realizar el retiro.");
            bitacoraController.registrarEvento(accionRe, bitacoraController.error, mensajeError);
            return;
        }
        cuenta.setSaldo(nuevoSaldo);
        transaccionRe.setSaldoDisponible(nuevoSaldo);
        cuenta.getTransacciones().add(transaccionRe);
        retiros.add(transaccionRe);

        bitacoraController.registrarEvento(accionRe, bitacoraController.exito, detalleExito);
    }

}
