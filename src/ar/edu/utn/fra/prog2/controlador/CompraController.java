/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.utn.fra.prog2.controlador;

/**
 *
 * @author el_fr
 */
import ar.edu.utn.fra.prog2.modelo.*;

public class CompraController {

    private Cine cine;

    public CompraController(Cine cine) {
        this.cine = cine;
    }

    public boolean comprar(Cliente cliente, Sala sala, int fila, int columna) {
        return cine.comprarEntrada(cliente, sala, fila, columna);
    }
}
