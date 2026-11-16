/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejsuescun.killsoundgenerator.vista;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Clase que es  la Ventana para la gestion de los archivos del mod
 * @author alejSuescun
 */
public class VentanaArchivo extends JDialog{
    JButton btnSelecArchivos, btnSelecFolder;
    
    public VentanaArchivo(VentanaPrincipal ventanaPrincipal) {
        super(ventanaPrincipal, "Gestion de archivos", true);

        setSize(480, 480);
        setLocationRelativeTo(ventanaPrincipal);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.PAGE_START;
        add(crearPanelBtnsAgregar(), gbc);
        
        gbc.gridy = 1;
        gbc.weighty = 10;
        add(crearPanelArchivosSelecionados(), gbc);
        
        setVisible(true);
    }
    
    /**
     * Metodo para agregar un action listener al boton de seleccionar archvios
     * @param l 
     */
    public void setBtnSelecArchivosListener(ActionListener l){
        btnSelecArchivos.addActionListener(l);
    }
    
    /**
     * Metodo para agregar un action listener al boton de seleccionar por carpeta
     * @param l 
     */
    public void setBtnSelecFolderListener(ActionListener l){
        btnSelecFolder.addActionListener(l);
    }
    
    /**
     * Crea el panel que tiene los dos botones de seleccionar por archivos y por carpeta
     * @return 
     */
    private JPanel crearPanelBtnsAgregar(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(8, 8, 8, 8);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        panel.add(crearBtnSelecArchivos(), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        panel.add(crearBtnSelecFolder(), gbc);
        
        return panel;
    }
    
    /**
     * Metodo para crear el panel q tiene los archivos seleccionados
     * @return 
     */
    private JPanel crearPanelArchivosSelecionados(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        panel.add(new JLabel("Archivos Seleccionados"), gbc);
        gbc.gridy = 1;
        gbc.weighty = 10;
        panel.add(new PanelArchivosSeleccionados(), gbc);
        return panel;
    }
    
    /**
     * Boton que es para seleccionar los archivos
     * @return 
     */
    private JButton crearBtnSelecArchivos(){
        btnSelecArchivos = new JButton("Seleccionar más");
        
        return btnSelecArchivos;
    }
    
    /**
     * Boton para seleccionar por carpeta
     * @return 
     */
    private JButton crearBtnSelecFolder(){
        btnSelecFolder = new JButton("Seleccionar por carpeta");
        
        return btnSelecFolder;
    }
}
