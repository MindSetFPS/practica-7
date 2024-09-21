package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
        tabPanel.addTab("Cuadro Magico", panel);
    }
    
    public void addMatrixCalculator(){
        JPanel matrixPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel label = new JLabel("Ejercicio 9");
        
        ArrayList<JTextField> textFieldList = new ArrayList<>();

        JTextField a1 = new JTextField(8);
        textFieldList.add(a1);
        
        JTextField a2 = new JTextField(8);
        textFieldList.add(a2);

        JTextField a3 = new JTextField(8);
        textFieldList.add(a3);

        JTextField a4 = new JTextField(8);
        textFieldList.add(a4);

        JTextField b1 = new JTextField(8);
        textFieldList.add(b1);
        
        JTextField b2 = new JTextField(8);
        textFieldList.add(b2);
        
        JTextField b3 = new JTextField(8);
        textFieldList.add(b3);
        
        JTextField b4 = new JTextField(8);
        textFieldList.add(b4);
        
        gbc.gridx = 0;
        gbc.gridy = 0;

        matrixPanel.add(label, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        matrixPanel.add(a1, gbc);
        gbc.gridx = 1;
        matrixPanel.add(a2, gbc);
        gbc.gridx = 2;
        matrixPanel.add(a3, gbc);
        gbc.gridx = 3;
        matrixPanel.add(a4, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        
        matrixPanel.add(b1, gbc);
        
        gbc.gridx = 1;
        matrixPanel.add(b2, gbc);
        gbc.gridx = 2;
        matrixPanel.add(b3, gbc);
        gbc.gridx = 3;
        matrixPanel.add(b4, gbc);
        
        JLabel resultLabel = new JLabel();
        gbc.gridy = 4;
        gbc.gridx = 0;
        matrixPanel.add(resultLabel, gbc);
        
        gbc.gridy = 3;
        gbc.gridx = 0;

        JButton runButton = new JButton("Calcular");
        runButton.addActionListener(new MatrixButtonListener(textFieldList, resultLabel));
        matrixPanel.add(runButton, gbc);
        
        tabPanel.addTab("Ejercicio 9", matrixPanel);
    }
    
    public void addMatrixDiagonal(){

        tabPanel.addTab("Ejercicio 10", rootPane);
    }
}