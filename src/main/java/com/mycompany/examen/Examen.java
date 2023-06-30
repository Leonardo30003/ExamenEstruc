/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.examen;

import java.util.Scanner;

/**
 *
 * @author leona
 */
public class Examen {

    public static void main(String[] args) {
        Pila pila = new Pila();
        Cola cola = new Cola();
        ListaEnlazada listaEnlazada = new ListaEnlazada();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("¿Qué deseas hacer?");
            System.out.println("1. Agregar una tarea");
            System.out.println("2. Eliminar una tarea");
            System.out.println("3. Mostrar todas las tareas pendientes");
            System.out.println("4. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre de la tarea:");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese la descripción de la tarea:");
                    String descripcion = scanner.nextLine();

                    Tarea nuevaTarea = new Tarea(nombre, descripcion);
                    pila.push(nuevaTarea);
                    cola.enqueue(nuevaTarea);
                    listaEnlazada.insertarAlFinal(nuevaTarea);

                    System.out.println("Tarea agregada correctamente.");
                    break;
                case 2:
                    System.out.println("Ingrese el nombre de la tarea a eliminar:");
                    String nombreEliminar = scanner.nextLine();

                    listaEnlazada.eliminarTarea(nombreEliminar);

                    System.out.println("Tarea eliminada correctamente.");
                    break;
                case 3:
                    System.out.println("Tareas en la Pila:");
                    pila.mostrarTareas();

                    System.out.println("Tareas en la Cola:");
                    cola.mostrarTareas();

                    System.out.println("Tareas en la Lista Enlazada:");
                    listaEnlazada.mostrarTareas();
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, intenta nuevamente.");
                    break;
            }

            System.out.println();
        }
    }
}