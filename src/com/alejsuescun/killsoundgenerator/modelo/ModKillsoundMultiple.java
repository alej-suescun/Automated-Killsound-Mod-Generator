/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejsuescun.killsoundgenerator.modelo;

import java.util.ArrayList;

/**
 * Clase que es para un mod con multiples killsounds
 * @author alejSuescun
 */
public class ModKillsoundMultiple extends Mod{
    private ArrayList<Audio> arrayKillsounds;
    
    public ModKillsoundMultiple(ArrayList<Audio> arrayKillsounds, String nombreMod, String rutaMod) throws IllegalArgumentException {
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
    public ArrayList<Audio> getArrayKillsounds(){
        return arrayKillsounds;
    }
    
    /**
     * Metodo para poner un nuevo array de killsounds
     * @param arrayKillsounds ArrayList con clase Audio minimo 2
     */
    public void setArrayKillsounds(ArrayList<Audio> arrayKillsounds){
        if (!isGoodArrayKillsounds(arrayKillsounds)) {
            throw new IllegalArgumentException("El array de killsounds no puede ser nulo ni tener menos de 2 killsounds");
        }
        this.arrayKillsounds = arrayKillsounds;
    }
    
    @Override
    public void crearSubCarpetas() {
        throw new UnsupportedOperationException("Aun no programada :3");
    }

    @Override
    public boolean verificarSubCarpetas() {
        throw new UnsupportedOperationException("Aun no programada :3");
    }
    
    /**
     * Metodo para verificar si un array killsounds esta bien 
     * que no sea nullo ni que sea de menos de 2 killsounds
     * @param arrayKillsounds ArrayList con clase Audio
     * @return booleano true si esta bien
     */
    public static boolean isGoodArrayKillsounds(ArrayList<Audio> arrayKillsounds){
        return arrayKillsounds != null && arrayKillsounds.size() > 1;
    }
}
