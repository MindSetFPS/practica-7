package com.example;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

public class NumberValidator extends KeyAdapter{
    public JTextField inputField;

    public NumberValidator(JTextField inputField){
        this.inputField = inputField;
    }

    @Override
    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            inputField.setEditable(true);
        } else {
            String allowedCharacters = "1234567890.";
            if (allowedCharacters.indexOf(event.getKeyChar()) != -1) {
                inputField.setEditable(true);
            } else {
                inputField.setEditable(false);
            }
        }
    }
}