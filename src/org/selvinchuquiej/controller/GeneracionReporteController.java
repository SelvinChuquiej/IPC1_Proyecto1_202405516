/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.selvinchuquiej.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.selvinchuquiej.model.Cuenta;
import org.selvinchuquiej.model.Transaccion;

/**
 *
 * @author Selvi
 */
public class GeneracionReporteController {

    private CrearCuentaController crearCuentaController;
    private BitacoraController bitacoraController;

    public GeneracionReporteController(CrearCuentaController crearCuentaController, BitacoraController bitacoraController) {
        this.crearCuentaController = crearCuentaController;
        this.bitacoraController = bitacoraController;
    }

    public List<Transaccion> obtenerTransacciones(String CUI) {
        String accion = "Generar Reporte";
        List<Transaccion> transaccionesEncontradas = new ArrayList<>();
        boolean transEncontradas = false;

        for (int i = 0; i < crearCuentaController.cuentas.size(); i++) {
            Cuenta cuentaT = crearCuentaController.cuentas.get(i);

            if (cuentaT.getUsuario().getCUI().equals(CUI)) {
                Collections.reverse(cuentaT.getTransacciones());
                transaccionesEncontradas.addAll(cuentaT.getTransacciones());
                transEncontradas = true;

                String detalleExito = "Se genero el reporte para la cuenta '" + cuentaT.getIdCuenta() + "'";
                bitacoraController.registrarEvento(accion, bitacoraController.exito, detalleExito);
                break;
            }
        }
        if (!transEncontradas) {
            String detalleError = "No se encontraron transacciones para el CUI '" + CUI + "'";
            bitacoraController.registrarEvento(accion, bitacoraController.error, detalleError);
        }
        return transaccionesEncontradas;

    }

    public List<Transaccion> obtenerDepositos(String CUI) {
        String accion = "Generar Reporte";
        List<Transaccion> depositosEncontradas = new ArrayList<>();
        boolean transEncontradas = false;

        for (int i = 0; i < crearCuentaController.cuentas.size(); i++) {
            Cuenta cuentaT = crearCuentaController.cuentas.get(i);
            if (cuentaT.getUsuario().getCUI().equals(CUI)) {
                for (int j = 0; j < cuentaT.getTransacciones().size(); j++) {
                    Transaccion transaccionDep = cuentaT.getTransacciones().get(j);
                    if (transaccionDep.getMontoDebitado() == 0) {
                        depositosEncontradas.add(transaccionDep);
                        transEncontradas = true;

                        String detalleExito = "Se genero el reporte de depositos para la cuenta '" + cuentaT.getIdCuenta() + "'";
                        bitacoraController.registrarEvento(accion, bitacoraController.exito, detalleExito);
                    }
                }
                Collections.reverse(depositosEncontradas);
                break;
            }
        }
        if (!transEncontradas) {
            String detalleError = "No se encontraron depositos para el CUI '" + CUI + "'";
            bitacoraController.registrarEvento(accion, bitacoraController.error, detalleError);
        }
        return depositosEncontradas;
    }

    public List<Transaccion> obtenerRetiros(String CUI) {
        String accion = "Generar Reporte";
        List<Transaccion> retirosEncontradas = new ArrayList<>();
        boolean transEncontradas = false;

        for (int i = 0; i < crearCuentaController.cuentas.size(); i++) {
            Cuenta cuentaT = crearCuentaController.cuentas.get(i);
            if (cuentaT.getUsuario().getCUI().equals(CUI)) {
                for (int j = 0; j < cuentaT.getTransacciones().size(); j++) {
                    Transaccion transaccionDep = cuentaT.getTransacciones().get(j);
                    if (transaccionDep.getMontoAcreditado() == 0) {
                        retirosEncontradas.add(transaccionDep);
                        transEncontradas = true;

                        String detalleExito = "Se genero el reporte de retiros para la cuenta '" + cuentaT.getIdCuenta() + "'";
                        bitacoraController.registrarEvento(accion, bitacoraController.exito, detalleExito);

                    }
                }
                Collections.reverse(retirosEncontradas);
                break;
            }
        }
        if (!transEncontradas) {
            String detalleError = "No se encontraron retiros para el CUI '" + CUI + "'";
            bitacoraController.registrarEvento(accion, bitacoraController.error, detalleError);
        }
        return retirosEncontradas;
    }
}
