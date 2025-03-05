/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.selvinchuquiej.controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.selvinchuquiej.model.Usuario;
import org.selvinchuquiej.system.Principal;

/**
 *
 * @author Selvi
 */
public class UsuarioController {

    public ArrayList<Usuario> usuarios = new ArrayList<>();

    public void agregarUsuario(Usuario usuario) {
        if (cuiDuplicados(usuario.getCUI())) {
            JOptionPane.showMessageDialog(null, "Este CUI ya se encuentra en uso");
            return;
        }
        if (usuarios.size() >= 6) {
            JOptionPane.showMessageDialog(null, "No se pueden agregar mas de 6 usuario");
            return;
        }
        usuarios.add(usuario);
        JOptionPane.showMessageDialog(null, "Usuario creado correctamente");
        System.out.println(usuarios);
    }

    public boolean cuiDuplicados(int cui) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCUI() == cui) {
                return true;
            }
        }
        return false;
    }

    public void imprimirUsuarios() {
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usuario = usuarios.get(i);
            System.out.println(usuario.getCUI() + " " + usuario.getNombreUsuario());
        }
    }

}
