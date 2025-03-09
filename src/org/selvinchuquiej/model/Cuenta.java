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

    private String idCuenta;
    private Usuario usuario;
    private double saldo;

    public Cuenta() {
    }

    public Cuenta(String idCuenta, Usuario usuario, double saldo) {
        this.idCuenta = idCuenta;
        this.usuario = usuario;
        this.saldo = saldo;
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
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
        return "idCuenta=" + idCuenta + ", usuario=" + usuario ;
    }
    
    
}
