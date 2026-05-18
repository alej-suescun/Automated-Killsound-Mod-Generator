/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejsuescun.killsoundgenerator;

import com.alejsuescun.killsoundgenerator.estructuradedatos.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    String ubicacionCarpeta;
    static String title = "AUTOMATED KILLSOUND MOD GENERATOR";
    static ListaDobleEnlazada listaOg, listaNueva;
    
    /**
     * Constructor de la clase
     * @param ubicacionCarpeta Un string con la ubicacion de la carpeta
     */
    public AudioManager(String ubicacionCarpeta) {
        this.ubicacionCarpeta = ubicacionCarpeta;
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
        Path path = Paths.get(ubicacionCarpeta);
        
        
        // miramos la carpeta con Files.walk (Java 8 para en adelante)
        // lo use pq era mas moderno
        try (Stream<Path> stream = Files.walk(path)) {

            stream.filter(Files::isRegularFile).map(Path::toFile).forEach(file -> {
                validWav(file);
            });
            
            if (listaOg.sizeLista() == 0) {
                JOptionPane.showMessageDialog(null,
                        "No ee agrego ningun archivo! \n Prueba cambiar la carpeta", title,
                        JOptionPane.WARNING_MESSAGE);
                return false;
            } else {
                JOptionPane.showMessageDialog(null,
                        "Se agregaron: "+listaOg.sizeLista()+" archivos", title,
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
    
    public void renombrarArchivos(){
        
    }
    
    /**
     * Devuelve cuantos archivos tiene en listaOg
     * @return int con cuantos archivos tiene detectados
     * @see #listaOg
     */
    public int getCuantosArchivos(){
        return listaOg.sizeLista();
    }
    
}
