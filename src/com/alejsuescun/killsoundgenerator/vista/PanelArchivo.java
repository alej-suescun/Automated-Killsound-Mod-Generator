/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejsuescun.killsoundgenerator.vista;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Clase con que muestra la informacion de un killsound siendo nombre, ruta y fecha
 * @author alejSuescun
 */
public class PanelArchivo extends JPanel {
    private JCheckBox btnCheckSelec;
    private JLabel labelNombre, labelRuta, labelFecha;
    
    public PanelArchivo(String nombre, String ruta, String fecha) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(4, 8, 4, 8); 
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 3;
        gbc.weighty = 1;
        add(crearLabelNombre(nombre), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        add(crearLabelRuta(ruta), gbc);
        gbc.gridx = 2;
        add(crearLabelFecha(fecha), gbc);
        gbc.gridx = 3;
        add(crearBtnCheckSelec(), gbc);
    }

    /**
     * Metodo para obeterner el nombre del archivo del label
     * @return String con el nombre
     */
    public String getNombre(){
        return labelNombre.getText();
    }
    
    /**
     * Metodo para obeterner la ruta del archivo del label
     * @return String con el nombre
     */
    public String getRuta(){
        return labelRuta.getText();
    }
    
    /**
     * Metodo para obeterner la fecha del archivo del label
     * @return String con el nombre
     */
    public String getFecha(){
        return labelFecha.getText();
    }
    
    public boolean getStatus(){
        return btnCheckSelec.isSelected();
    }
    
    /**
     * Metodo para poner el nombre del archivo en el label
     * @param nombre String
     */
    public void setNombre(String nombre){
        labelNombre.setText(nombre);
    }
    
    /**
     * Metodo para poner la ruta del archivo en el label
     * @param ruta 
     */
    public void setRuta(String ruta){
        labelRuta.setText(ruta);
    }
    
    /**
     * Metodo para poner la fecha del archivo en el label
     * @param fecha 
     */
    public void setFecha(String fecha){
        labelFecha.setText(fecha);
    }
    
    /**
     * Metodo para poner un status si selecionado o no al archivo
     * @param sn
     */
    public void setStatus(Boolean sn){
        btnCheckSelec.setSelected(sn);
        btnCheckSelec.revalidate();
        btnCheckSelec.repaint();
    }
    
    /**
     * Metodo para agregar un action listener al boton de si esta seleccionado
     * @param l 
     */
    public void setBtnCheckSelecListener(ActionListener l){
        btnCheckSelec.addActionListener(l);
    }
    
    /**
     * Metodo para crear el label del nombre
     * @param nombre String con el nombre
     * @return el label
     */
    private JLabel crearLabelNombre(String nombre){
        labelNombre = new JLabel(nombre);
        
        return labelNombre;
    }
    
    /**
     * Metodo para crear el label de la ruta
     * @param nombre String con la ruta
     * @return el label
     */
    private JLabel crearLabelRuta(String ruta){
        labelRuta = new JLabel(ruta);
        
        return labelRuta;
    }
    
    /**
     * Metodo para crear el label de la fecha
     * @param nombre String con la fecha
     * @return el label
     */
    private JLabel crearLabelFecha(String fecha){
        labelFecha = new JLabel(fecha);
        
        return labelFecha;
    }
    
    /**
     * Metodo para crear la casilla para selecionarlo
     * @return el  jchekcbox
     */
    private JCheckBox crearBtnCheckSelec(){
        btnCheckSelec = new JCheckBox();
        
        return btnCheckSelec;
    }
}
