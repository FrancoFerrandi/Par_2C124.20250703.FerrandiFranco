/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.utn.fra.prog2.vista;

import ar.edu.utn.fra.prog2.controlador.CompraController;
import ar.edu.utn.fra.prog2.modelo.Butaca;
import ar.edu.utn.fra.prog2.modelo.Cine;
import ar.edu.utn.fra.prog2.modelo.Cliente;
import ar.edu.utn.fra.prog2.modelo.Entrada;
import ar.edu.utn.fra.prog2.modelo.Sala;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author el_fr
 */
public class SalaView {
    private Stage stage;
    private Cine cine;
    private Cliente cliente;
    private CompraController compraController;

    public SalaView(Stage stage, Cine cine, Cliente cliente) {
        this.stage = stage;
        this.cine = cine;
        this.cliente = cliente;
        this.compraController = new CompraController(cine);
    }

    public void mostrar() {
        VBox root = new VBox(10); 
        root.setPadding(new Insets(20)); 

        Label titulo = new Label(" Selecciona una sala");
        
        ComboBox<Sala> comboSalas = new ComboBox<>();
        comboSalas.getItems().addAll(cine.getSalas());

        GridPane gridButacas = new GridPane();
        Label mensaje = new Label();
        
        comboSalas.setOnAction(e -> {   
     
            Sala salaSeleccionada = comboSalas.getValue();
            gridButacas.getChildren().clear();
            if (salaSeleccionada != null) {
                Butaca[][] butacas = salaSeleccionada.getButacas();
                for (int f = 0; f < butacas.length; f++) {
                    for (int c = 0; c < butacas[0].length; c++) {
                        Butaca b = butacas[f][c];
                        Button btn = new Button(b.isEstado() ? "X" : "O");
                        btn.setDisable(b.isEstado()); //si esta ocupada desahabilita el boton
                        int fila = f, columna = c;

                        btn.setOnAction(ev -> {
                            boolean exito = compraController.comprar(cliente, salaSeleccionada, fila, columna);
                            Entrada entrada = new Entrada(cliente, salaSeleccionada, salaSeleccionada.getButaca(fila, columna));
                            new ConfirmacionView(stage, entrada).mostrar();
                        });

                        gridButacas.add(btn, c, f);
                    }
                }
            }
        });

        root.getChildren().addAll(titulo, comboSalas, gridButacas, mensaje);
        stage.setTitle("Salas - Cine");
        stage.setScene(new Scene(root, 400, 400));
        stage.show();
    }
}


