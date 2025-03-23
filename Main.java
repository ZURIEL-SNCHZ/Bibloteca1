/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibloteca;

/**
 *
 * @author Zuriel Ali Sampé Sánchez 
 * 
 */import java.util.Scanner;

public class Main {
     public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Controlador controlador = new Controlador(biblioteca);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Biblioteca ---");
            System.out.println("1. Agregar libro");
            System.out.println("2. Eliminar libro");
            System.out.println("3. Listar libros");
            System.out.println("4. Buscar libro");
            System.out.println("5. Prestar libro");
            System.out.println("6. Devolver libro");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    controlador.manejarAgregar(titulo, autor);
                    break;
                case 2:
                    System.out.print("Título: ");
                    titulo = scanner.nextLine();
                    controlador.manejarEliminar(titulo);
                    break;
                case 3:
                    System.out.println(controlador.manejarListar());
                    break;
                case 4:
                    System.out.print("Título: ");
                    titulo = scanner.nextLine();
                    System.out.println(controlador.manejarBuscar(titulo) ? "Libro encontrado" : "No encontrado");
                    break;
                case 5:
                    System.out.print("Título: ");
                    titulo = scanner.nextLine();
                    System.out.println(controlador.manejarPrestar(titulo) ? "Libro prestado" : "No disponible");
                    break;
                case 6:
                    System.out.print("Título: ");
                    titulo = scanner.nextLine();
                    System.out.println(controlador.manejarDevolver(titulo) ? "Libro devuelto" : "No estaba prestado");
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }
}
