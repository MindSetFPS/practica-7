package com.example;

public class Matrix {
    // Elabora un programa en el lenguaje seleccionado, para crear una aplicación
    // que lea dos arreglos de
    // tamaño 2 x 2, llena ambas matrices y calcula lo siguiente:
    // a) La suma de las matrices
    // b) La resta de los elementos de la primera matriz menos la segunda
    // c) El producto simple de los valores de la matriz
    // d) La división simple de los valores de la matriz

    // Sea Matriz 1 Sea Matriz 2
    // 10 5 2 4
    // 8 2 6 8

    // La suma es: La resta es:
    // 12 9 8 1
    // 14 10 2 -6

    // El producto es: La división es:
    // 20 20 5 1.25
    // 48 16 1.33 .25

    double[][] data;

    public Matrix(double[][] data) {
        this.data = new double[2][2];
        for (int i = 0; i < 2; i++) {
            System.arraycopy(data[i], 0, this.data[i], 0, 2);
        }
    }

    // Print the matrix
    public String print() {
        String message =  "";
        for (double[] row : data) {
            for (double element : row) {
                message = message + element + " ";
                System.out.print(element + " ");
            }
            System.out.println();
        }
        System.out.println();
        return message;
    }

    // Add two matrices
    public Matrix add(Matrix other) {
        double[][] result = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                result[i][j] = data[i][j] + other.data[i][j];
            }
        }
        return new Matrix(result);
    }

    // Subtract two matrices
    public Matrix subtract(Matrix other) {
        double[][] result = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                result[i][j] = data[i][j] - other.data[i][j];
            }
        }
        return new Matrix(result);
    }

    // Multiply two matrices
    public Matrix multiply(Matrix other) {
        double[][] result = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    result[i][j] += data[i][k] * other.data[k][j];
                }
            }
        }
        return new Matrix(result);
    }

    // Divide two matrices
    public Matrix divide(Matrix other) {
        double[][] result = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (other.data[i][j] == 0)
                    throw new ArithmeticException("Cannot divide by zero!");
                result[i][j] = data[i][j] / other.data[i][j];
            }
        }
        return new Matrix(result);
    }

    // Get the value at a specific position
    public double get(int i, int j) {
        return data[i][j];
    }
}
