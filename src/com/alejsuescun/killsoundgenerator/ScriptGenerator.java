/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejsuescun.killsoundgenerator;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author suesc
 */
public class ScriptGenerator {
    public int nkillsounds;
    public String nombreMod;

    public ScriptGenerator(int nkillsounds, String nombreMod) {
        this.nkillsounds = nkillsounds;
        this.nombreMod = nombreMod;
    }
    
    // Metodo para generar el soundscript
    // Bool para crear la version de mann vs machine (MvM)
    public void generate(boolean isMvM){
        File documentsUser = FileSystemView.getFileSystemView().getDefaultDirectory();
        String pathScripts = "\\scripts\\";
        String pathArchivo = documentsUser.getPath().concat("\\"+nombreMod);
        pathArchivo = pathArchivo.concat(pathScripts);
        
        // crear primero el directorio
        // por ahora se creara en los documentos del usuario (Linea de File documentsUser)
        try {
            Path path = Paths.get(pathArchivo);
            Files.createDirectories(path);
            System.out.println("Se creo la carpeta scripts en: "+path);
        } catch (IOException e) {
            System.out.println("No se pudo crear la carpeta de scripts en: "+pathArchivo);
            e.printStackTrace();
        }
        
        // ahora crear el archivo
        pathArchivo = pathArchivo.concat(isMvM ? "mvm_level_sounds.txt" : "game_sounds_weapons.txt");
        
        try {
            File archivo = new File(pathArchivo);
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado correctamente en: "+pathArchivo);
            } else {
                System.out.println("El archivo ya existe!");
            }
            
            // Ahora escribir los datos
            FileWriter escritor = new FileWriter(archivo);
            
            // COMENTARIO
            escritor.write("// ARCHIVO GENERADO AUTOMATICAMENTE");
            escritor.write("\n// SCRIPT: https://github.com/alej-suescun/Automated-Killsound-Mod-Generator");
            escritor.write("\n// POR ASD++");
            
            // LO IMPORTANTE
            escritor.write("\n\"Player.KillSoundDefaultDing\"");
            escritor.write("\n{");
            escritor.write("\n	\"channel\"		\"CHAN_STATIC\"");
            escritor.write("\n	\"volume\"		\"1\"");
            escritor.write("\n	\"soundlevel\"		\"SNDLVL_NONE\"");
            escritor.write("\n	\"pitch\"		\"PITCH_NORM\"");
            escritor.write("\n	\"rndwave\"");
            
            escritor.write("\n	{");
            // LOS KILLSOUNDS
            escritor.write("\n        \"wave\" \")ui/killsound.wav\"");
            for (int i = 2; i <= nkillsounds; i++) {
                escritor.write("\n        \"wave\" \")ui/killsound"+i+".wav\"");
            }
            escritor.write("\n	}");
            escritor.write("\n}");
            
            escritor.close();
            System.out.println("Se escribio correctamente los datos");
            
        } catch (IOException e) {
            System.out.println("Sucedio un error!");
            e.printStackTrace();
        }
        

        
    }
}
