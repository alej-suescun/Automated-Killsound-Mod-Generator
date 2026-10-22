/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejsuescun.killsoundgenerator.modelo.estructuradedatos;

/**
 * Clase que es un Nodo apunta hacia al siguiente y el anterior
 * @see ListaDobleEnlazada
 * @author suesc
 */
public class Nodo {
    Nodo siguiente, anterior;
    String ubicacionArchivo;

    public Nodo(String ubicacionArchivo) {
        this.ubicacionArchivo = ubicacionArchivo;
        this.siguiente = null;
        this.anterior = null;
    }

}
