/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.selvinchuquiej.controller;

import org.selvinchuquiej.model.Login;

/**
 *
 * @author Selvi
 */
public class LoginController {

    private Login login;
    private BitacoraController bitacoraController;

    public LoginController(BitacoraController bitacoraController, Login login) {
        this.bitacoraController = bitacoraController;
        this.login = login;
    }

    public boolean auntenticar(String usuario, String contrasena) {
        if (usuario.equals(login.getUsuario().trim()) && contrasena.equals(login.getPassword().trim())) {
            bitacoraController.registrarEvento("Inicio de sesion", bitacoraController.exito, "Inicio Correctamente");
            return true;
        }
        bitacoraController.registrarEvento("Inicio de sesion", bitacoraController.error, "Credenciales incorrectas");
        return false;
    }
}
