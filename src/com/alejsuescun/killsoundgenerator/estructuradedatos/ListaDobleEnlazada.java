/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejsuescun.killsoundgenerator.estructuradedatos;

/**
 * Clase que es una Lista Doblemente enlazada
 * 
 * @see Nodo
 * @author suesc
 */
public class ListaDobleEnlazada {
    Nodo head, tail;
    
    public ListaDobleEnlazada() {
        this.head = null;
        this.tail = null;
    }
    /**
     * Inserta un nuevo nodo al inicio
     * @param ubicacionArchivo String con la ubicacion de un archivo
     */
    public void insertarInicio(String ubicacionArchivo){
        Nodo nuevo = new Nodo(ubicacionArchivo);
        
        if (head == null) {
            //lista vacia
            head = nuevo;
            tail = nuevo;
            return;
        }
        
        nuevo.siguiente = head;
        head.anterior = nuevo;
        head = nuevo;
    }
    
    /**
     * Inserta un nuevo nodo al final
     * @param ubicacionArchivo String con la ubicacion de un archivo
     */
    public void insertarFinal(String ubicacionArchivo){
        Nodo nuevo = new Nodo(ubicacionArchivo);
        
        if (head == null) {
            //lista vacia
            head = nuevo;
            tail = nuevo;
            return;
        }
        
        nuevo.anterior = tail;
        tail.siguiente = nuevo;
        tail = nuevo;
    }
    
    /**
     * Retorna el tamaño de la lista
     * 
     * @return Un int con el tamaño de la lista
     */
    public int sizeLista(){
        if (head == null) {return 0;} // Lista vacia
        
        int i = 1;
        Nodo act = head;
        
        while (act.siguiente != null) {            
            i++;
            act = act.siguiente;
        }
        
        return i;
    }
    
    /**
     * Imprime la lista completa
     */
    public void printLista(){
        if (head == null) {
            System.out.println("Lista Vacia");
        }
        
        Nodo act = head;
        
        while (act.siguiente != null) {         
            System.out.println(act.ubicacionArchivo);
            act = act.siguiente;
        }
        
        System.out.println(act.ubicacionArchivo); // el ultimo :3
    }
}
