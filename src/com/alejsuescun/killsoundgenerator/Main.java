/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejsuescun.killsoundgenerator;

//import java.util.Scanner;
import java.io.File;
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
   
    /**
     * Metodo del menu
     * @param opciones Array de strings que contenga las opciones
     * @return int de la opcion seleccionada
     */
    public static int menu(String[] opciones){
        
        int opcionElegida = JOptionPane.showOptionDialog(
                null, "¿Que desea hacer?", title, 
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                opciones, opciones[0]);
        return opcionElegida;
    }
    
    /**
     * Metodo que contiene la logica para crear el mod
     */
    public static void crearMod(){
        String nombreMod = pedirNombre();
        String rutaMod;
        Boolean sn = false;
        
        if (nombreMod == null) { //cancelar
            return;
        }
        
        JOptionPane.showMessageDialog(null, 
                "Seleccione donde quiere crear el mod", title, JOptionPane.INFORMATION_MESSAGE);
        
        rutaMod = pedirRutaMod(nombreMod);
        
        if (rutaMod == null) { //cancelar
            return;
        }
        
        do {     

            String[] opciones = {"Seleccionar Carpeta que contenga los audios",
                "Seleccionar Archivos", "Cancelar"};
            int opcion = JOptionPane.showOptionDialog(null,
                    "Seleciona una opcion", title, JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            
            switch (opcion) {
                case 0:
                    do {                        
                        String ruta = seleccionArchivosCarpeta();
                        int cantArchivos;
                        
                        if (ruta == null) {break;} //Usuario Cancela

                        cantArchivos = carpetManager(ruta, rutaMod);
                        
                        if (cantArchivos == 0) {break;} //Usuario escoje una carpetavacia
                        
                        crearSoundScript(cantArchivos, nombreMod, rutaMod);
                        sn = true;
                        break;
                    } while (true);
                    break;
                case 1:
                    do {                        
                        String[] arrayRutas = seleccionVariosArchivos();
                        int cantArchivos;

                        if (arrayRutas == null) {break;}
                        
                        cantArchivos = archivosManager(arrayRutas, rutaMod);
                        
                        if (cantArchivos == 0) {break;}
                        
                        crearSoundScript(cantArchivos, nombreMod, rutaMod);
                        sn = true;
                        break;
                    } while (true);
                    break;
                case 2:
                    return;
                default:
                    noImplementadoMessage();
                    return;
            }
            
            if (sn) {
                JOptionPane.showMessageDialog(null, "Se creo correctamente el mod!", title, JOptionPane.INFORMATION_MESSAGE);
                break;
            }
        } while (true);
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
            
            if (nombreMod == null) { return null;} // Le da a cancelar
            
            if (nombreMod.equals("") || nombreMod.equals(" ")) { // No ingresa nada
                JOptionPane.showMessageDialog(null,
                        "Ingrese un nombre valido", title, JOptionPane.WARNING_MESSAGE);
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
    
    /**
     * Metodo para pedirle al usuario donde se guardara el mod
     * @param nombreMod String con el nombre del mod
     * @return string con la ruta seleccionada por el usuario+\nombreMod
     */
    public static String pedirRutaMod(String nombreMod){
        String ruta;
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); //Solo seleccionar carpeta
        
        do {            
            int action = chooser.showOpenDialog(null);
            if (action == JFileChooser.APPROVE_OPTION) {
                
                ruta = chooser.getSelectedFile().getAbsolutePath();
                
                ruta = ruta.concat("\\"+nombreMod);
                
                
                int op = JOptionPane.showConfirmDialog(null,
                        "Se creara el mod en: \""+ruta+"\"\n ¿Es correcta?",
                        title, JOptionPane.YES_NO_OPTION);
                if (op == 0) {
                    return ruta;
                }
            } else {
                return null;
            }  
        } while (true);
    }
    
    
    /**
     * Metodo para seleccionar los archivos de la manera de seleccionar una carpeta, 
     * utiliza JFileChooser
     * @return Un string con la direccion de la carpeta o null si cancela el usuario
     * @see JFileChooser
     */
    public static String seleccionArchivosCarpeta(){
        JFileChooser chooser = new JFileChooser();
        String carpetaAudios;
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); //Solo seleccionar carpetas
        do {            
            int action = chooser.showOpenDialog(null);
            if (action == JFileChooser.APPROVE_OPTION) {
                /*
                String carpetaAudios = chooser.getSelectedFile().getAbsolutePath();
                AudioManager myAudioManager = new AudioManager(carpetaAudios);

                System.out.println("Carpeta Seleccionada: "+carpetaAudios);
                myAudioManager.detectArchivos();
                */

                carpetaAudios = chooser.getSelectedFile().getAbsolutePath();
                int op = JOptionPane.showConfirmDialog(null,
                        "Selecciono: \""+carpetaAudios+"\"\n ¿Es correcta?",
                        title, JOptionPane.YES_NO_OPTION);
                
                if (op == 0) {
                    return carpetaAudios;
                }
                
                
            } else {
                return null;
            }  
        } while (true);
        

    }
    
    /**
     * Metodo para usar AudioManager pero con una carpeta. 
     * Se usa AudioManager.detectArchivos para agregarlos a la listaOg de audiomanager
     * @param ruta Un string con la ruta de la carpeta
     * @param rutaMod Un string con la ruta del mod
     * @return Int con cuantos archivos detecto
     * @see AudioManager
     */
    public static int carpetManager(String ruta, String rutaMod){
        AudioManager myAudioManager = new AudioManager(ruta);
        
        if (myAudioManager.detectArchivos()) {
            return cuantosArchivos(myAudioManager, rutaMod);
        } else {
            return 0;
        }
    }
    
    /**
     * Metodo que genera el soundScript en ...\NombreMod\Scripts
     * @param cantAudios int con cuantos audios va a tener el script
     * @param nombreMod String con el nombre del mod
     * @param pathMod String con la ruta del mod
     */
    public static void crearSoundScript(int cantAudios, String nombreMod, String pathMod){
        if (cantAudios == 0) {
            JOptionPane.showMessageDialog(null, 
                    "Alerta se proporcionaron 0 audios!", title, JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        System.out.println("Generando archivos...\n");
        ScriptGenerator creadorDeScripts300 = new ScriptGenerator(cantAudios, nombreMod, pathMod);
        
        creadorDeScripts300.generate(false);
        creadorDeScripts300.generate(true);
        System.out.println("Se crearon los scripts correctamente!");
        
        
    }
    
    /**
     * Metodo para pedirle al usuario que seleccione varios archivos
     * @return Un array de strings con la ruta de los archivos
     */
    public static String[] seleccionVariosArchivos(){
        JFileChooser chooser = new JFileChooser();
        String[] arrayDeArchivosAudios;
        chooser.setMultiSelectionEnabled(true); //Solo seleccionar carpetas
        do {            
            int action = chooser.showOpenDialog(null);
            if (action == JFileChooser.APPROVE_OPTION) {
                /*
                String carpetaAudios = chooser.getSelectedFile().getAbsolutePath();
                AudioManager myAudioManager = new AudioManager(carpetaAudios);

                System.out.println("Carpeta Seleccionada: "+carpetaAudios);
                myAudioManager.detectArchivos();
                */
                File[] archivos = chooser.getSelectedFiles();
                
                int op = JOptionPane.showConfirmDialog(null,
                        "Selecciono "+archivos.length+" archivos\n ¿Es correcto?",
                        title, JOptionPane.YES_NO_OPTION);
                
                if (op == 0) {
                    int size = archivos.length;
                    arrayDeArchivosAudios = new String[size];
                    for (int i = 0; i < size; i++) {
                        File file = archivos[i];
                        arrayDeArchivosAudios[i] = file.getAbsolutePath();
                    }
                    return arrayDeArchivosAudios;
                }    
            } else { // Cancela
                return null;
            }  
        } while (true);
    }
    
    /**
     * Metodo que maneja todo dependiendo con archivos
     * 
     * @param arrayArchivos un array con las rutas de los archivos
     * @param rutaMod un string con la ruta del mod
     * @return entero con cuantos archivos
     */
    public static int archivosManager(String[] arrayArchivos, String rutaMod){
        AudioManager myAudioManager = new AudioManager(arrayArchivos);
        
        if (myAudioManager.detectArchivos()) {
            return cuantosArchivos(myAudioManager, rutaMod);  
        } else {
            return 0;
        }
    }
    
    /**
     * Metodo que consigue cuantos archivos se copiaron y renombraron
     * @param myAudioManager un audio manager
     * @param rutaMod un string con la ruta del mod
     * @return entero con cuantos archivos
     */
    public static int cuantosArchivos(AudioManager myAudioManager, String rutaMod){
            JOptionPane.showMessageDialog(null, "Copiando archivos...", title, JOptionPane.PLAIN_MESSAGE);
            
            myAudioManager.copyPasteArchivos(rutaMod);
            
            JOptionPane.showMessageDialog(null, "Se copiaron los archivos correctamente!", title, JOptionPane.INFORMATION_MESSAGE);
            
            JOptionPane.showMessageDialog(null, "Renombrando archivos...", title, JOptionPane.INFORMATION_MESSAGE);
            
            myAudioManager.renombrarArchivos();
            
            JOptionPane.showMessageDialog(null, "Se renombraron los archivos correctamente!", title, JOptionPane.INFORMATION_MESSAGE);
            
            return myAudioManager.getCuantosArchivos();
    }
    
    /**
     * Metodo que muestra el mensaje que aun no esta implementado
     */
    public static void noImplementadoMessage(){
        JOptionPane.showMessageDialog(null, "Aun no esta implementado!", title, JOptionPane.WARNING_MESSAGE);
    }
    
}
