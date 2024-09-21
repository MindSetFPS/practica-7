package com.example;

import java.awt.event.*;
import javax.swing.JLabel;

public class ValidateButtonListener implements ActionListener {
    CuadroMagico cuadroMagico;
    JLabel isMagicSquareLabel;

    public ValidateButtonListener(CuadroMagico cuadroMagico, JLabel isMagicSquareLabel) {
        this.cuadroMagico = cuadroMagico;
        this.isMagicSquareLabel = isMagicSquareLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(cuadroMagico.verifySum()){
            isMagicSquareLabel.setText("Si! Es un cuadro magico! y el numero es " + cuadroMagico.magicNumber);
        };
    }
}