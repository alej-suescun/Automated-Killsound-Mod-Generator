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

/**
 *
 * @author suesc
 */
public class AudioManager {
    String ubicacionCarpeta;
    static ListaDobleEnlazada listaOg, listaNueva;
    
    public AudioManager(String ubicacionCarpeta) {
        this.ubicacionCarpeta = ubicacionCarpeta;
        this.listaOg = new ListaDobleEnlazada();
        this.listaNueva = new ListaDobleEnlazada();
    }
    
    // añade a listaDobleEnzalada listaOg con los archivos .wav de la carpeta
    // que esten bien de requisitos
    public void detectArchivos(){
        Path path = Paths.get(ubicacionCarpeta);
        
        
        // miramos la carpeta con Files.walk (Java 8 para en adelante)
        // lo use pq era mas moderno
        try (Stream<Path> stream = Files.walk(path)) {

            stream.filter(Files::isRegularFile).map(Path::toFile).forEach(file -> {
                validWav(file);
            });
            
            System.out.println("Se detectaron "+listaOg.sizeLista()
                    +" archivos que estan bien");
            //listaOg.printLista();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    // Verifica el archivo q se le proporciona sea un WAV y q cumpla los requisitos
    // para TF2 si es asi los añade a la listaOg
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
    
}
