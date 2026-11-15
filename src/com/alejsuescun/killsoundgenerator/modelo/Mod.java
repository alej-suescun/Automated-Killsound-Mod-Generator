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
    /**
     * nombre que debe tener los archivos de killsound
     * de acuerdo a la <a href="https://wiki.teamfortress.com/wiki/Hit_Sound#Custom_Hit_Sounds">wiki de team fortress 2</a>
     */
    public static final String NOMBRE_ARCHIVO = "killsound";
    /**
     * nombre que debe tener la carpeta donde va el soundscript
     * de acuerdo a <a href="https://developer.valvesoftware.com/wiki/Soundscripts">Valve Developer Community</a>
     */
    public static final String NOMBRE_CARPETA_SCRIPTS = "scripts";
    /**
     * nombre que debe tener la carpeta de sonidos en team fortress 2
     * de acuerdo a la <a href="https://wiki.teamfortress.com/wiki/Hit_Sound#Custom_Hit_Sounds">wiki de team fortress 2</a>
     */
    public static final String NOMBRE_CARPETA_SOUND = "sound";
    /**
     * nombre que debe tener la carpeta de ui (donde van los killsounds) en team fortress 2
     * de acuerdo a la <a href="https://wiki.teamfortress.com/wiki/Hit_Sound#Custom_Hit_Sounds">wiki de team fortress 2</a>
     */
    public static final String NOMBRE_CARPETA_SOUND_UI = "ui";
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
     * Metodo para obtener el nombre del mod
     * @return String con el nombre del mod
     */
    public String getNombreMod() {
        return nombreMod;
    }
    
    /**
     * Metodo para obtener la ruta del mod
     * @return String con la ruta del mod
     */
    public String getRutaMod() {
        return rutaMod;
    }
    
    /**
     * Metodo para obtener el nombre del mod
     * @param nombreMod string con el nombre del mod
     */
    public void setNombreMod(String nombreMod) throws IllegalArgumentException{
        if (!ArchivosManager.isGoodStringForFile(nombreMod)) {
            throw new IllegalArgumentException("El nombre del mod no puede estar vacio o no cumple los requisitos!");
        }
        this.nombreMod = nombreMod;
    }
    
    /**
     * Metodo para poner una ruta para el mod
     * @param rutaMod string con la ruta del mod
     */
    public void setRutaMod(String rutaMod) throws IllegalArgumentException{
        if (rutaMod.isBlank()) {
            throw new IllegalArgumentException("La ruta del mod no puede estar vacia!");
        }
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
    
    /**
     * Metodo para verificar que exista la carpeta base del mod
     * @return booleano true si existen
     */
    public boolean verificarCarpeta(){
        return ArchivosManager.verificarCarpetas(rutaMod, nombreMod);
    }
    
    public abstract void crearSubCarpetas();
    
    public abstract boolean verificarSubCarpetas();
}
