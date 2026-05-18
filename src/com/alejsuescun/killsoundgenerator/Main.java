/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejsuescun.killsoundgenerator;

//import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author suesc
 */
public class Main {
//    static Scanner myKeyboard = new Scanner(System.in);
    static String title = "AUTOMATED KILLSOUND MOD GENERATOR";
    
    public static void main(String[] args) {
        int opcion;
        String[] opciones = {"Crear Mod Nuevo", "Salir"};
        
        do {            
            opcion = menu(opciones);
            
            if (opcion == 0) {
                crearMod();
            }
        } while (opcion != 1); // Salir
        
        JOptionPane.showMessageDialog(null, "Saliendo del programa...", title, JOptionPane.INFORMATION_MESSAGE);
        /*
        System.out.println("AUTOMATED KILLSOUND MOD GENERATOR");
        
        seleccionArchivos();
        */
        /*
        String nombreMod;
        int nKillsounds;
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
    
    public static int menu(String[] opciones){
        
        int opcionElegida = JOptionPane.showOptionDialog(
                null, "¿Que desea hacer?", title, 
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                opciones, opciones[0]);
        return opcionElegida;
    }
    

    public static void crearMod(){
        String nombreMod = pedirNombre();
        
        if (nombreMod == null) {
            return;
        }
        
        
    }
    
    
    /**
     * Metodo que le pide el nombre al usuario
     * @return Null si el usuario le da a cancelar
    **/
    public static String pedirNombre(){
        String nombreMod;
        int sn;
        
        do {            
            nombreMod = JOptionPane.showInputDialog(null, 
                    "Ingrese el nombre que desea", title, JOptionPane.PLAIN_MESSAGE);
            
            if (nombreMod == null) { // Le da a cancelar
                return null;
            } else if (nombreMod.equals("") || nombreMod.equals(" ")) { // No ingresa nada
                JOptionPane.showMessageDialog(null,
                        "Ingrese un nombre valido", title, JOptionPane.ERROR_MESSAGE);
            } else {
                sn = JOptionPane.showConfirmDialog(null, 
                        "Ha ingresado: \""+nombreMod+"\"\n ¿Esta seguro?", title, JOptionPane.YES_NO_OPTION);
                
                if (sn == 0) {
                    break;
                }
            }
        } while (true);
        
        return nombreMod;
    }
}
