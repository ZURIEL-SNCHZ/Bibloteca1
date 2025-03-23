         /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibloteca;

/**
 *
 * @author Zuriel Ali Sampé Sánchez
 * 
 */import java.util.ArrayList;

public class Biblioteca {
private ArrayList<Libro> libros;

    public Biblioteca() {
        this.libros = new ArrayList<>();
    }

    public void agregarLibro(String titulo, String autor) {
        libros.add(new Libro(titulo, autor));
    }

    public void eliminarLibro(String titulo) {
        libros.removeIf(libro -> libro.getTitulo().equalsIgnoreCase(titulo));
    }

    public boolean buscarLibro(String titulo) {
        return libros.stream().anyMatch(libro -> libro.getTitulo().equalsIgnoreCase(titulo));
    }

    public String listarLibros() {
        StringBuilder lista = new StringBuilder();
        for (Libro libro : libros) {
            lista.append(libro.getTitulo())
                 .append(" - ")
                 .append(libro.getAutor())
                 .append(" - ")
                 .append(libro.isPrestado() ? "Prestado" : "Disponible")
                 .append("\n");
        }
        return lista.toString();
    }

    public boolean prestarLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo) && !libro.isPrestado()) {
                libro.prestar();
                return true;
            }
        }
        return false;
    }

    public boolean devolverLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo) && libro.isPrestado()) {
                libro.devolver();
                return true;
            }
        }
        return false;
    }
  
}
