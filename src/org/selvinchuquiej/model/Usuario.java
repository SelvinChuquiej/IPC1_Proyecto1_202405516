/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.selvinchuquiej.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Selvi
 */
public class Usuario {

    private int CUI;
    private String nombreUsuario;
    private String apellidoUsuario;
    private List<Cuenta> cuentasAsociadas = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(int CUI, String nombreUsuario, String apellidoUsuario) {
        this.CUI = CUI;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.cuentasAsociadas = new ArrayList<>();
    }

    public void agregarCuenta(Cuenta cuenta) {
        if (cuenta != null) {
            cuentasAsociadas.add(cuenta);
        }
    }

    public int getCUI() {
        return CUI;
    }

    public void setCUI(int CUI) {
        this.CUI = CUI;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public List<Cuenta> getCuentasAsociadas() {
        return cuentasAsociadas;
    }

    public void setCuentasAsociadas(List<Cuenta> cuentasAsociadas) {
        this.cuentasAsociadas = cuentasAsociadas;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    @Override
    public String toString() {
        return CUI + " - " + nombreUsuario + " - " + cuentasAsociadas.size();
    }

}
