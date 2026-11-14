/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejsuescun.killsoundgenerator.controlador;

import com.alejsuescun.killsoundgenerator.modelo.ConsoleTextAreaOutputStream;
import com.alejsuescun.killsoundgenerator.vista.*;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;


/**
 * Clase Principal del programa
 * @author alejSuescun
 */
public class Main {
    private static VentanaPrincipal ventanaPrincipal;
    
    public static void main(String[] args) {
        ventanaPrincipal = new VentanaPrincipal();
        setSystemOut();
        
        System.out.println("Test");
        System.out.print("Test2");
        System.err.println("Test de error");
        System.out.print("Test3");
        System.out.print("Test4");
        for (int i = 5; i < 1000; i++) {
            System.out.println("test: "+i);
        }
    }
    
    /**
     * Metodo para poner el systemOut como la consola de la GUI
     */
    public static void setSystemOut(){
        PrintStream consolaJframe = new PrintStream(new ConsoleTextAreaOutputStream(
                ventanaPrincipal.getTxtAreaConsola()), true, StandardCharsets.UTF_8);
        System.setOut(consolaJframe);
        System.setErr(consolaJframe);
    }
}
