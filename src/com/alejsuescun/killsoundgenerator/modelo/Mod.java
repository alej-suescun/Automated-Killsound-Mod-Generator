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
    
    public Mod(String nombreMod, String rutaMod) throws IllegalArgumentException{
        if (!ArchivosManager.isGoodStringForFile(nombreMod)) {
            throw new IllegalArgumentException("El nombre del mod no puede estar vacio o no cumple los requisitos!");
        }
        
        if (rutaMod.isBlank()) {
            throw new IllegalArgumentException("La ruta del mod no puede estar vacia!");
        }
        
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
