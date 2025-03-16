/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.selvinchuquiej.controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import org.selvinchuquiej.model.Cliente;
import org.selvinchuquiej.model.Login;
import org.selvinchuquiej.system.Principal;

/**
 *
 * @author Selvi
 */
public class RegistroClienteController {

    private BitacoraController bitacoraController;
    private Login login;
    public ArrayList<Cliente> clientes = new ArrayList<>();

    public RegistroClienteController(BitacoraController bitacoraController) {
        this.bitacoraController = bitacoraController;
    }

    public void agregarUsuario(Cliente cliente) {

        String accion = "Registro Usuario";
        String detallesExito = "Usuario (" + cliente.getNombreUsuario() + ") registrado";
        String detallesFallidoCUI = "CUI duplicado (" + cliente.getCUI() + ")";
        String detallesFallidoLimite = "Límite de usuarios alcanzado (máximo 6 usuarios)";

        if (cuiDuplicados(cliente.getCUI().trim())) {
            JOptionPane.showMessageDialog(null, detallesFallidoCUI);
            bitacoraController.registrarEvento(accion, bitacoraController.error, detallesFallidoCUI);
            return;
        }

        if (clientes.size() >= 6) {
            JOptionPane.showMessageDialog(null, detallesFallidoLimite);
            bitacoraController.registrarEvento(accion, bitacoraController.error, detallesFallidoLimite);
            return;
        }

        clientes.add(cliente);
        JOptionPane.showMessageDialog(null, detallesExito);
        bitacoraController.registrarEvento(accion, bitacoraController.exito, detallesExito);
    }

    public boolean cuiDuplicados(String cui) {
        for (int i = 0; i < clientes.size(); i++) {

            if (clientes.get(i).getCUI().equals(cui.trim())) {
                return true;
            }
        }
        return false;
    }
}
