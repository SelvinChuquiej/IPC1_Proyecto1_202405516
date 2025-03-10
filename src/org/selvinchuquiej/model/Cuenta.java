/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.selvinchuquiej.model;

import java.util.ArrayList;

/**
 *
 * @author Selvi
 */
public class Cuenta {

    public static int contadorId = 0;
    private String idCuenta;
    private Cliente usuario;
    private double saldo;
    private ArrayList<Transaccion> transacciones;

    public Cuenta() {
    }

    public Cuenta(String idCuenta, Cliente usuario, double saldo) {
        this.idCuenta = idCuenta + String.format("%03d", contadorId);
        this.usuario = usuario;
        this.saldo = saldo;
        this.transacciones = new ArrayList<>();
    }

    public ArrayList<Transaccion> getTransaccion() {
        return transacciones;
    }

    public void setTransaccion(ArrayList<Transaccion> transaccion) {
        this.transacciones = transaccion;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
            System.out.println("Depósito realizado. Nuevo saldo: " + this.saldo);
        } else {
            System.out.println("El monto debe ser mayor que 0.");
        }
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
        return idCuenta + " | " + usuario.getNombreUsuario() + " | Q " + saldo;
    }

}
