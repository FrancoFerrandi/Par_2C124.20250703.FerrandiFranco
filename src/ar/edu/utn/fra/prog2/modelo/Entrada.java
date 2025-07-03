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
public class Entrada implements Serializable {

    private Cliente cliente;
    private Sala sala;
    private Butaca butaca;

    public Entrada(Cliente cliente, Sala sala, Butaca butaca) {
        if (cliente == null || sala == null || butaca == null) {
            throw new IllegalArgumentException("Cliente, sala y butaca no pueden ser nulos.");
        }
        this.cliente = cliente;
        this.sala = sala;
        this.butaca = butaca;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Sala getSala() {
        return sala;
    }

    public Butaca getButaca() {
        return butaca;
    }

    @Override
    public String toString() {
        return "Entrada{"
                + "cliente=" + cliente.getNombre()
                + ", sala=" + sala.getNumero()
                + ", película='" + sala.getPelicula() + '\''
                + ", fila=" + butaca.getFila()
                + ", asiento=" + butaca.getNumero()
                + '}';
    }
}
