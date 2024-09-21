package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SwitchUI extends JFrame {

    JTabbedPane tabPanel = new JTabbedPane();

    public SwitchUI() {
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the first tab (page1) and add a JLabel to it
        JPanel page1 = new JPanel();
        page1.add(new JLabel("Arreglo de números"));

        // Create the second tab (page2) and add a JLabel to it
        JPanel page2 = new JPanel();
        page2.add(new JLabel("Cuadro Mágico"));

        // Create the third tab (page3) and add a JLabel to it
        JPanel page3 = new JPanel();
        page3.add(new JLabel("Calculadora de Matrices"));

        // Add the three tabs to the JTabbedPane
        // tabPanel.addTab("Práctica 7", page1);
        // tabPanel.addTab("Práctica 8", page2);
        // tabPanel.addTab("Práctica 9", page3);

        // Add the JTabbedPane to the JFrame's content
        add(tabPanel);

        setSize(400, 300);
        setVisible(true);
    }
    
    public void addArrayCounter(){
        JPanel panel = new JPanel();
        ArrayCounter arrayCounter = new ArrayCounter();
        panel.add(new JLabel(arrayCounter.getClass().getSimpleName()));
        panel.add(new JLabel(arrayCounter.getArrayAsString()));
        JLabel answer = new JLabel("");
        JButton button = new JButton("Hola");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                answer.setText(arrayCounter.getNumberOfZeros());
            }
        });
        panel.add(button);
        panel.add(answer);
        tabPanel.addTab(arrayCounter.name, panel);
    }
    
    public void addCuadroMagico(int size){
        
        CuadroMagico cuadroMagico = new CuadroMagico();

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        JLabel label = new JLabel("Tamaño del cuadro");
        JTextField sizeTextField = new JTextField(10);
        sizeTextField.addKeyListener(new NumberValidator(sizeTextField));
        
        JButton button = new JButton("Crear cuadro");
        button.addActionListener(new ButtonListener(sizeTextField, gbc, panel, cuadroMagico));

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(label, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;

        panel.add(sizeTextField);
        panel.add(button);

        JLabel isMagicSquareLabel = new JLabel("Es un cuadro magico?");
        gbc.gridx = 1;
        gbc.gridy = 6;
        panel.add(isMagicSquareLabel, gbc);
        
        JButton validateButton = new JButton("Validar cuadro magico");
        validateButton.addActionListener(new ValidateButtonListener(cuadroMagico, isMagicSquareLabel));
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        
        panel.add(validateButton, gbc);

        // CuadroMagico cuadroMagico = new CuadroMagico()
        tabPanel.addTab("Cuadro Magico", panel);
    }
}