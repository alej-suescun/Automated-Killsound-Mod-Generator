/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejsuescun.killsoundgenerator.modelo;

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
    
    @Override
    public void crearSubCarpetas() {
        throw new UnsupportedOperationException("Aun no programada :3");
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
