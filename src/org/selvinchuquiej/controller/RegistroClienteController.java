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
import org.selvinchuquiej.system.Principal;

/**
 *
 * @author Selvi
 */
public class RegistroClienteController { 
    
    public ArrayList<Cliente> clientes = new ArrayList<>();
    
    public void agregarUsuario(Cliente usuario) {
        if (cuiDuplicados(usuario.getCUI())) {
            JOptionPane.showMessageDialog(null, "Este CUI ya se encuentra en uso");
            return;
        }
        if (clientes.size() >= 6) {
            JOptionPane.showMessageDialog(null, "No se pueden agregar mas de 6 usuario");
            return;
        }
        clientes.add(usuario);
        JOptionPane.showMessageDialog(null, "Usuario creado correctamente");
        System.out.println(clientes);
    }
    
    public boolean cuiDuplicados(int cui) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCUI() == cui) {
                return true;
            }
        }
        return false;
    }
    
}
