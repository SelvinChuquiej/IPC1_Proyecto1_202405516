/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.selvinchuquiej.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static org.selvinchuquiej.model.Cuenta.contadorId;

/**
 *
 * @author Selvi
 */
public class Transaccion {

    private String idTransaccion;
    private Cuenta idCuenta;
    private String fechaHora;
    private String detalle;
    private double montoDebitado;
    private double montoAcreditado;
    private double saldoDisponible;
    public static int contadorId = 0;

    LocalDateTime fechaHoras = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    String fechaFormateada = fechaHoras.format(formatter);

    public Transaccion() {
    }

    public Transaccion(Cuenta idCuenta, String detalle, double montoDebitado, double montoAcreditado, double saldoDisponible) {
        this.idTransaccion = "1" + String.format("%03d", contadorId++);
        this.idCuenta = idCuenta;
        this.fechaHora = fechaFormateada;
        this.detalle = detalle;
        this.montoDebitado = montoDebitado;
        this.montoAcreditado = montoAcreditado;
        this.saldoDisponible = saldoDisponible;
    }

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Cuenta getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Cuenta idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public double getMontoDebitado() {
        return montoDebitado;
    }

    public void setMontoDebitado(double montoDebitado) {
        this.montoDebitado = montoDebitado;
    }

    public double getMontoAcreditado() {
        return montoAcreditado;
    }

    public void setMontoAcreditado(double montoAcreditado) {
        this.montoAcreditado = montoAcreditado;
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }


    @Override
    public String toString() {
        return idTransaccion + " | " + detalle + " | " + montoDebitado + " | " + montoAcreditado + " | " + saldoDisponible;
    }

}
