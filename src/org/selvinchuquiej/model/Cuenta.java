/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.selvinchuquiej.model;

import java.util.List;

/**
 *
 * @author Selvi
 */
public class Cuenta {

    private String idCuenta;
    private Usuario usuario;
    private double saldo;
    private String tipoDeCuenta;
    private List<Transaccion> transacciones;

    public Cuenta() {
    }

    public Cuenta(String idCuenta, Usuario usuario, double saldo, String tipoDeCuenta, List<Transaccion> transacciones) {
        this.idCuenta = idCuenta;
        this.usuario = usuario;
        this.saldo = saldo;
        this.tipoDeCuenta = tipoDeCuenta;
        this.transacciones = transacciones;
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

    public String getTipoDeCuenta() {
        return tipoDeCuenta;
    }

    public void setTipoDeCuenta(String tipoDeCuenta) {
        this.tipoDeCuenta = tipoDeCuenta;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

}
