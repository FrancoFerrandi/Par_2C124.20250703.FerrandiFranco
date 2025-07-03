/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.utn.fra.prog2.modelo;

/**
 *
 * @author el_fr
 */
import java.io.Serializable;

public class Sala implements Serializable {

    private int numero; //numero de sala
    private String pelicula;
    private Butaca[][] butacas; // matriz de objetos Butaca

    public Sala(int numero, String pelicula, int filas, int columnas) {
        this.numero = numero;
        this.pelicula = pelicula;
        this.butacas = new Butaca[filas][columnas];
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                butacas[f][c] = new Butaca(f, c, false); //butacas inicialmente libres (false)
            }
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    public Butaca[][] getButacas() {
        return butacas;
    }

    public Butaca getButaca(int fila, int columna) {
        if (fila >= 0 && fila < butacas.length && columna >= 0 && columna < butacas[0].length) {
            return butacas[fila][columna]; //Devuelve una butaca específica, siempre que la posición esté dentro de los límites de la matriz
        }
        return null;
    }

    public int getFilas() {
        return butacas.length; // cantidad de filas (es decir, cuántos arrays de columnas tiene)
    }

    public int getColumnas() {
        return butacas[0].length; // cantidad de columnas en la primera fila
    }

    @Override
    public String toString() {
        return "Sala " + numero + " - " + pelicula;
    }
}
