/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejsuescun.killsoundgenerator.modelo;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author alejSuescun
 */
public class Audio {
    private File audioFileOld, audioFileNew;
    
    /**
     * Constructo para un audio de un mod
     * @param audioFileOld Objeto de file que direccione al archivo en su antigua direccion
     */
    public Audio(File audioFileOld) throws IllegalArgumentException{
        if (!validWav(audioFileOld)) {
            throw new IllegalArgumentException("El archivo proporcionado no cumple los requisitos");
        }
        this.audioFileOld = audioFileOld;
    }

    public File getAudioFileOld() {
        return audioFileOld;
    }

    public File getAudioFileNew() {
        return audioFileNew;
    }

    public void setAudioFileOld(File audioFileOld) throws IllegalArgumentException{
        if (!validWav(audioFileOld)) {
            throw new IllegalArgumentException("El archivo proporcionado no cumple los requisitos");
        }
        this.audioFileOld = audioFileOld;
    }

    public void setAudioFileNew(File audioFileNew) throws IllegalArgumentException {
        if (!validWav(audioFileNew)) {
            throw new IllegalArgumentException("El archivo proporcionado no cumple los requisitos");
        }
        this.audioFileNew = audioFileNew;
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
     * reutilizado del audioManager Original*
     * @param file Objeto de clase File que dirija a un archivo de audio wav
     * @return booleano, true si es un archivo wav valido para TF2
     */
    public static boolean validWav(File file){
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
                    return true;
                } else {
                    System.out.println("El archivo: "+path+" esta mal configurado para TF2!");
                    System.out.println("Frecuencia de muestreo: "+sampleRate+" (Correcta: 44100)");
                    System.out.println("Profundidad de bits "+bithDepth+" (Correcta: 16)");
                    System.out.println("Por favor cambie las propiedades del archivo");
                    return false;
                }
 
            } else {
                System.err.println("El archivo: "+path+" no es un wav!");
                return false;
            }
        } catch (UnsupportedAudioFileException e) {
            System.err.println("El archivo: "+path+" no es un wav!");
            return false;
        } catch (IOException e){
            System.err.println("Sucedio un error!");
            return false;
        }
    }
}
