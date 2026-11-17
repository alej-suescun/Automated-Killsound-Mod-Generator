/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejsuescun.killsoundgenerator.modelo;

import static com.alejsuescun.killsoundgenerator.modelo.Mod.NOMBRE_CARPETA_SOUND;
import static com.alejsuescun.killsoundgenerator.modelo.Mod.NOMBRE_CARPETA_SOUND_UI;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Clase que es para un mod con multiples killsounds
 * @author alejSuescun
 */
public class ModKillsoundMultiple extends Mod{
    private ArrayList<Killsound> arrayKillsounds;
    
    public ModKillsoundMultiple(ArrayList<Killsound> arrayKillsounds, String nombreMod, String rutaMod) throws IllegalArgumentException {
        super(nombreMod, rutaMod);
        
        if (!isGoodArrayKillsounds(arrayKillsounds)) {
            throw new IllegalArgumentException("El array de killsounds no puede ser nulo ni tener menos de 2 killsounds");
        }
        this.arrayKillsounds = arrayKillsounds;
    }
    
    /**
     * Retorna el numero de killsounds que tiene el mod
     * @return entero con el numero de killsounds
     */
    public int getNumKillsounds() {
        return arrayKillsounds.size();
    }
    
    /**
     * Retorna el array de killsounds del mod
     * @return arrayKillsounds
     */
    public ArrayList<Killsound> getArrayKillsounds(){
        return arrayKillsounds;
    }
    
    /**
     * Metodo para poner un nuevo array de killsounds
     * @param arrayKillsounds ArrayList con clase Killsound minimo 2
     */
    public void setArrayKillsounds(ArrayList<Killsound> arrayKillsounds){
        if (!isGoodArrayKillsounds(arrayKillsounds)) {
            throw new IllegalArgumentException("El array de killsounds no puede ser nulo ni tener menos de 2 killsounds");
        }
        this.arrayKillsounds = arrayKillsounds;
    }
    
    /**
     * Metodo que crea la subCarpetas del mod,
     * crea: .../nombreMod/sound/ui, .../nombremod/scripts
     * 
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
            ArchivosManager.crearCarpetas(rutaBaseConcatenada, NOMBRE_CARPETA_SCRIPTS);
        } catch (FileNotFoundException e) {
            System.err.println("No se pudieron crear las subcarpetas para: "+nombreMod);
            System.err.println("    La ruta: \""+rutaBaseConcatenada+"\" no es valida!");
            System.err.println("    Por favor seleccione otra diferente!");
        }
    }
    
    /**
     * Metodo para verficar que existan las subcarpetas
     * ../sound/ui
     * ../scripts/
     * @return booleano true si existen
     */
    @Override
    public boolean verificarSubCarpetas() {
        String nombreMod = getNombreMod();
        String rutaMod = getRutaMod();
        String rutaBaseConcatenada = ArchivosManager.concatDosRutas(rutaMod, nombreMod);
        String rutaSonido = ArchivosManager.concatDosRutas(rutaBaseConcatenada, NOMBRE_CARPETA_SOUND);
        String rutaUI = ArchivosManager.concatDosRutas(rutaSonido, NOMBRE_CARPETA_SOUND_UI);
        String rutaScripts = ArchivosManager.concatDosRutas(rutaBaseConcatenada, NOMBRE_CARPETA_SCRIPTS);
        
        return ArchivosManager.verificarCarpetas(rutaUI) && ArchivosManager.verificarCarpetas(rutaScripts);
    }
    
    /**
     * Metodo para verificar si un array killsounds esta bien 
     * que no sea nullo ni que sea de menos de 2 killsounds
     * @param arrayKillsounds ArrayList con clase Killsound
     * @return booleano true si esta bien
     */
    public static boolean isGoodArrayKillsounds(ArrayList<Killsound> arrayKillsounds){
        return arrayKillsounds != null && arrayKillsounds.size() > 1;
    }
}
