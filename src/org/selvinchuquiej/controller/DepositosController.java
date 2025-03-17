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
public class DepositosController {

    private BitacoraController bitacoraController;

    public ArrayList<Transaccion> depositos = new ArrayList<>();

    public DepositosController(CrearCuentaController crearCuentaController, BitacoraController bitacoraController) {
        this.bitacoraController = bitacoraController;
    }

    public Cuenta cuentaAcutal(JComboBox<Cuenta> cmbCuentas) {
        return (Cuenta) cmbCuentas.getSelectedItem();
    }

    public void crearDeposito(Transaccion transaccionDe) {
        Cuenta cuenta = transaccionDe.getIdCuenta();

        String accionDe = "Deposito";
        String detalleFallidoCantidad = "No se puede hacer mas de 25 Transacciones para '" + cuenta.getIdCuenta() + "'";
        String detalleExito = "Se deposito Q." + transaccionDe.getMontoAcreditado() + " a la cuenta '" + cuenta.getIdCuenta() + "'";

        if (cuenta == null) {
            JOptionPane.showMessageDialog(null, "No se encontro ninguna cuenta");
            return;
        }

        if (cuenta.getTransacciones().size() > 25) {
            JOptionPane.showMessageDialog(null, "No se pueden hacer mas de 25 Transacciones");
            bitacoraController.registrarEvento(accionDe, bitacoraController.error, detalleFallidoCantidad);
            return;
        }

        double nuevoSaldo = cuenta.getSaldo() + transaccionDe.getMontoAcreditado();
        cuenta.setSaldo(nuevoSaldo);
        transaccionDe.setSaldoDisponible(nuevoSaldo);
        cuenta.getTransacciones().add(transaccionDe);
        depositos.add(transaccionDe);

        JOptionPane.showMessageDialog(null, "Deposito realizado correctamente..");
        bitacoraController.registrarEvento(accionDe, bitacoraController.exito, detalleExito);
    }
}
