/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.selvinchuquiej.model;

import java.time.LocalDateTime;

/**
 *
 * @author Selvi
 */
public class Transaccion {

    private String idTransaccion;
    private LocalDateTime fechaHora;
    private String detalle;
    private double montoDebitado;
    private double montoAcreditado;
    private double saldoDisponible;

    public Transaccion() {
    }

    public Transaccion(String idTransaccion, LocalDateTime fechaHora, String detalle, double montoDebitado, double montoAcreditado, double saldoDisponible) {
        this.idTransaccion = idTransaccion;
        this.fechaHora = fechaHora;
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

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
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
        return "Transaccion{" + "idTransaccion=" + idTransaccion + ", fechaHora=" + fechaHora + ", detalle=" + detalle + ", montoDebitado=" + montoDebitado + ", montoAcreditado=" + montoAcreditado + ", saldoDisponible=" + saldoDisponible + '}';
    }

}
