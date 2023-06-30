/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examen;

import java.util.Stack;

/**
 *
 * @author leona
 */
public class Pila {

    private NodoPila cima;

    public Pila() {
        cima = null;
    }

    public void push(Tarea tarea) {
        NodoPila nuevoNodo = new NodoPila(tarea);
        if (cima == null) {
            cima = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(cima);
            cima = nuevoNodo;
        }
    }

    public Tarea pop() {
        if (cima == null) {
            return null;
        } else {
            Tarea tarea = cima.getTarea();
            cima = cima.getSiguiente();
            return tarea;
        }
    }

    public boolean estaVacia() {
        return cima == null;
    }

    class NodoPila {

        private Tarea tarea;
        private NodoPila siguiente;

        public NodoPila(Tarea tarea) {
            this.tarea = tarea;
            this.siguiente = null;
        }

        public Tarea getTarea() {
            return tarea;
        }

        public NodoPila getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(NodoPila siguiente) {
            this.siguiente = siguiente;
        }
    }

    public void mostrarTareas() {
        NodoPila nodoActual = cima;
        while (nodoActual != null) {
            Tarea tarea = nodoActual.getTarea();
            System.out.println("Nombre: " + tarea.getNombre());
            System.out.println("Descripción: " + tarea.getDescripcion());
            System.out.println("----------------------");
            nodoActual = nodoActual.getSiguiente();
        }
    }
}
