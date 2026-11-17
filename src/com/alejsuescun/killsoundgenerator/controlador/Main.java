/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejsuescun.killsoundgenerator.controlador;

import com.alejsuescun.killsoundgenerator.vista.VentanaPrincipal;
import javax.swing.SwingUtilities;


/**
 * Clase Principal del programa
 * @author alejSuescun
 */
public class Main {    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { 
            VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
            VentanaPrincipalControlador ventanaPrincipalControlador = new VentanaPrincipalControlador(ventanaPrincipal);

            ventanaPrincipalControlador.printMensajePrincipio();
        });

    }
}
