/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejsuescun.killsoundgenerator.modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Clase con varios metodos estaticos para trabajar con archivos y carpetas
 * usa java.io y java.nio
 * @author alejSuescun
 */
public class ArchivosManager {

    /**
     * Metodo para generar un archivo txt basico sin UFT_8
     * @param path String que direccione a donde se quiere crear el archivo
     * @param title String con el titulo del archivo (Sin el .txt)
     * @param content String con el contenido del TXT
     */
    public static void crearArchivoTXT(String path, String title, String content) throws IllegalArgumentException{
        final String EXTENSION = ".txt";
        Path pathFinal;
        if (path.isBlank()) {
            throw new IllegalArgumentException("La ruta proporcionada no puede estar vacia!");
        }
        
        if (!isGoodStringForFile(path)) {
            throw new IllegalArgumentException("El titulo no puede estar vacio o no cumple los requisitos!");
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
    
    /**
     * Metodo para crear carpetas
     * @param pathBase Stromg con la direccion base de donde quiere crear las carpetas
     * @param nombreCarpetasArray
     * @throws java.io.FileNotFoundException
     */
    public static void crearCarpetas(String pathBase, String[] nombreCarpetasArray) throws IllegalArgumentException, FileNotFoundException{
        if (pathBase.isBlank()) {
            throw new IllegalArgumentException("La ruta no puede estar vacia!");            
        }
        
        if (!verificarCarpetas(pathBase)) {
            throw new FileNotFoundException("La ruta base no existe!"); // No encontre de directorio cff
        }
        
        if (nombreCarpetasArray.length == 0) {
            throw new IllegalArgumentException("No se proporciono ninguna carpeta nueva!");
        }
        
        String[] nombreCarpetasArrayCorregido = new String[nombreCarpetasArray.length];
        for (int i = 0; i < nombreCarpetasArray.length-1; i++) {
            String nombreCarpeta = nombreCarpetasArray[i];
            if (isGoodStringForFile(nombreCarpeta)) {
                nombreCarpetasArrayCorregido[i] = nombreCarpeta;
            } else {
                System.err.println("El nombre \""+nombreCarpeta+"\" no es valido para una carpeta!");
            }
        }

        Path pathCarpetas = Path.of(nombreCarpetasArrayCorregido[0], Arrays.copyOfRange(nombreCarpetasArray, 1, nombreCarpetasArray.length));
        Path pathFull = Path.of(pathBase, pathCarpetas.toString());
        File carpetas = new File(pathFull.toString());
        if (carpetas.mkdirs()) {
            System.out.println("Se crearon las carpetas: \""+pathCarpetas.toString()+"\" en: \""+
                    pathBase+"\"");
        }
    }
    
    /**
     * Metodo para verficar que existan carpetas usando Files.exists
     * @param path String con la direccion de las carpetas
     * @return booleano true si hay carpetas
     */
    public static boolean verificarCarpetas(String path) throws IllegalArgumentException{
        if (path.isBlank()) {
            throw new IllegalArgumentException("La ruta no puede estar vacia!");
        }
        
        try {
            Path pathCarpeta = Paths.get(path);
            return Files.exists(pathCarpeta) && Files.isDirectory(pathCarpeta);
        } catch (Exception e) {
            System.err.println("Ocurrio un error inesperado a la hora de verificar: \""+path+
                    "\"");
            return false;
        }
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
