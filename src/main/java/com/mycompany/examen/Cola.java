/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examen;

/**
 *
 * @author leona
 */
class Cola {
    private NodoCola frente;
    private NodoCola fin;

    public Cola() {
        frente = null;
        fin = null;
    }
public void mostrarTareas() {
    NodoCola nodoActual = frente;
    while (nodoActual != null) {
        Tarea tarea = nodoActual.getTarea();
        System.out.println("Nombre: " + tarea.getNombre());
        System.out.println("Descripción: " + tarea.getDescripcion());
        System.out.println("----------------------");
        nodoActual = nodoActual.getSiguiente();
    }
}

    public void enqueue(Tarea tarea) {
        NodoCola nuevoNodo = new NodoCola(tarea);
        if (fin == null) {
            frente = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.setSiguiente(nuevoNodo);
            fin = nuevoNodo;
        }
    }

    public Tarea dequeue() {
        if (frente == null) {
            return null;
        } else {
            Tarea tarea = frente.getTarea();
            frente = frente.getSiguiente();
            if (frente == null) {
                fin = null;
            }
            return tarea;
        }
    }

    public boolean estaVacia() {
        return frente == null;
    }
}

class NodoCola {
    private Tarea tarea;
    private NodoCola siguiente;

    public NodoCola(Tarea tarea) {
        this.tarea = tarea;
        this.siguiente = null;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public NodoCola getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCola siguiente) {
        this.siguiente = siguiente;
    }
    
}
