/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.selvinchuquiej.model;

/**
 *
 * @author Selvi
 */
public class Cuenta {

    public static int contadorId = 0;
    private String idCuenta;
    private Cliente usuario;
    private double saldo;

    public Cuenta() {
    }

    public Cuenta(String idCuenta, Cliente usuario, double saldo) {
        this.idCuenta = idCuenta + String.format("%03d", contadorId);
        this.usuario = usuario;
        this.saldo = saldo;
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Cliente getUsuario() {
        return usuario;
    }

    public void setUsuario(Cliente usuario) {
        this.usuario = usuario;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return idCuenta + " | " + usuario.getNombreUsuario();
    }

}
