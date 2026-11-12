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

    public ModKillsound(String nombreMod, String rutaMod) throws IllegalArgumentException {
        super(nombreMod, rutaMod);
    }

    @Override
    public void crearSubCarpetas() {
        throw new UnsupportedOperationException("Aun no programada :3");
    }

    @Override
    public boolean verificarSubCarpetas() {
        throw new UnsupportedOperationException("Aun no programada :3");
    }
    
    
}
