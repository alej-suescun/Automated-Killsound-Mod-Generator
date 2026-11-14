/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejsuescun.killsoundgenerator.vista;

import com.alejsuescun.killsoundgenerator.controlador.Main;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 * Clase para controlar y crear la ventana principal del programa
 * @author suesc
 */
public class VentanaPrincipal extends JFrame{
    protected final static String TITULO_VENTANA = "AUTOMATED KILLSOUND MOD GENERATOR";
    protected final static String RESOURCE_FOLDER = "/resources/";
    protected final static String ICONS_FOLDER = (RESOURCE_FOLDER+"icons/");
    private JTextField txtNombreMod;
    private JTextField txtPathMod;
    private JTextArea txtAreaConsole;
    
    /**
     * Crear la ventana principal del programa
     */
    public VentanaPrincipal() {
        super(TITULO_VENTANA);
        setSize(854, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        setLocationRelativeTo(null); //Centrar la ventana en la pantalla
        
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(8, 16, 8, 16); // Padding (t, l, d, r)
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(crearPanelArriba(), gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 2;
        add(crearPanelAbajo(), gbc);
        
        setVisible(true);
    }
    
    /**
     * Metodo para mostrar o ocultar la ventana
     * @param sn
     */
    public void ventanaSetVisible(boolean sn){
        setVisible(sn);
    }
    
    /**
     * Metodo para obtener el texto que haya ingresado el usuario
     * en el campo de texto del nombre del mod
     * @return String con el nombre del mod
     */
    public String getTxtNombreMod(){
        return txtNombreMod.getText();
    }
        
    /**
     * Metodo para devolver la consola de la GUI
     * @return JTextArea que seria la consola de la GUI
     */
    public JTextArea getTxtAreaConsola(){
        return txtAreaConsole;
    }
    
    /**
     * Panel de la parte de arriba
     * @return 
     */
    private JPanel crearPanelArriba(){
        JPanel panelArriba = new JPanel();
        panelArriba.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(8, 8, 8, 8); // Padding (t, l, d, r)
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 15;
        gbc.weighty = 1;
        panelArriba.add(crearPanelPropiedades(), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        panelArriba.add(crearPanelBotones(), gbc);
        
        return panelArriba;
    }
    
    /**
     * Panel de abajo que contiene la consola
     * @return 
     */
    private JPanel crearPanelAbajo(){
        JPanel panelAbajo = new JPanel();
        panelAbajo.setLayout(new BoxLayout(panelAbajo, BoxLayout.Y_AXIS));
        JScrollPane consolaScroll;
        txtAreaConsole = new JTextArea("");
        
        txtAreaConsole.setEditable(false);
        
        consolaScroll = new JScrollPane(txtAreaConsole);
        consolaScroll.setAutoscrolls(true); // que se mueva solo cuando este seleccionando

        
        panelAbajo.add(new JLabel("Ultimos Cambios: "));
        panelAbajo.add(consolaScroll);
        
        return panelAbajo;
    }
    
    /**
     * Panel de propiedades con el nombre y la ruta donde se guarda el mod
     * @return 
     */
    private JPanel crearPanelPropiedades(){
        JPanel panelPropiedades = new JPanel();
        JPanel panelNKillsounds = new JPanel();
        txtNombreMod = new JTextField();

        panelPropiedades.setLayout(new BoxLayout(panelPropiedades, BoxLayout.Y_AXIS)); //Acomodar verticalmente las cosas
        panelPropiedades.add(new JLabel("Nombre del mod: "));
        panelPropiedades.add(txtNombreMod);
        panelPropiedades.add(new JLabel("Ubicacion del mod: "));

        panelPropiedades.add(crearPanelRutaMod());
        
        // Poner al lado uno del otro lo de numero de killsounds
        panelNKillsounds.setLayout(new BoxLayout(panelNKillsounds, BoxLayout.X_AXIS));
        panelNKillsounds.add(new JLabel("Numero de killsounds: "));
        panelNKillsounds.add(new JLabel("0"));
        
        panelPropiedades.add(panelNKillsounds);
        
        return panelPropiedades;
    }
    
    /**
     * Metodo para crear el panel que contiene el jTextfield y jbutton de la ruta del mod
     * @return 
     */
    private JPanel crearPanelRutaMod(){
        JPanel panelRutaMod = new JPanel();

        txtPathMod = new JTextField();
        
        panelRutaMod.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.BOTH;  // Que crezca en X e Y
        
        txtPathMod.setEditable(false);
        
        gbc.gridx = 0;
        gbc.weightx = 6; // Para que se vea mas grande el texto
        panelRutaMod.add(txtPathMod, gbc);
        
        gbc.gridx = 1;
        gbc.weightx = 1;
        panelRutaMod.add(crearBtnPathMod(), gbc);
        
        return panelRutaMod;
    }
    
    /**
     * Panel con los botones de crear mod, gestionar archivos y cambiar propiedades
     * @return 
     */
    private JPanel crearPanelBotones(){
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(4, 0, 4, 0); // Padding entre botones (t, l, d, r)
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 2;
        
        panelBotones.add(crearBtnCrearMod(), gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        panelBotones.add(crearBtnGestionarArchivos(), gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        panelBotones.add(crearBtnCambiarPropiedades(), gbc);
        
        return panelBotones;
    }
    
    /**
     * boton crear mod
     * @return 
     */
    private JButton crearBtnCrearMod(){
        JButton btnCrearMod = new JButton("Crear Mod");
        btnCrearMod.addActionListener((ActionEvent e) -> {
            Main.onBtnCrearMod();
        });
        
        return btnCrearMod;
    }
    
    /**
     * Boton gestionar archivos
     * @return 
     */
    private JButton crearBtnGestionarArchivos(){
        JButton btnGestionarArchivos = new JButton("Gestionar Archivos");
        
        btnGestionarArchivos.addActionListener((ActionEvent e)-> {
            Main.onBtnGestionarArchivos();
        });
        
        return btnGestionarArchivos;
    }
    
    /**
     * Boton cambiar propiedades
     * @return 
     */
    private JButton crearBtnCambiarPropiedades(){
        JButton btnCambiarPropiedades = new JButton("Cambiar Propiedades");
        
        btnCambiarPropiedades.addActionListener((ActionEvent e)-> {
            Main.onBtnCambiarPropiedades();
        });
        
        return btnCambiarPropiedades; 
    }
    
    private JButton crearBtnPathMod(){
        JButton btnPathMod = new JButton();
        //ImageIcon iconBtnPathMod = new ImageIcon(getClass().getResource(ICONS_FOLDER+"icon_open_external.png"));
        
        //btnPathMod.setIcon(iconBtnPathMod); poner despues para cuando empieze a decorar
        
        btnPathMod.addActionListener((ActionEvent e)-> {
            Main.onBtnPathMod();
        });
        
        return btnPathMod;
    }
}
