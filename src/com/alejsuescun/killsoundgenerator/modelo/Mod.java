/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejsuescun.killsoundgenerator.modelo;

/**
 * Clase base para un mod
 * @author alejSuescun
 */
public abstract class Mod {
    public final String NOMBRE_ARCHIVO = "Killsound";
    private String nombreMod, rutaMod;
    
    public Mod(String nombreMod, String rutaMod) {
        this.nombreMod = nombreMod;
        this.rutaMod = rutaMod;
    }
    
    public void crearCarpeta(){
        throw new UnsupportedOperationException("Aun no programada! :3");
    }
    
    public boolean verificarCarpeta(){
        throw new UnsupportedOperationException("Aun no programada! :3");
    }
    
    public abstract void crearSubCarpetas();
    
    public abstract boolean verificarSubCarpetas();
}
