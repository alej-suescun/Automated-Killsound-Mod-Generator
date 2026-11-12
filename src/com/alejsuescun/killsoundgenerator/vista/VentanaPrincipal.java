/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejsuescun.killsoundgenerator.vista;

import javax.swing.*;

/**
 * Clase para controlar y crear la ventana principal del programa
 * @author suesc
 */
public class VentanaPrincipal extends JFrame{
    protected final static String TITULO_VENTANA = "AUTOMATED KILLSOUND MOD GENERATOR";
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
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setLocationRelativeTo(null); //Centrar la ventana en la pantalla
        
        
        
        add(crearPanelArriba());
        add(crearPanelAbajo());
        
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
        panelArriba.setLayout(new BoxLayout(panelArriba, BoxLayout.X_AXIS));
        
        panelArriba.add(crearPanelPropiedades());
        panelArriba.add(crearPanelBotones());
        
        return panelArriba;
    }
    
    /**
     * Panel de abajo que contiene la consola
     * @return 
     */
    private JPanel crearPanelAbajo(){
        JPanel panelAbajo = new JPanel();
        panelAbajo.setLayout(new BoxLayout(panelAbajo, BoxLayout.Y_AXIS));
        txtAreaConsole = new JTextArea(
                """
                Mostrar los system.out aqui
                
                """);
        txtAreaConsole.setEditable(false);
        
        panelAbajo.add(new JLabel("Ultimos Cambios: "));
        panelAbajo.add(txtAreaConsole);
        
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
        txtPathMod = new JTextField(); // Cambiarlo por un boton

        
        panelPropiedades.setLayout(new BoxLayout(panelPropiedades, BoxLayout.Y_AXIS)); //Acomodar verticalmente las cosas
        panelPropiedades.add(new JLabel("Nombre del mod: "));
        panelPropiedades.add(txtNombreMod);
        panelPropiedades.add(new JLabel("Ubicacion del mod: "));
        panelPropiedades.add(txtPathMod);
        
        // Poner al lado uno del otro lo de numero de killsounds
        panelNKillsounds.setLayout(new BoxLayout(panelNKillsounds, BoxLayout.X_AXIS));
        panelNKillsounds.add(new JLabel("Numero de killsounds: "));
        panelNKillsounds.add(new JLabel("0"));
        
        panelPropiedades.add(panelNKillsounds);
        
        return panelPropiedades;
    }
    
    /**
     * Panel con los botones de crear mod, gestionar archivos y cambiar propiedades
     * @return 
     */
    private JPanel crearPanelBotones(){
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        
        panelBotones.add(new JButton("Crear Mod"));
        panelBotones.add(new JButton("Gestionar Archivos"));
        panelBotones.add(new JButton("Cambiar Propiedades"));
        
        return panelBotones;
    }
    
}
