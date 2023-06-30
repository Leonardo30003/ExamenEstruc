/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examen;

import java.util.LinkedList;

/**
 *
 * @author leona
 */
public class ListaEnlazada {
    private NodoLista primerNodo;
    private NodoLista ultimoNodo;

    public ListaEnlazada() {
        primerNodo = null;
        ultimoNodo = null;
    }

    public void insertarAlFinal(Tarea tarea) {
        NodoLista nuevoNodo = new NodoLista(tarea);
        if (primerNodo == null) {
            primerNodo = nuevoNodo;
            ultimoNodo = nuevoNodo;
        } else {
            ultimoNodo.setSiguiente(nuevoNodo);
            ultimoNodo = nuevoNodo;
        }
    }

public void eliminarTarea(String nombre) {
        NodoLista actual = primerNodo;
        NodoLista anterior = null;

        while (actual != null) {
            if (actual.getTarea().getNombre().equals(nombre)) {
                if (anterior == null) {
                    primerNodo = actual.getSiguiente();
                } else {
                    anterior.setSiguiente(actual.getSiguiente());
                }

                if (actual == ultimoNodo) {
                    ultimoNodo = anterior;
                }

                return;
            }

            anterior = actual;
            actual = actual.getSiguiente();
        }
    }


    public boolean estaVacia() {
        return primerNodo == null;
    }

public void mostrarTareas() {
    NodoLista nodoActual = primerNodo;
    while (nodoActual != null) {
        Tarea tarea = nodoActual.getTarea();
        System.out.println("Nombre: " + tarea.getNombre());
        System.out.println("Descripción: " + tarea.getDescripcion());
        System.out.println("----------------------");
        nodoActual = nodoActual.getSiguiente();
    }
}

    class NodoLista {
    private Tarea tarea;
    private NodoLista siguiente;

    public NodoLista(Tarea tarea) {
        this.tarea = tarea;
        this.siguiente = null;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public NodoLista getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLista siguiente) {
        this.siguiente = siguiente;
    }
}

}
