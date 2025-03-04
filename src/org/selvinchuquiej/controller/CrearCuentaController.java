/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.selvinchuquiej.controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.selvinchuquiej.model.Cuenta;

/**
 *
 * @author Selvi
 */
public class CrearCuentaController {

    private ArrayList<Cuenta> cuentas = new ArrayList<>();

    public void agregarCuenta(Cuenta cuenta) {

        if (cuentas.size() >= 3) {
            JOptionPane.showMessageDialog(null, "No se puede tener mas de 3 cuentas");
        }
        
        cuentas.add(cuenta);
    }
}
