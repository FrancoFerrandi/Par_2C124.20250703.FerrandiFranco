/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.utn.fra.prog2.persistencia;

import ar.edu.utn.fra.prog2.modelo.Cine;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Separa la lógica de almacenamiento del resto del modelo. Se importan las
 * clases de E/S y el modelo Cine
 * @author el_fr
 */
public class PersistenciaDatos {

    private static final String ARCHIVO = "cine.ser"; // cine.ser: archivo donde se guarda todo el estado del sistema

    public static void guardarEstado(Cine cine) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(cine);
        }
    }

    public static Cine cargarEstado() throws IOException, ClassNotFoundException {
        File file = new File(ARCHIVO);
        if (!file.exists()) {
            return new Cine();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (Cine) ois.readObject();
        }
    }
}
