/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.utn.fra.prog2.controlador;

import ar.edu.utn.fra.prog2.modelo.Cine;
import ar.edu.utn.fra.prog2.modelo.Cliente;

/**
 * se encarga de la logica de acceso(login) y de registracion de usuarios nuevos
 * @author el_fr
 */
public class LoginController {

    private Cine cine;

    public LoginController(Cine cine) {
        this.cine = cine;
    }

    public Cliente login(String email, String contraseña) {
        return cine.login(email, contraseña);
    }

    public boolean registrar(String nombre, String email, String contraseña) {
        Cliente nuevo = new Cliente(nombre, email, contraseña);
        if (!cine.getClientes().contains(nuevo)) {
            cine.registrarCliente(nuevo);
            return true;
        }
        return false;
    }
}
