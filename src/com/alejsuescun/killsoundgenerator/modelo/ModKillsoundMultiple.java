/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejsuescun.killsoundgenerator.modelo;

/**
 * Clase que es para un mod con multiples killsounds
 * @author alejSuescun
 */
public class ModKillsoundMultiple extends Mod{
    private int nKillsounds;

    public ModKillsoundMultiple(int nKillsounds, String nombreMod, String rutaMod) throws IllegalArgumentException {
        super(nombreMod, rutaMod);
        if (!isGoodNKillsounds(nKillsounds)) {
            throw new IllegalArgumentException("El numero de killsounds no puede ser negativo!");
        }
        this.nKillsounds = nKillsounds;
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
     * Metodo para mirar si los numeros de killsounds estan bien
     * Requisitos: Que sea mayor o igual a 0
     * @param nKillsounds entero con numero de killsounds
     * @return booleano true si esta bien
     */
    public static boolean isGoodNKillsounds(int nKillsounds){
        return (nKillsounds>=0);
    }
}
