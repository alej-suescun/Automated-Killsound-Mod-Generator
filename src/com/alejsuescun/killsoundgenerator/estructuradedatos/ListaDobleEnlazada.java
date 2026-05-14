/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejsuescun.killsoundgenerator.estructuradedatos;

/**
 *
 * @author suesc
 */
public class ListaDobleEnlazada {
    Nodo head, tail;

    public ListaDobleEnlazada() {
        this.head = null;
        this.tail = null;
    }
    
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
    
    // Devuelve el tamaño de la lista
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
