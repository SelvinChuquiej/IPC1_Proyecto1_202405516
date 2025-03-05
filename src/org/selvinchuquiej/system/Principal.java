/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.selvinchuquiej.system;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.selvinchuquiej.controller.CrearCuentaController;
import org.selvinchuquiej.controller.UsuarioController;
import org.selvinchuquiej.model.Usuario;
import org.selvinchuquiej.view.CrearCuentaView;
import org.selvinchuquiej.view.LoginView;
import org.selvinchuquiej.view.PrincipalView;
import org.selvinchuquiej.view.RegistroUsuarioView;

/**
 *
 * @author Selvi
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    private JFrame ventanaActual;
    private PrincipalView principalView;
    private LoginView loginView;
    private RegistroUsuarioView registroUsuarioView;
    private CrearCuentaView crearCuentaView;
    private UsuarioController usuarioController;

    public Principal() {

        usuarioController = new UsuarioController();

        loginView = new LoginView(this);
        principalView = new PrincipalView(this);
        registroUsuarioView = new RegistroUsuarioView(this, usuarioController);
        crearCuentaView = new CrearCuentaView(this, usuarioController);

        //mostrarLoginView();
        mostrarPrincipalView();
    }

    public void mostrarLoginView() {
        cambiarVentana(loginView);
        loginView.setLocationRelativeTo(null);
    }

    public void mostrarPrincipalView() {
        cambiarVentana(principalView);
        principalView.setLocationRelativeTo(null);
    }

    public void mostrarRegistroUsuarioView() {
        cambiarVentana(registroUsuarioView);
        registroUsuarioView.setLocationRelativeTo(null);
    }

    public void mostrarCrearCuentaView() {
        cambiarVentana(crearCuentaView);
        crearCuentaView.setLocationRelativeTo(null);
        crearCuentaView.cargarUsuarios();
    }

    private void cambiarVentana(Ventana nuevaVentana) {
        if (ventanaActual != null) {
            ventanaActual.setVisible(true);
        }
        nuevaVentana.mostrar();
        ventanaActual = (JFrame) nuevaVentana;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Principal());
    }

}
