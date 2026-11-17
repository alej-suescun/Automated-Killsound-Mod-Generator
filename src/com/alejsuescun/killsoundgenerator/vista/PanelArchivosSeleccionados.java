/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejsuescun.killsoundgenerator.vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Panel que tiene los archivos seleccionados
 * @author alejSuescun
 */
public class PanelArchivosSeleccionados extends JPanel{
    public static final String[] NOMBRES_TIPOS_ORGANIZAR = {"Nombre", "Fecha"};
    private JButton btnBorrarArchivos;
    private JComboBox<String> btnComboOrganizar;
    private JPanel panelArchivos;
    
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
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 10;
        add(crearScrollPanelArchivos(), gbc);
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
     * Metodo para añadir un archivo al panel de archivos
     * @param nombre String con el nombre
     * @param ruta String con la ruta
     * @param fecha String con la fecha
     */
    public void addArchivo(String nombre, String ruta, String fecha){
        panelArchivos.add(new PanelArchivo(nombre, ruta, fecha));
        panelArchivos.revalidate();
        panelArchivos.repaint();
    }
    
    /**
     * Borra un archivo de la gui proporcionando una ruta
     * @param ruta 
     */
    public void borrarArchivo(String ruta){
        ArrayList<PanelArchivo> archivos = getArchivos();
        
        if (archivos == null) {
            return;
        }
        
        for (PanelArchivo archivo : archivos) {
            if (archivo.getRuta().equals(ruta)) {
                panelArchivos.remove(archivo);
            }
        }
    }
    
    /**
     * Borra todos los archivos
     */
    public void borrarArchivos(){
        panelArchivos.removeAll();
        panelArchivos.revalidate();
        panelArchivos.repaint();
    }
    
    /**
     * Retorna una arrayList con todos los archivos que estan en la GUI
     * @return arraylist con los PanelArchivo, si no hay ninguno null
     */
    public ArrayList<PanelArchivo> getArchivos(){
        ArrayList<PanelArchivo> archivos = new ArrayList<>(1);
        try {
            Component[] componentesPanel = panelArchivos.getComponents();

            for (Component component : componentesPanel) {
                if (component instanceof PanelArchivo archivo) {
                   archivos.add(archivo);
                }
            }
            return archivos;
        } catch (ArrayIndexOutOfBoundsException e) {
            return null; // No tenia ningun archivo
        }
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
     * Crea el panel que contiene los archivos
     * @return 
     */
    private JPanel crearPanelArchivos(){
        panelArchivos = new JPanel();
        panelArchivos.setLayout(new BoxLayout(panelArchivos, BoxLayout.Y_AXIS));
        
        return panelArchivos;
    }
    
    private JScrollPane crearScrollPanelArchivos(){
        JScrollPane pane = new JScrollPane(crearPanelArchivos());
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pane.setPreferredSize(new Dimension(400, 300));
        pane.getVerticalScrollBar().setUnitIncrement(16);
        return pane;
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
