/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejsuescun.killsoundgenerator;

import java.util.Scanner;

/**
 *
 * @author suesc
 */
public class Main {
    static Scanner myKeyboard = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Por ahora portear el original aqui
        String nombreMod;
        int nKillsounds;
        System.out.println("AUTOMATED KILLSOUND MOD GENERATOR");
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
        
    }
}
