/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.utn.fra.prog2.controlador;

import ar.edu.utn.fra.prog2.modelo.Cine;
import ar.edu.utn.fra.prog2.modelo.Sala;
import java.util.List;

/**
 * Este controlador se encarga de manejar todo lo relacionado con las salas del
 * cine: consultarlas, seleccionarlas
 * @author el_fr
 */
public class SalaController {

    private Cine cine;

    public SalaController(Cine cine) {
        this.cine = cine;
    }

    public List<Sala> obtenerSalas() {
        return cine.getSalas();
    }

    public Sala obtenerSalaPorNumero(int numero) {
        return cine.getSalas()
                .stream()
                .filter(s -> s.getNumero() == numero)
                .findFirst()
                .orElse(null);
    }
}
