/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.utn.fra.prog2.vista;

import ar.edu.utn.fra.prog2.modelo.Entrada;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author el_fr
 */
public class ConfirmacionView {

    private Stage stage;
    private Entrada entrada;

    public ConfirmacionView(Stage stage, Entrada entrada) {
        this.stage = stage;
        this.entrada = entrada;
    }

    public void mostrar() {
        VBox root = new VBox(15);
        root.setPadding(new Insets(20));

        Label titulo = new Label(" Compra confirmada");
        Label datosCliente = new Label("Cliente: " + entrada.getCliente().getNombre());
        Label sala = new Label("Sala: " + entrada.getSala().getNumero());
        Label pelicula = new Label("Película: " + entrada.getSala().getPelicula());
        Label butaca = new Label("Butaca: Fila " + entrada.getButaca().getFila() + ", Nº " + entrada.getButaca().getNumero());

        root.getChildren().addAll(titulo, datosCliente, sala, pelicula, butaca);
        stage.setTitle("Confirmación de compra");
        stage.setScene(new Scene(root, 300, 250));
        stage.show();
    }
}
