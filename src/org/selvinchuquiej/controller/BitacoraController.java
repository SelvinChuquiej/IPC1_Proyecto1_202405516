/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.selvinchuquiej.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.selvinchuquiej.model.Cliente;
import org.selvinchuquiej.model.Login;

/**
 *
 * @author Selvi
 */
public class BitacoraController {

    private Login login;

    public ArrayList<String> bitacora = new ArrayList<>();
    public String exito = "Exito";
    public String error = "Error";

    public BitacoraController(Login login) {
        this.login = login;
    }

    public void registrarEvento(String accion, String resultado, String detalles) {
        String marcaTemporal = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String mensaje = String.format("[%s] Usuario: %s - Accion: %s - Resultado: %s - Detalles: %s", marcaTemporal, login.getUsuario(), accion, resultado, detalles);
        bitacora.add(mensaje);
    }

    public void mostrarRegistro() {
        for (int i = 0; i < bitacora.size(); i++) {
            System.out.println(bitacora.get(i));
        }
    }
}
