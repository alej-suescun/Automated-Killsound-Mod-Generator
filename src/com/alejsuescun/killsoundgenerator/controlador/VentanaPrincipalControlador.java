/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejsuescun.killsoundgenerator.controlador;

import com.alejsuescun.killsoundgenerator.modelo.*;
import com.alejsuescun.killsoundgenerator.vista.*;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * Clase que con controla los botones y cosas de VentanaPrincipal
 * @author alejSuescun
 */
public class VentanaPrincipalControlador {
    private final VentanaPrincipal ventanaPrincipal;
    private VentanaArchivo ventanaArchivo;
    private VentanaPropiedades ventanaPropiedades;
    private VentanaArchivoControlador ventanaArchivoControlador;
    
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
        String nombre = ventanaPrincipal.getTxtNombreMod();
        String pathMod = ventanaPrincipal.getTxtPathMod();
        ArrayList<Killsound> arrayKillsounds;
        Mod mod;
        
        if (!ArchivosManager.isGoodStringForFile(nombre)) {
            JOptionPane.showMessageDialog(ventanaPrincipal, 
                    "El nombre no puede estar vacio ni tener los siguientes caracteres: .*[/\\\\|:*?\\\"<>].*", 
                    "No se pudo crear el mod",JOptionPane.ERROR_MESSAGE);
            System.err.println("No se pudo crear el mod!");
            return;
        }
        System.out.println("El nombre del mod es: \""+nombre+"\"");
        
        if (pathMod.isBlank()) {
            JOptionPane.showMessageDialog(ventanaPrincipal, 
                    "No se ha seleccionado ninguna carpeta!", 
                    "No se pudo crear el mod",JOptionPane.ERROR_MESSAGE);
            System.err.println("No se pudo crear el mod!");
            return;
        }
        if (!ArchivosManager.verificarCarpetas(pathMod)) {
            JOptionPane.showMessageDialog(ventanaPrincipal, 
                    "La carpeta no existe o esta mal escrita!", 
                    "No se pudo crear el mod",JOptionPane.ERROR_MESSAGE);
            System.err.println("No se pudo crear el mod!");
            return;
        }

        System.out.println("El mod se guardara en: \""+pathMod+"\"");
        
        if (ventanaArchivoControlador == null) {
            JOptionPane.showMessageDialog(ventanaPrincipal, """
                                                            No se ha seleccionado ningun archivo!
                                                            Selecciona archivos en gestionar archivos
                                                            """, 
                    "No se pudo crear el mod",JOptionPane.ERROR_MESSAGE);
            System.err.println("No se pudo crear el mod!");
            return;
        }
        
        arrayKillsounds = ventanaArchivoControlador.getArrayKillsounds();
        
        if (arrayKillsounds.isEmpty()) {
            JOptionPane.showMessageDialog(ventanaPrincipal, """
                                                            No se ha seleccionado ningun archivo!
                                                            Selecciona archivos en gestionar archivos
                                                            """, 
                    "No se pudo crear el mod",JOptionPane.ERROR_MESSAGE);
            System.err.println("No se pudo crear el mod!");
            return;
        }
        int cantKillsounds = arrayKillsounds.size();
        
        if (cantKillsounds == 1) {
            mod = new ModKillsound(arrayKillsounds.get(0), nombre, pathMod);
            System.out.println("El mod tendra "+cantKillsounds+" killsound");
        } else {
            mod = new ModKillsoundMultiple(arrayKillsounds, nombre, pathMod);
            System.out.println("El mod tendra "+cantKillsounds+" killsounds");
        }
        
    }

    /**
     * Metodo que se llama a la hora de presionar el boton de gestionar archivos
     */
    private void onBtnGestionarArchivos(){
        SwingUtilities.invokeLater(() -> {
            if (ventanaArchivo != null && ventanaArchivo.isDisplayable()) {
                ventanaArchivo.setVisible(true);
                ventanaArchivo.toFront();
                ventanaArchivo.requestFocus();
                return;
            }
            
            ventanaArchivo = new VentanaArchivo(ventanaPrincipal);
            ventanaArchivoControlador = new VentanaArchivoControlador(ventanaArchivo);
        });
    }
    
    /**
     * Metodo que se llama a la hora de presionar el boton de cambiar propiedades
     */
    private void onBtnCambiarPropiedades(){
        SwingUtilities.invokeLater(() -> {
            if (ventanaPropiedades != null && ventanaPropiedades.isDisplayable()) {
                ventanaPropiedades.setVisible(true);
                ventanaPropiedades.toFront();
                ventanaPropiedades.requestFocus();
                return;
            }
            
            ventanaPropiedades = new VentanaPropiedades(ventanaPrincipal);
            // aca el ventana propiedades controlador pero no lo he creado cff
        });
    }
    
    /**
     * Metodo que se llama a la hora de presionar el boton que es a lado de la ruta del mod
     */
    private void onBtnPathMod(){
        ventanaPrincipal.setTxtPathMod(ArchivosManager.pedirRutaChooser(ventanaPrincipal)); 
    }
}
