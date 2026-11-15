/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejsuescun.killsoundgenerator.modelo;

import java.io.FileNotFoundException;

/**
 * Clase que es para un mod de un solo killsound
 * @author alejSuescun
 */
public class ModKillsound extends Mod{
    private Killsound killsound;
    
    public ModKillsound(Killsound killsound,String nombreMod, String rutaMod) throws IllegalArgumentException {
        super(nombreMod, rutaMod);
        if (isGoodKillsound(killsound)) {
            throw new IllegalArgumentException("El killsound no puede ser null!");
        }
        this.killsound = killsound;
    }

    public Killsound getKillsound() {
        return killsound;
    }
    
    public void setKillsound(Killsound killsound) {
        if (isGoodKillsound(killsound)) {
            throw new IllegalArgumentException("El killsound no puede ser null!");
        }
        this.killsound = killsound;
    }
    
    /**
     * Metodo que crea la subCarpetas del mod,
     * debido que es un solo mod se creara solamente: .../nombreMod/sound/ui
     * Se sigue de acuerdo a lo que dice la <a href="https://wiki.teamfortress.com/wiki/Hit_Sound#Custom_Hit_Sounds">wiki de team fortress 2</a>
     */
    @Override
    public void crearSubCarpetas() {
        if (!verificarCarpeta()) {
            System.err.println("No se pueden crear las subcarpetas debido que aun no se ha creado la carpeta principal");
            return;
        }
        
        String[] nombreCarpetasArray = {NOMBRE_CARPETA_SOUND, NOMBRE_CARPETA_SOUND_UI};
        String nombreMod = getNombreMod();
        String rutaMod = getRutaMod();
        String rutaBaseConcatenada = ArchivosManager.concatDosRutas(rutaMod, nombreMod);
        try {
            System.out.println("Creando subcarpetas para: "+nombreMod);
            ArchivosManager.crearCarpetas(rutaBaseConcatenada, nombreCarpetasArray);
        } catch (FileNotFoundException e) {
            System.err.println("No se pudieron crear las subcarpetas para: "+nombreMod);
            System.err.println("    La ruta: \""+rutaBaseConcatenada+"\" no es valida!");
            System.err.println("    Por favor seleccione otra diferente!");
        }
    }

    @Override
    public boolean verificarSubCarpetas() {
        throw new UnsupportedOperationException("Aun no programada :3");
    }
    
    /**
     * Metodo para mirar si el killsound esta bien
     * @param killsound Clase killsound que no sea null
     * @return booleano true si esta bien
     */
    public static boolean isGoodKillsound(Killsound killsound){
        return killsound != null;
    }
}
