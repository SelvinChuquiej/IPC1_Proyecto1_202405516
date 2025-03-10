/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.selvinchuquiej.system;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.selvinchuquiej.controller.BuscarCuentasController;
import org.selvinchuquiej.controller.CrearCuentaController;
import org.selvinchuquiej.controller.RegistroClienteController;
import org.selvinchuquiej.controller.CrearCuentaController;
import org.selvinchuquiej.controller.DepositosController;
import org.selvinchuquiej.controller.HistorialTransaccionesController;
import org.selvinchuquiej.controller.RetirosController;
import org.selvinchuquiej.model.Cliente;
import org.selvinchuquiej.model.Cuenta;
import org.selvinchuquiej.view.BuscarCuentasView;
import org.selvinchuquiej.view.CrearCuentaView;
import org.selvinchuquiej.view.DepositosView;
import org.selvinchuquiej.view.HistorialTransaccionesView;
import org.selvinchuquiej.view.LoginView;
import org.selvinchuquiej.view.PrincipalView;
import org.selvinchuquiej.view.RegistroClienteView;
import org.selvinchuquiej.view.RetirosView;

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
    private RegistroClienteView registroUsuarioView;
    private CrearCuentaView crearCuentaView;
    private BuscarCuentasView buscarCuentasView;
    private DepositosView depositosView;
    private RetirosView retirosView;
    private HistorialTransaccionesView historialTransaccionesView;

    private RegistroClienteController clienteController;
    private CrearCuentaController crearCuentaController;
    private BuscarCuentasController buscarCuentasController;
    private DepositosController depositosController;
    private RetirosController retirosController;
    private HistorialTransaccionesController historialTransaccionesController;

    private Cuenta cuenta;

    public Principal() {

        clienteController = new RegistroClienteController();
        crearCuentaController = new CrearCuentaController(clienteController);
        buscarCuentasController = new BuscarCuentasController(clienteController);
        depositosController = new DepositosController(crearCuentaController);
        retirosController = new RetirosController(crearCuentaController);
        historialTransaccionesController = new HistorialTransaccionesController(crearCuentaController);

        loginView = new LoginView(this);
        principalView = new PrincipalView(this);
        registroUsuarioView = new RegistroClienteView(this, clienteController);
        crearCuentaView = new CrearCuentaView(this, crearCuentaController, crearCuentaController);
        buscarCuentasView = new BuscarCuentasView(this, buscarCuentasController);
        depositosView = new DepositosView(this, crearCuentaController, depositosController);
        retirosView = new RetirosView(this, crearCuentaController, retirosController);
        historialTransaccionesView = new HistorialTransaccionesView(this, historialTransaccionesController);

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

    public void mostrarBuscarCuentasClientesView() {
        cambiarVentana(buscarCuentasView);
        buscarCuentasView.setLocationRelativeTo(null);
        buscarCuentasView.cargarUsuarios();
    }

    public void mostrarDepositosView() {
        cambiarVentana(depositosView);
        depositosView.setLocationRelativeTo(null);
        depositosView.cargarCuentas();
    }

    public void mostrarRetiros() {
        cambiarVentana(retirosView);
        retirosView.setLocationRelativeTo(null);
        retirosView.cargarCuentas();
    }

    public void mostrarHistorialView() {
        cambiarVentana(historialTransaccionesView);
        historialTransaccionesView.setLocationRelativeTo(null);
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
