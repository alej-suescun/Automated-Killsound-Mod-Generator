/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejsuescun.killsoundgenerator.vista;

import com.alejsuescun.killsoundgenerator.modelo.Version;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Clase de la ventana de propiedades
 * @author alejSuescun
 */
public class VentanaPropiedades extends JDialog{
    private JCheckBox checkForMvM, checkForMoverArchivos, checkForCreditsSoundscript;
    
    public VentanaPropiedades(VentanaPrincipal ventanaPrincipal) {
        super(ventanaPrincipal,("Propiedades"), true);

        setSize(480, 480);
        setLocationRelativeTo(ventanaPrincipal);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(16, 8, 8, 8); // Padding (t, l, d, r)
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 10;
        gbc.anchor = GridBagConstraints.PAGE_START;
        add(crearPanelAjustes(), gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(8, 8, 2, 8);
        gbc.anchor = GridBagConstraints.PAGE_END;
        add(crearPanelCreditos(), gbc);
        setVisible(true);
    }
    
    /**
     * Metodo para agregar un action listener al checkbox de compatibilidad con mann vs machine
     * @param l 
     */
    public void setCheckForMvMListener(ActionListener l){
        checkForMvM.addActionListener(l);
    }
    
    /**
     * Metodo para agregar un action listener al checkbox de mover los archivos en vez de copiar y pegar
     * @param l 
     */
    public void setCheckForMoverArchivosListener(ActionListener l){
        checkForMoverArchivos.addActionListener(l);
    }
    
    /**
     * Metodo para agregar un action listener al checkbox de dejar creditos en el soundscript
     * @param l 
     */
    public void setCheckForCreditsSoundscriptListener(ActionListener l){
        checkForCreditsSoundscript.addActionListener(l);
    }
    
    /**
     * Metodo que crea el panel de los ajustes
     * @return 
     */
    private JPanel crearPanelAjustes(){
        JPanel panelAjustes = new JPanel();
        panelAjustes.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.PAGE_START;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelAjustes.add(new JLabel("Compatibilidad con Mann vs Machine: "), gbc);
        gbc.gridx = 1;
        panelAjustes.add(crearCheckForMvM(), gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelAjustes.add(new JLabel("Mover en vez de copiar y pegar los archivos: "), gbc);
        gbc.gridx = 1;
        panelAjustes.add(crearCheckForMoverArchivos(), gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelAjustes.add(new JLabel("Dejar creditos en soundscript: "), gbc);
        gbc.gridx = 1;
        panelAjustes.add(crearCheckForCreditsSoundscript(), gbc);
        
        return panelAjustes;
    }
    
    /**
     * Metodo que crea el panel de los creditos
     * @return 
     */
    private JPanel crearPanelCreditos(){
        JPanel panelAjustes = new JPanel();
        
        panelAjustes.add(new JLabel("<html> "
                + "Automated Killsound Mod Generator. Version: "+Version.VERSION_PROYECTO+"<br>"
                + "Desarrollado por Alejandro \"ASD++\" Suescún <br>"
                + "2026. *Licencia q no he pensado cual*"
                + "</html>"));
        
        return panelAjustes;
    }
    
    /**
     * Crea el checkbox de compatibilidad con mann vs machine
     * @return 
     */
    private JCheckBox crearCheckForMvM(){
        checkForMvM = new JCheckBox();
        checkForMvM.setSelected(true);
        return checkForMvM;
    }
    
    /**
     * Crea el checkbox de mover en vez de copiar y pegar los archivos
     * @return 
     */
    private JCheckBox crearCheckForMoverArchivos(){
        checkForMoverArchivos = new JCheckBox();
        checkForMoverArchivos.setSelected(false);
        return checkForMoverArchivos;
    }
    
    /**
     * Crea el checkbox para los creditos en el soundscript
     * @return 
     */
    private JCheckBox crearCheckForCreditsSoundscript(){
        checkForCreditsSoundscript = new JCheckBox();
        checkForCreditsSoundscript.setSelected(true);
        return checkForCreditsSoundscript;
    }
}
