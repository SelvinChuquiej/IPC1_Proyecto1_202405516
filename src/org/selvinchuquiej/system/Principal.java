/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.selvinchuquiej.system;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.selvinchuquiej.view.LoginView;
import org.selvinchuquiej.view.PrincipalView;

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
    
    public Principal() {
        loginView = new LoginView(this);
        principalView = new PrincipalView(this);
        mostrarLoginView();
 
    }
    
    public void mostrarLoginView() {
        cambiarVentana((Ventana) loginView);
        loginView.setLocationRelativeTo(null);
        
    }
    
    public void mostrarPrincipalView() {
        cambiarVentana((Ventana) principalView);
        principalView.setLocationRelativeTo(null);
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
