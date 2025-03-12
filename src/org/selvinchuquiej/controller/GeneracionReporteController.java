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

    public GeneracionReporteController(CrearCuentaController crearCuentaController) {
        this.crearCuentaController = crearCuentaController;
    }

    public List<Transaccion> obtenerTransacciones(String CUI) {
        List<Transaccion> transaccionesEncontradas = new ArrayList<>();

        for (int i = 0; i < crearCuentaController.cuentas.size(); i++) {
            Cuenta cuentaT = crearCuentaController.cuentas.get(i);
            if (cuentaT.getUsuario().getCUI() == Integer.parseInt(CUI)) {
                Collections.reverse(cuentaT.getTransacciones());
                transaccionesEncontradas.addAll(cuentaT.getTransacciones());
                break;
            }
        }
        return transaccionesEncontradas;
    }

    public List<Transaccion> obtenerDepositos(String CUI) {
        List<Transaccion> depositosEncontradas = new ArrayList<>();

        for (int i = 0; i < crearCuentaController.cuentas.size(); i++) {
            Cuenta cuentaT = crearCuentaController.cuentas.get(i);
            if (cuentaT.getUsuario().getCUI() == Integer.parseInt(CUI)) {
                for (int j = 0; j < cuentaT.getTransacciones().size(); j++) {
                    Transaccion transaccionDep = cuentaT.getTransacciones().get(j);
                    if (transaccionDep.getMontoDebitado() == 0) {
                        depositosEncontradas.add(transaccionDep);
                    }
                }
                Collections.reverse(depositosEncontradas);
                break;
            }
        }
        return depositosEncontradas;
    }

    public List<Transaccion> obtenerRetiros(String CUI) {
        List<Transaccion> retirosEncontradas = new ArrayList<>();

        for (int i = 0; i < crearCuentaController.cuentas.size(); i++) {
            Cuenta cuentaT = crearCuentaController.cuentas.get(i);
            if (cuentaT.getUsuario().getCUI() == Integer.parseInt(CUI)) {
                for (int j = 0; j < cuentaT.getTransacciones().size(); j++) {
                    Transaccion transaccionDep = cuentaT.getTransacciones().get(j);
                    if (transaccionDep.getMontoAcreditado()== 0) {
                        retirosEncontradas.add(transaccionDep);
                    }
                }
                Collections.reverse(retirosEncontradas);
                break;
            }
        }
        return retirosEncontradas;
    }
}
