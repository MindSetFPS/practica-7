package com.example;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class CuadroMagico {
    // 1. Obtener el tamaño del cuadro
    // 2. Rellenar el recuadro
    // 3. Comprobar suma magica
    // 4. Numero magico

    public int size;
    public List<List<JTextField>> matrixOfTextFields = new ArrayList<>();
    public int magicNumber;

    public CuadroMagico() {
    }
    
    public CuadroMagico setup(int size){
        this.size = size;
        return this;
    }

    public void renderSquare() {
    }

    public boolean verifySum() {
        List<Integer> sumList = new ArrayList<>();

        // Verify row
        for ( int row = 0; row < size; row++ ) {
            // You can access each JTextField here, e.g.,:
            int rowSum = 0;
            for (JTextField textField : matrixOfTextFields.get(row)) {
                rowSum = rowSum + Integer.parseInt(textField.getText());
            }
            sumList.add(rowSum);
            System.out.println("Row sum = " + rowSum);
        }

        // Verify columns
        int columns = matrixOfTextFields.get(0).size();
        for (int column = 0; column < columns; column++) {
            int rows = matrixOfTextFields.size();
            int colSum = 0;
            for (int row = 0; row < rows; row++) {
                colSum = colSum + Integer.parseInt(matrixOfTextFields.get(row).get(column).getText());
            }
            sumList.add(colSum);
            System.out.println("cols sum =" + colSum );
        }

        // Verify diagnonal left to right
        int leftToRightSum = 0;
        for (int row = 0; row < columns; row++) {
            for (int column = 0; column < columns; column++) {
                if (row == column)
                    leftToRightSum = leftToRightSum
                            + Integer.parseInt(matrixOfTextFields.get(row).get(column).getText());
            }
        }
        System.out.println("left to right sum = " + leftToRightSum);
        sumList.add(leftToRightSum);

        int rightToLeftSum = 0;
        for (int i = 0; i < matrixOfTextFields.size(); i++) {
            int j = columns - i - 1;
            rightToLeftSum = rightToLeftSum + Integer.parseInt(matrixOfTextFields.get(i).get(j).getText());
        }
        System.out.println("suma antidiagonal" + rightToLeftSum);
        sumList.add(rightToLeftSum);
        
        System.out.println(sumList);
        System.out.println("All are the same?" + checkIfAllElementsAreSame(sumList));
        if(checkIfAllElementsAreSame(sumList)){
            magicNumber = sumList.get(0);
        }
        
        return checkIfAllElementsAreSame(sumList);
    }

    public void getMagicNumber() {
    }
    
    public static boolean checkIfAllElementsAreSame(List<Integer> list) {
        if (list.isEmpty()) {
            return true;  // or throw an exception
        }
    
        int firstElement = list.get(0);
        for (Integer element : list) {
            System.out.println(element + "==" + firstElement);
            if (element != firstElement) {
                return false;
            }
        }
        return true;
    }    
}
