/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejsuescun.killsoundgenerator;

import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 *
 * @author suesc
 */
public class Main {
    static Scanner myKeyboard = new Scanner(System.in);
    
    public static void main(String[] args) {
        String nombreMod;
        int nKillsounds;

        System.out.println("AUTOMATED KILLSOUND MOD GENERATOR");
        
        seleccionArchivos();

        
        /*
        
        System.out.print("Ingrese el nombre del mod: ");
        nombreMod = myKeyboard.nextLine();
        
        do {
            System.out.print("Ingrese cuantos killsounds son: ");
            nKillsounds = myKeyboard.nextInt();
            
            if (nKillsounds <= 0) {
                System.out.println("Ingrese una cantidad valida");
            }
        } while (nKillsounds <= 0);
        
        
        System.out.println("Generando archivos...\n");
        ScriptGenerator creadorDeScripts300 = new ScriptGenerator(nKillsounds, nombreMod);
        
        creadorDeScripts300.generate(false);
        creadorDeScripts300.generate(true);
        System.out.println("Se crearon los scripts correctamente!");
        
        */
        
        /*
        
        abrir explorador de archivos con x carpeta
        
        try {
            new ProcessBuilder("explorer.exe", "/select," + "C:\\").start();
        } catch (IOException e) {
            System.out.println("Ocurrio un error!");
        }
        */
    }
    
    public static void seleccionArchivos(){
        System.out.println("Ingrese donde esta la carpeta con los audios ");      
        // Para mostrar la ventana de seleccion usando la libreria JFileChooser
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); //Solo seleccionar carpetas
        int action = chooser.showOpenDialog(null);
        if (action == JFileChooser.APPROVE_OPTION) {
            String carpetaAudios = chooser.getSelectedFile().getAbsolutePath();
            AudioManager myAudioManager = new AudioManager(carpetaAudios);
            
            System.out.println("Carpeta Seleccionada: "+carpetaAudios);
            myAudioManager.detectArchivos();
        } else {
            System.out.println("Cancelo la seleccion");
        }
        

    }
}
