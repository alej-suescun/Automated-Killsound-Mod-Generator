/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejsuescun.killsoundgenerator.modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Clase
 * @author alejSuescun
 */
public class ArchivosManager {

    /**
     * Metodo para generar un archivo txt basico sin UFT_8
     * @param path String que direccione a donde se quiere crear el archivo
     * @param title String con el titulo del archivo (Sin el .txt)
     * @param content String con el contenido del TXT
     */
    public static void crearArchivoTXT(String path, String title, String content){
        final String EXTENSION = ".txt";
        Path pathFinal;
        if (path.isBlank()) {
            throw new IllegalArgumentException("La ruta proporcionada no puede estar vacia!");
        }
        
        pathFinal = Path.of(path, (title.concat(EXTENSION)));
        
        try {
            File archivoTXT = new File(pathFinal.toString());
            archivoTXT.createNewFile();
            
            try (BufferedWriter txtBW = new BufferedWriter(new FileWriter(archivoTXT))) {
                txtBW.write(content);
            } catch (Exception e) {
                System.err.println("No se pudo en escribir en: \""+pathFinal.toString()+"\", lo siguiente: \n\""
                        + content+"\"");
            }
        } catch (IOException e) {
            System.err.println(
                    "No se pudo crear el documento de texto en: \""+pathFinal.toString()+"\"");
        }
    }
    
    
    public static void crearCarpetas(String path){
        throw new UnsupportedOperationException("Aun no programada! :3");
    }
    
    public static void verificarCarpetas(){
        throw new UnsupportedOperationException("Aun no programada! :3");
    }
    
    /**
     * Metodo para verificar si es string es valido para el titulo de un archivo
     * revisando que no tenga ninguno de los siguientes caracteres: /\|:*?"<>
     * @param str El string
     * @return booleano true si esta bien
     */
    public static boolean isGoodStringForFile(String str){
        return (!str.isBlank() || str.matches(".*[/\\|:*?\"<>].*"));
    }
}
