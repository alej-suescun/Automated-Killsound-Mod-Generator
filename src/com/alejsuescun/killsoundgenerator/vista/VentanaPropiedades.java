/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejsuescun.killsoundgenerator.vista;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;

/**
 *
 * @author alejSuescun
 */
public class VentanaPropiedades extends JDialog{

    public VentanaPropiedades(VentanaPrincipal ventanaPrincipal) {
        super(ventanaPrincipal,("Propiedades"), true);

        setSize(480, 480);
        setLocationRelativeTo(ventanaPrincipal);
        setVisible(true);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
    }
    
}
