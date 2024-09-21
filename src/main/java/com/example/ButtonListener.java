package com.example;

import java.awt.event.*;
import java.awt.GridBagConstraints;

import javax.swing.JTextField;
import javax.swing.JPanel;
import java.util.List;
import java.util.ArrayList;

public class ButtonListener implements ActionListener {
    JTextField sizeTextField;
    GridBagConstraints gbc;
    JPanel panel;
    CuadroMagico cuadroMagico;

    public ButtonListener(JTextField sizeTextField, GridBagConstraints gbc, JPanel panel, CuadroMagico cuadroMagico) {
        this.sizeTextField = sizeTextField;
        this.gbc = gbc;
        this.panel = panel;
        this.cuadroMagico = cuadroMagico;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int size = Integer.parseInt(sizeTextField.getText());
        cuadroMagico.setup(Integer.parseInt(sizeTextField.getText()));
        
        for (int row = 1; row < size + 1; row++) {
            List<JTextField> textFieldsRow = new ArrayList<>();
            for (int col = 0; col < size; col++) {
                JTextField textField = new JTextField(10);
                gbc.gridx = col;
                gbc.gridy = row;
                textFieldsRow.add(textField);
                panel.add(textField, gbc);
                panel.updateUI();
            }
            cuadroMagico.matrixOfTextFields.add(textFieldsRow);
        }

        System.out.println("Button was clicked!");
    }
}