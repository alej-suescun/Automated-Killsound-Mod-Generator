/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejsuescun.killsoundgenerator.modelo;

import java.io.FileNotFoundException;

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
    
    /**
     * Metodo para crear la carpeta base del mod
     */
    public void crearCarpeta(){
        System.out.println("Creando carpetas para \""+nombreMod+"\" en: \""+rutaMod+"\"");
        try {
            ArchivosManager.crearCarpetas(rutaMod, nombreMod);
        } catch (FileNotFoundException e) {
            System.err.println("No se pudieron crear las carpetas para: \""+nombreMod+"\"");
            System.err.println("    La ruta: \""+rutaMod+"\" no es valida!");
            System.err.println("    Por favor seleccione otra diferente!");
        }
    }
    
    public boolean verificarCarpeta(){
        throw new UnsupportedOperationException("Aun no programada! :3");
    }
    
    public abstract void crearSubCarpetas();
    
    public abstract boolean verificarSubCarpetas();
}
