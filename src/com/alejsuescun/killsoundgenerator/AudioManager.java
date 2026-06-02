/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejsuescun.killsoundgenerator;

import com.alejsuescun.killsoundgenerator.estructuradedatos.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.AudioFormat;
import javax.swing.JOptionPane;

/**
 * Clase que maneja los archivos de audio
 * @author suesc
 */
public class AudioManager {
    String[] arrayArchivos;
    String ubicacionCarpeta;
    static final String TITTLE = "AUTOMATED KILLSOUND MOD GENERATOR";
    static ListaDobleEnlazada listaOg, listaNueva;
    
    /**
     * Constructor de la clase cuando se usan carpetas
     * @param ubicacionCarpeta Un string con la ubicacion de la carpeta
     */
    public AudioManager(String ubicacionCarpeta) {
        this.ubicacionCarpeta = ubicacionCarpeta;
        this.arrayArchivos = null;
        this.listaOg = new ListaDobleEnlazada();
        this.listaNueva = new ListaDobleEnlazada();
    }
    
    
    public AudioManager(String[] arrayArchivos){
        this.arrayArchivos = arrayArchivos;
        this.ubicacionCarpeta = null;
        this.listaOg = new ListaDobleEnlazada();
        this.listaNueva = new ListaDobleEnlazada();
    }
    
    
    /**
     * Metodo que detecta los archivos usando Files.walk y llama {@link #validWav}
     * para cada archivo
     * @return True si detecta almenos 1 archivo, false si no detecta nada
     * @see #validWav
    **/
    public boolean detectArchivos(){
        if (ubicacionCarpeta == null && arrayArchivos == null) {
            return false;
        } else if (arrayArchivos != null){ // si son archivos
            int arraySize = arrayArchivos.length;
            Path[] paths = new Path[arraySize];
            
            for (int i = 0; i < arraySize; i++) {
                paths[i] = Paths.get(arrayArchivos[i]);
            }
            
            for (int i = 0; i < arraySize; i++) {
                validWav(paths[i].toFile());
            }
            
            if (listaOg.sizeLista() == 0) {
                JOptionPane.showMessageDialog(null,
                        "No se agrego ningun archivo! \n Prueba seleccionar otros archivos", TITTLE,
                        JOptionPane.WARNING_MESSAGE);
                return false;
            } else {
                JOptionPane.showMessageDialog(null,
                        "Se agregaron: "+listaOg.sizeLista()+" archivos", TITTLE,
                        JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        }
        
        Path path = Paths.get(ubicacionCarpeta);
        
        
        // miramos la carpeta con Files.walk (Java 8 para en adelante)
        // lo use pq era mas moderno
        try (Stream<Path> stream = Files.walk(path)) {

            stream.filter(Files::isRegularFile).map(Path::toFile).forEach(file -> {
                validWav(file);
            });
            
            if (listaOg.sizeLista() == 0) {
                JOptionPane.showMessageDialog(null,
                        "No se agrego ningun archivo! \n Prueba cambiar la carpeta", TITTLE,
                        JOptionPane.WARNING_MESSAGE);
                return false;
            } else {
                JOptionPane.showMessageDialog(null,
                        "Se agregaron: "+listaOg.sizeLista()+" archivos", TITTLE,
                        JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
            

            //listaOg.printLista();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    /**
     * Metodo que verifica el archivo que le es proporcionado
     * si es un WAV y cumple con los siguientes requisitos para TF2
     * (Requisitos sacados de 
     * <a href="https://developer.valvesoftware.com/wiki/WAV">WAV Valve Depelover Wiki</a>):
     * <ul>
     *  <li>Frecuencia de muestreo: 44100 Hz</li>
     *  <li>Profundidad de bits: 16 bits</li>
     * </ul>
     * sera añadido a {@link #listaOg}
     * 
     * @param file un archivo en lo ideal de audio y en wav
    **/
    public static void validWav(File file){
        String path = file.getAbsolutePath();
        try {
            AudioFileFormat fileFormat = AudioSystem.getAudioFileFormat(file);
            AudioFormat formato = fileFormat.getFormat();
            if (fileFormat.getType() == AudioFileFormat.Type.WAVE) { //Es igual a Wav
                // Requisitos sacados de: https://developer.valvesoftware.com/wiki/WAV
                // y de experencia propia :v
                float sampleRate = formato.getSampleRate();
                int bithDepth = formato.getSampleSizeInBits();
                
                if (sampleRate == 44100 && bithDepth == 16) {
                    //System.out.println("Se añadio: "+path);
                    listaOg.insertarFinal(path);
                } else {
                    System.out.println("El archivo: "+path+" esta mal configurado para TF2!");
                    System.out.println("Frecuencia de muestreo: "+sampleRate+" (Correcta: 44100)");
                    System.out.println("Profundidad de bits "+bithDepth+" (Correcta: 16)");
                    System.out.println("Por favor cambie las propiedades del archivo");
                }
 
            } else {
                System.out.println("El archivo: "+path+" no es un wav!");
            }
        } catch (UnsupportedAudioFileException e) {
            System.out.println("El archivo: "+path+" no es un wav!");
        } catch (IOException e){
            System.out.println("Sucedio un error!");
            e.printStackTrace();
        }
    }
    
    /**
     * Metodo que copia y pega todos los archivos registrados en listaOg
     * @param pathMod Ruta de donde el usuario decidio crear el mod
     */
    public void copyPasteArchivos(String pathMod){
        int sizeLista = listaOg.sizeLista();
        
        if (sizeLista == 0) {
            return;
        }
        
        // Lugar donde tienen que estar los audios
        // MiMod/sound/ui
        // mirar: https://wiki.teamfortress.com/wiki/Hit_Sound
        
        String pathSounds = pathMod.concat("\\sound\\ui");
        
        // Crear directorio
        try {
            Path path = Paths.get(pathSounds);
            Files.createDirectories(path);
            System.out.println("Se creo la carpeta de mods en: "+path);
        } catch (IOException e) {
            System.out.println("No se pudo crear la carpeta de mods en: "+pathSounds);
            e.printStackTrace();
        }
        
        //Copiar y pegar archivos
        try {
            for (int i = 0; i < sizeLista; i++) {
                Path sourceFile = Paths.get(listaOg.getXnodoDato(i));
                String fileName = sourceFile.getFileName().toString();
                Path targetFile = Paths.get(pathSounds+"\\"+fileName);
                
                Files.copy(sourceFile, targetFile, StandardCopyOption.REPLACE_EXISTING);
                listaNueva.insertarFinal(targetFile.toString());
                System.out.println("Se copio correctamente el archivo: "+targetFile.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public void renombrarArchivos(){
        ListaDobleEnlazada temp = listaNueva;
        Path source = Paths.get(temp.getXnodoDato(0));
        String sourceDirectory = source.getParent().toString();
        String nombreNuevo = sourceDirectory.concat("\\killsound.wav");
        int contKillsound = 0, sizeLista = temp.sizeLista();
        boolean sn = false;
        
        if (temp.eliminarXNodo(nombreNuevo)) {
            sizeLista--;
            contKillsound++;
        }
        
        for (int i = 1; i < sizeLista; i++) {
//            source = Paths.get(listaNueva.getXnodoDato(i));
            nombreNuevo = sourceDirectory.concat("\\killsound"+(i+1)+".wav");
            if (temp.eliminarXNodo(nombreNuevo)) {
                sizeLista--;
                contKillsound++;
            }
        }
        
        if (contKillsound == 0) {
            // renombrar archivos 
            try {
                nombreNuevo = sourceDirectory.concat("\\killsound.wav");
                Files.move(source, source.resolveSibling(nombreNuevo)); //Primer killsound
            } catch (FileAlreadyExistsException e){
                System.out.println("El archivo ya existe!");
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            sn = true;
            contKillsound++;
        }
        
        contKillsound++;
        // se esta saltando el for
        for (int i = (sn ? 1 : 0); i < sizeLista; i++) {
            source = Paths.get(temp.getXnodoDato(i));
            nombreNuevo = sourceDirectory.concat("\\killsound"+contKillsound+".wav");
            try {
                Files.move(source, source.resolveSibling(nombreNuevo));
                System.out.println("Se renombro correctamente: "+source.toString());
            } catch (FileAlreadyExistsException e) {
                System.out.println("El archivo ya existe!");
            } catch (IOException e) {
                e.printStackTrace();
            }
            contKillsound++;
        }
    }
    
    /**
     * Devuelve cuantos archivos tiene en listaOg
     * @return int con cuantos archivos tiene detectados
     * @see #listaOg
     */
    public int getCuantosArchivos(){
        return listaNueva.sizeLista();
    }
    
}
