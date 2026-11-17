/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejsuescun.killsoundgenerator.controlador;

import com.alejsuescun.killsoundgenerator.modelo.ArchivosManager;
import com.alejsuescun.killsoundgenerator.modelo.Killsound;
import com.alejsuescun.killsoundgenerator.vista.VentanaArchivo;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase que controla los botones y cosas de la ventana de archivos
 * @author alejSuescun
 */
public class VentanaArchivoControlador {
    private final VentanaArchivo ventanaArchivo;
    private ArrayList<Killsound> arrayKillsoundSelec = new ArrayList<>(1);
    
    public VentanaArchivoControlador(VentanaArchivo ventanaArchivo) {
        this.ventanaArchivo = ventanaArchivo;
        init();
    }
    
    private void init(){
        ventanaArchivo.setBtnSelecArchivosListener((e) -> {onBtnSelecArchivos();});
        ventanaArchivo.setBtnSelecFolderListener((e) -> {onBtnSelecFolder();});
    }
    
    
    /**
     * Funcion que se ejecuta cuando se presiona el boton de seleccionar archivos
     */
    private void onBtnSelecArchivos(){
        File[] filesSelect = ArchivosManager.pedirRutaChooserVariosArchivos(ventanaArchivo);
        
        if (filesSelect == null) {
            return;
        }
        
        verificarArchivos(filesSelect);
        addArchivosGui();
    }
    
    /**
     * Funcion que se ejecuta cuando se presioan el boton de seleccionar por carpetas
     */
    private void onBtnSelecFolder(){
        File[] filesSelect = ArchivosManager.pedirRutaChooserVariosArchivos(ventanaArchivo, true);
        
        if (filesSelect == null) {
            return;
        }
        
        verificarArchivos(filesSelect);
        addArchivosGui();
    }
    
    /**
     * Metodo para añadir los archivos seleccionados por el usuario al array de killsounds
     * @param archivos 
     */
    private void verificarArchivos(File[] archivos){
        System.out.println("Verificando archivos si son killsounds...");
        for (File file : archivos) {
            try {
                arrayKillsoundSelec.add(new Killsound(file));
                System.out.println("    El archivo: \""+file.getAbsolutePath()+"\" fue añadido");
            } catch (Exception e) {
                System.err.println("    El archivo: \""+file.getAbsolutePath()+"\" no fue añadido");
            }
        }
    }
    
    private void addArchivosGui(){
        for (Killsound killsound : arrayKillsoundSelec) {
            File archivo = killsound.getAudioFileOld();
            Date fechaArchivo = new Date(archivo.lastModified());
            ventanaArchivo.addArchivo(archivo.getName(), archivo.getAbsolutePath(), new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(fechaArchivo));
        }
        
    }
}
