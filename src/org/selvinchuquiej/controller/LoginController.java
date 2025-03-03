/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.selvinchuquiej.controller;

/**
 *
 * @author Selvi
 */

public class LoginController {

    public boolean auntenticar(String usuario, String contrasena) {
        String usuarioAdmin = "admin";
        String contrasenaAdmin = "admin";
        if (usuario.equals(usuarioAdmin) && contrasena.equals(contrasenaAdmin)) {
            return true;
        }
        return false;
    }
}
