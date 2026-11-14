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
 * Clase Principal del programa
 * @author alejSuescun
 */
public class Main {
    private static VentanaPrincipal ventanaPrincipal;
    
    public static void main(String[] args) {
        ventanaPrincipal = new VentanaPrincipal();
        setSystemOut();
        printMensajePrincipio();
    }
    
    /**
     * Metodo q solo imprime los mensajes del principio
     */
    public static void printMensajePrincipio(){
        System.out.println("Automated Killsound Mod Generator ["+Version.VERSION_PROYECTO+"] para Team Fortess 2");
        System.out.println("Para empezar escribe el nombre de tu mod y selecciona una carpeta en donde guardarlo");
    }
    /**
     * Metodo para poner el systemOut como la consola de la GUI
     */
    public static void setSystemOut(){
        PrintStream consolaJframe = new PrintStream(new ConsoleTextAreaOutputStream(
                ventanaPrincipal.getTxtAreaConsola()), true, StandardCharsets.UTF_8);
        System.setOut(consolaJframe);
        System.setErr(consolaJframe);
    }
    
    /**
     * Metodo que se llama a la hora de presionar el boton de crear un mod
     */
    public static void onBtnCrearMod(){
        System.out.println("Aun no implementado :3");
    }
    
    /**
     * Metodo que se llama a la hora de presionar el boton de gestionar archivos
     */
    public static void onBtnGestionarArchivos(){
        System.out.println("Aun no implementado :3");
    }
    
    /**
     * Metodo que se llama a la hora de presionar el boton de cambiar propiedades
     */
    public static void onBtnCambiarPropiedades(){
        System.out.println("Aun no implementado :3");
    }
    
    /**
     * Metodo que se llama a la hora de presionar el boton que es a lado de la ruta del mod
     */
    public static void onBtnPathMod(){
        ventanaPrincipal.setTxtPathMod(ArchivosManager.pedirRutaChooser(ventanaPrincipal)); 
    }
}
