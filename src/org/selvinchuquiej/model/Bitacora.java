/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.selvinchuquiej.model;

/**
 *
 * @author Selvi
 */
public class Bitacora {
    
    private String marcatTemporal;
    private String usuario;
    private String accion;
    private String resultado;
    private String detalle;

    public Bitacora(String marcatTemporal, String usuario, String accion, String resultado, String detalle) {
        this.marcatTemporal = marcatTemporal;
        this.usuario = usuario;
        this.accion = accion;
        this.resultado = resultado;
        this.detalle = detalle;
    }

    public String getMarcatTemporal() {
        return marcatTemporal;
    }

    public void setMarcatTemporal(String marcatTemporal) {
        this.marcatTemporal = marcatTemporal;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "Bitacora{" + "marcatTemporal=" + marcatTemporal + ", usuario=" + usuario + ", accion=" + accion + ", resultado=" + resultado + ", detalle=" + detalle + '}';
    }
    
    
}
