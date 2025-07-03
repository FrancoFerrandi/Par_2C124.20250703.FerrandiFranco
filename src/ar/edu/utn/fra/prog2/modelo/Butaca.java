/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.utn.fra.prog2.modelo;

import java.io.Serializable;

/**
 *
 * @author el_fr
 */
public class Butaca implements Serializable {

    private int fila;
    private int numero;
    private boolean estado;

    public Butaca(int fila, int numero, boolean estado) {
        this.fila = fila;
        this.numero = numero;
        this.estado = estado;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Fila " + fila + ", Asiento " + numero + " [" + (estado ? "Ocupada" : "Libre") + "]"; //"Ocupada" o "Libre", según el valor de estado
    }
}
