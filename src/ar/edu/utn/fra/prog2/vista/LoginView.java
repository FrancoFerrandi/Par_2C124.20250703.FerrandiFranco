/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.utn.fra.prog2.vista;

import ar.edu.utn.fra.prog2.controlador.LoginController;
import ar.edu.utn.fra.prog2.modelo.Cine;
import ar.edu.utn.fra.prog2.modelo.Cliente;
import ar.edu.utn.fra.prog2.persistencia.PersistenciaDatos;
import java.io.IOException;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author el_fr
 */
public class LoginView {

    private Stage stage;
    private Cine cine;
    private LoginController controller;

    public LoginView(Stage stage, Cine cine) {
        this.stage = stage;
        this.cine = cine;
        this.controller = new LoginController(cine);
    }

    public void mostrar() {
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        Label titulo = new Label("Bienvenido al cine");
        TextField emailField = new TextField(); //campo de entrada del email
        emailField.setPromptText("Email");

        PasswordField passwordField = new PasswordField(); //campo de entrada de la contraseña (oculta el texto)
        passwordField.setPromptText("Contraseña");

        TextField nombreField = new TextField(); //solo se usa al registrarse, para ingresar el nombre completo
        nombreField.setPromptText("Nombre (solo para registrarse)");

        Button loginBtn = new Button("Iniciar Sesion");
        Button registrarBtn = new Button("Registrarse");
        Label mensaje = new Label(); //muestra mensajes de estado (exito o error para iniciar sesion)
        loginBtn.setOnAction(e -> {

            String email = emailField.getText();
            String pass = passwordField.getText();
            Cliente c = controller.login(email, pass);
            if (c != null) {
                mensaje.setText("Entrada exitosa. Bienvenido " + c.getNombre());
                new SalaView(stage, cine, c).mostrar();
            } else {
                mensaje.setText("Datos Invalidos");
            }
        });

        registrarBtn.setOnAction(e -> {

            String nombre = nombreField.getText();
            String email = emailField.getText();
            String pass = passwordField.getText();
            boolean registrado = controller.registrar(nombre, email, pass);
            mensaje.setText(registrado ? "Registrado con éxito." : "El cliente ya existe.");
            if (registrado) {
                try {
                    PersistenciaDatos.guardarEstado(cine);
                } catch (IOException ex) {
                    mensaje.setText("Error al guardar el cliente.");
                    ex.printStackTrace();
                }
            }
        });

        root.getChildren().addAll(titulo, nombreField, emailField, passwordField, loginBtn, registrarBtn, mensaje);
        stage.setTitle("Entrar - Cine");
        stage.setScene(new Scene(root, 300, 300));
        stage.show();
    }
}
