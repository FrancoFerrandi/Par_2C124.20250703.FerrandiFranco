/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.utn.fra.prog2.app;

import ar.edu.utn.fra.prog2.modelo.Cine;
import ar.edu.utn.fra.prog2.modelo.Sala;
import ar.edu.utn.fra.prog2.persistencia.PersistenciaDatos;
import ar.edu.utn.fra.prog2.vista.LoginView;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

/**
 *
 * @author el_fr
 */
public class MainApp extends Application {

    private Cine cine;

    @Override
    public void start(Stage stagePrimario) {
        try {
            cine = PersistenciaDatos.cargarEstado();
        } catch (Exception e) {
            System.err.println("️ Error al cargar estado: " + e.getMessage());
            cine = new Cine();
        }

        if (cine.getSalas().isEmpty()) {
            cine.agregarSala(new Sala(1, "Titanic", 7, 6));
            cine.agregarSala(new Sala(2, "El señor de los anillos 3", 10, 9));
            cine.agregarSala(new Sala(3, "The Big Short", 6, 5));
        }
        LoginView loginView = new LoginView(stagePrimario, cine);
        loginView.mostrar();
    }

    @Override
    public void stop() {

        try {
            PersistenciaDatos.guardarEstado(cine);
        } catch (Exception e) {
            System.err.println(" Error al guardar estado: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
