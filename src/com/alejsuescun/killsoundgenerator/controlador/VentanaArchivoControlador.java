/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejsuescun.killsoundgenerator.controlador;

import com.alejsuescun.killsoundgenerator.vista.VentanaArchivo;

/**
 * Clase que controla los botones y cosas de la ventana de archivos
 * @author alejSuescun
 */
public class VentanaArchivoControlador {
    private final VentanaArchivo ventanaArchivo;

    public VentanaArchivoControlador(VentanaArchivo ventanaArchivo) {
        this.ventanaArchivo = ventanaArchivo;
        init();
    }
    
    private void init(){
        ventanaArchivo.setBtnSelecArchivosListener((e) -> {onBtnSelecArchivos();});
        ventanaArchivo.setBtnSelecFolderListener((e) -> {onBtnSelecFolder();});
    }
    
    
    /**
     * Funcion que se ejecuta cuanod se presiona el boton de seleccionar archivos
     */
    private void onBtnSelecArchivos(){
        System.out.println("Aun no implementado >:3");
    }
    
    private void onBtnSelecFolder(){
        System.out.println("Aun no implementado >:3");
    }
}
