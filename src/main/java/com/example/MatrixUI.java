package com.example;

import javax.swing.*;
import java.awt.*;

public class MatrixUI extends JFrame {

    private JTextField[][] matrix1;
    private JTextField[][] matrix2;

    public MatrixUI() {
        setLayout(new BorderLayout());

        // Create top label and panel
        JLabel topLabel = new JLabel("Matrix Operations");
        add(topLabel, BorderLayout.NORTH);

        // Create middle panel with matrices
        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new GridLayout(2, 1));
        add(middlePanel, BorderLayout.CENTER);

        // Create matrix labels and text fields
        JLabel matrixLabel1 = new JLabel("Matrix 1:");
        middlePanel.add(matrixLabel1);
        matrix1 = createTextFieldArray(2, 2);
        JPanel matrixPanel1 = new JPanel();
        matrixPanel1.setLayout(new GridLayout(2, 2));
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrixPanel1.add(matrix1[i][j]);
            }
        }
        middlePanel.add(matrixPanel1);

        JLabel matrixLabel2 = new JLabel("Matrix 2:");
        middlePanel.add(matrixLabel2);
        matrix2 = createTextFieldArray(2, 2);
        JPanel matrixPanel2 = new JPanel();
        matrixPanel2.setLayout(new GridLayout(2, 2));
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrixPanel2.add(matrix2[i][j]);
            }
        }
        middlePanel.add(matrixPanel2);

        // Create bottom panel
        JPanel bottomPanel = new JPanel();
        add(bottomPanel, BorderLayout.SOUTH);

        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JTextField[][] createTextFieldArray(int rows, int cols) {
        JTextField[][] matrix = new JTextField[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = new JTextField(5);
            }
        }
        return matrix;
    }


}
