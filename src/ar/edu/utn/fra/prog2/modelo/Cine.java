/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.utn.fra.prog2.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author el_fr
 */
public class Cine implements Serializable {

    private List<Sala> salas;
    private List<Entrada> entradas;
    private List<Cliente> clientes;

    public Cine() {
        this.salas = new ArrayList<>();
        this.entradas = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void agregarSala(Sala sala) {
        salas.add(sala);
    }

    /*RegistrarCliente: Agrega un cliente solo si no existe ya
     */
    public void registrarCliente(Cliente cliente) {
        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
        }
    }

    /* login:
Busca un cliente con el email y la contraseña correctos.
Si lo encuentra, lo devuelve (login exitoso); si no, devuelve null
     */
    public Cliente login(String email, String contraseña) {
        for (Cliente c : clientes) {
            if (c.getEmail().equals(email) && c.getContraseña().equals(contraseña)) {
                return c;
            }
        }
        return null;
    }

    public boolean comprarEntrada(Cliente cliente, Sala sala, int fila, int columna) {
        Butaca butaca = sala.getButaca(fila, columna);
        if (butaca != null && !butaca.isEstado()) {
            butaca.setEstado(true);
            Entrada entrada = new Entrada(cliente, sala, butaca);
            entradas.add(entrada);
            return true;
        }
        return false;
    }
}
