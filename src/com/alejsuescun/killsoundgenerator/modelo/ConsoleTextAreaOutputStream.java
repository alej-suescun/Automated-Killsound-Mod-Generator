/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejsuescun.killsoundgenerator.modelo;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 * Clase que es un streamOutput para poder imprimir los system.out.prinln y system.err.println en la GUI
 * @author alejSuescun
 */
public class ConsoleTextAreaOutputStream extends OutputStream{
    private final JTextArea TXT_AREA_CONSOLE;

    public ConsoleTextAreaOutputStream(JTextArea TXT_AREA_CONSOLE) {
        this.TXT_AREA_CONSOLE = TXT_AREA_CONSOLE;
    }
    
    /**
     * Metodo para escribir en la consola añadiendo uno tras otro desde un entero
     * @param b entero
     * @throws IOException 
     */
    @Override
    public void write(int b) throws IOException {
        write(new byte[]{(byte) b}, 0, 1);
    }
    
    /**
     * Metodo para escribir en la consola añadiendo uno tras otro
     * (Pide los parametros para crear un string desde bytes)
     * @param b The bytes to be decoded into characters (Sacado de String)
     * @param off The index of the first byte to decode (Sacado de String)
     * @param len The number of bytes to decode (Sacado de String)
     * @throws IOException 
     */
    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        String txt = new String(b, off, len, StandardCharsets.UTF_8);
        
        // Pasarlo a Swing de manera segura para evitar errores o congelamientos
        // debido q Swing NO es thread safe
        SwingUtilities.invokeLater(() -> { 
            TXT_AREA_CONSOLE.append(txt);
            TXT_AREA_CONSOLE.setCaretPosition(TXT_AREA_CONSOLE.getDocument().getLength()); //Moverlo a abajo cuando haya una nueva linea
        });
    }
    
    
}
