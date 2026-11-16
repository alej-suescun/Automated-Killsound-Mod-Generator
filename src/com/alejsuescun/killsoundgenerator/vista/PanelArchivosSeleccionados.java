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
 * Panel que tiene los archivos seleccionados
 * @author alejSuescun
 */
public class PanelArchivosSeleccionados extends JPanel{
    public static final String[] NOMBRES_TIPOS_ORGANIZAR = {"Nombre", "Fecha"};
    private JButton btnBorrarArchivos;
    private JComboBox<String> btnComboOrganizar;
    
    public PanelArchivosSeleccionados() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        gbc.fill = GridBagConstraints.BOTH;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.PAGE_START;
        add(crearPanelOrganizarBorrar(), gbc);
    }
    
    /**
     * Metodo para agregar un action listener al boton de borrar archivos
     * @param l 
     */
    public void setBtnBorrarArchivosListener(ActionListener l){
        btnBorrarArchivos.addActionListener(l);
    }
    
    /**
     * Metodo para agregar un action listener al boton desplegable de como organizar los archvios
     * @param l 
     */
    public void setBtnComboOrganizarListener(ActionListener l){
        btnComboOrganizar.addActionListener(l);
    }
    
    /**
     * Crea el panel que tiene los botones de organizar y borrar archivos
     * @return 
     */
    private JPanel crearPanelOrganizarBorrar(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(4, 8, 4, 8); // Padding (t, l, d, r)
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 2;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;        
        panel.add(crearSubPanelOrganizarArchivos(), gbc);
        
        gbc.gridx = 2;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        panel.add(crearBtnBorrarArchivos(), gbc);
        
        return panel;
    }
    
    /**
     * Subpanel que tiene el label y el boton desplegable de organizar los archivos
     * @return 
     */
    private JPanel crearSubPanelOrganizarArchivos(){
        JPanel subPanel = new JPanel();
        subPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        subPanel.add(new JLabel("Organizar por: "), gbc);
        
        gbc.gridx = 1;
        gbc.weightx = 1;
        subPanel.add(crearBtnComboOrganizar(), gbc);
        
        return subPanel;
    }
    
    /**
     * Configura el boton de borrar archivos
     * @return 
     */
    private JButton crearBtnBorrarArchivos(){
        btnBorrarArchivos = new JButton("Borrar");
        return btnBorrarArchivos;
    }
    
    /**
     * Configura el boton desplegable de como organizar los archivos 
     * @return 
     */
    private JComboBox<String> crearBtnComboOrganizar(){
        btnComboOrganizar = new JComboBox<>(NOMBRES_TIPOS_ORGANIZAR);
        
        return btnComboOrganizar;
    }
}
