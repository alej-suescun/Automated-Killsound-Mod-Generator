/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejsuescun.killsoundgenerator.controlador;

import com.alejsuescun.killsoundgenerator.modelo.*;
import com.alejsuescun.killsoundgenerator.vista.*;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Clase que con controla los botones y cosas de VentanaPrincipal
 * @author alejSuescun
 */
public class VentanaPrincipalControlador {
    private final VentanaPrincipal ventanaPrincipal;

    public VentanaPrincipalControlador(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
        init();
    }
    
    /**
     * Metodo que conecta las funciones con ventanaPrincipal
     */
    private void init(){
        setSystemOut();
        ventanaPrincipal.setBtnCrearModListener(((e) -> {onBtnCrearMod();}));
        ventanaPrincipal.setBtnGestionarArchivosListener((e) -> {onBtnGestionarArchivos();});
        ventanaPrincipal.setBtnCambiarPropiedadesListener((e) -> {onBtnCambiarPropiedades();});
        ventanaPrincipal.setBtnPathModListener((e) -> {onBtnPathMod();});
        
    }
    
    /**
     * Metodo q solo imprime los mensajes del principio y q no me salga q variable no usada
     */
    public void printMensajePrincipio(){
        System.out.println("Automated Killsound Mod Generator ["+Version.VERSION_PROYECTO+"] para Team Fortess 2");
        System.out.println("Para empezar escribe el nombre de tu mod y selecciona una carpeta en donde guardarlo");
    }
    
    /**
     * Metodo para poner el systemOut como la consola de la GUI
     */
    private void setSystemOut(){
        PrintStream consolaJframe = new PrintStream(new ConsoleTextAreaOutputStream(
                ventanaPrincipal.getTxtAreaConsola()), true, StandardCharsets.UTF_8);
        System.setOut(consolaJframe);
        System.setErr(consolaJframe);
    }
    
    
    /**
     * Metodo que se llama a la hora de presionar el boton de crear un mod
     */
    private void onBtnCrearMod(){
        System.out.println("Aun no implementado :33");
    }

    /**
     * Metodo que se llama a la hora de presionar el boton de gestionar archivos
     */
    private void onBtnGestionarArchivos(){
        VentanaArchivos ventanaArchivos = new VentanaArchivos(ventanaPrincipal);
    }
    
    /**
     * Metodo que se llama a la hora de presionar el boton de cambiar propiedades
     */
    private void onBtnCambiarPropiedades(){
        System.out.println("Aun no implementado :3");
    }
    
    /**
     * Metodo que se llama a la hora de presionar el boton que es a lado de la ruta del mod
     */
    private void onBtnPathMod(){
        ventanaPrincipal.setTxtPathMod(ArchivosManager.pedirRutaChooser(ventanaPrincipal)); 
    }
}
