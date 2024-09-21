package com.example;

import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;


public class MatrixButtonListener implements ActionListener {
    JLabel resultLabel;
    ArrayList<JTextField> textFieldList;

    public MatrixButtonListener(ArrayList<JTextField> textFieldList, JLabel resultLabel) {
        this.textFieldList = textFieldList;
        this.resultLabel = resultLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(JTextField field : textFieldList){
            Matrix matrixa = new Matrix(new double[][]{
                {
                    Double.parseDouble(textFieldList.get(0).getText()),
                    Double.parseDouble(textFieldList.get(1).getText()),
                },
                {

                    Double.parseDouble(textFieldList.get(2).getText()),
                    Double.parseDouble(textFieldList.get(3).getText()),
                }
            });

            Matrix matrixb = new Matrix(new double[][]{
                {
                    Double.parseDouble(textFieldList.get(4).getText()),
                    Double.parseDouble(textFieldList.get(5).getText()),
                },
                {

                    Double.parseDouble(textFieldList.get(6).getText()),
                    Double.parseDouble(textFieldList.get(7).getText()),
                }
            });
            
            Matrix matrixc = matrixa.add(matrixb);

            resultLabel.setText(matrixc.print());
        }
    }
}