/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.selvinchuquiej.system;

import com.itextpdf.text.DocumentException;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.selvinchuquiej.controller.BitacoraController;
import org.selvinchuquiej.controller.BuscarCuentasController;
import org.selvinchuquiej.controller.RegistroClienteController;
import org.selvinchuquiej.controller.CrearCuentaController;
import org.selvinchuquiej.controller.DepositosController;
import org.selvinchuquiej.controller.GeneracionReporteController;
import org.selvinchuquiej.controller.HistorialTransaccionesController;
import org.selvinchuquiej.controller.LoginController;
import org.selvinchuquiej.controller.RetirosController;
import org.selvinchuquiej.model.Login;
import org.selvinchuquiej.view.BuscarCuentasView;
import org.selvinchuquiej.view.CrearCuentaView;
import org.selvinchuquiej.view.DepositosView;
import org.selvinchuquiej.view.GeneracionReportesView;
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
    private Login login;
    private JFrame ventanaActual;
    private PrincipalView principalView;
    private LoginView loginView;
    private RegistroClienteView registroUsuarioView;
    private CrearCuentaView crearCuentaView;
    private BuscarCuentasView buscarCuentasView;
    private DepositosView depositosView;
    private RetirosView retirosView;
    private HistorialTransaccionesView historialTransaccionesView;
    private GeneracionReportesView generacionReportesView;

    private BitacoraController bitacoraController;
    private LoginController loginController;
    private RegistroClienteController registroClienteController;
    private CrearCuentaController crearCuentaController;
    private BuscarCuentasController buscarCuentasController;
    private DepositosController depositosController;
    private RetirosController retirosController;
    private HistorialTransaccionesController historialTransaccionesController;
    private GeneracionReporteController generacionReporteController;

    public Principal() {

        login = new Login();

        bitacoraController = new BitacoraController(login);
        registroClienteController = new RegistroClienteController(bitacoraController);
        loginController = new LoginController(bitacoraController, login);
        crearCuentaController = new CrearCuentaController(registroClienteController, bitacoraController);
        buscarCuentasController = new BuscarCuentasController(registroClienteController, bitacoraController);
        depositosController = new DepositosController(crearCuentaController, bitacoraController);
        retirosController = new RetirosController(crearCuentaController, bitacoraController);
        historialTransaccionesController = new HistorialTransaccionesController(crearCuentaController, bitacoraController);
        generacionReporteController = new GeneracionReporteController(crearCuentaController, bitacoraController);

        loginView = new LoginView(this, loginController);
        principalView = new PrincipalView(this, registroClienteController, crearCuentaController, bitacoraController);
        registroUsuarioView = new RegistroClienteView(this, registroClienteController, bitacoraController);
        crearCuentaView = new CrearCuentaView(this, crearCuentaController);
        buscarCuentasView = new BuscarCuentasView(this, buscarCuentasController, bitacoraController);
        depositosView = new DepositosView(this, crearCuentaController, depositosController, bitacoraController);
        retirosView = new RetirosView(this, crearCuentaController, retirosController, bitacoraController);
        historialTransaccionesView = new HistorialTransaccionesView(this, historialTransaccionesController, bitacoraController);
        generacionReportesView = new GeneracionReportesView(this, generacionReporteController, bitacoraController);

        mostrarLoginView();
        //mostrarPrincipalView(); 

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

    public void mostrarRetirosView() {
        cambiarVentana(retirosView);
        retirosView.setLocationRelativeTo(null);
        retirosView.cargarCuentas();
    }

    public void mostrarHistorialView() {
        cambiarVentana(historialTransaccionesView);
        historialTransaccionesView.setLocationRelativeTo(null);
    }

    public void mostrarGeneracionReportesView() {
        cambiarVentana(generacionReportesView);
        generacionReportesView.setLocationRelativeTo(null);
    }

    private void cambiarVentana(Ventana nuevaVentana) {
        if (ventanaActual != null) {
            ventanaActual.setVisible(true);
        }
        nuevaVentana.mostrar();
        ventanaActual = (JFrame) nuevaVentana;
    }

    public static void main(String[] args) throws DocumentException {
        SwingUtilities.invokeLater(() -> new Principal());
    }
}
