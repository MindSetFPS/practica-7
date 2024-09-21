package com.example;

import java.util.Scanner;

public class MatrixDiagonal {
    public static void displayMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.printf("%8.3f", value);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static double[][] gaussJordanInverse(double[][] matrix) {
        int n = matrix.length;
        double[][] augmentedMatrix = new double[n][2 * n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                augmentedMatrix[i][j] = matrix[i][j];
            }
            augmentedMatrix[i][i + n] = 1;
        }

        for (int i = 0; i < n; i++) {
            double diagValue = augmentedMatrix[i][i];
            for (int j = 0; j < 2 * n; j++) {
                augmentedMatrix[i][j] /= diagValue;
            }

            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = augmentedMatrix[k][i];
                    for (int j = 0; j < 2 * n; j++) {
                        augmentedMatrix[k][j] -= factor * augmentedMatrix[i][j];
                    }
                }
            }
        }

        double[][] inverseMatrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inverseMatrix[i][j] = augmentedMatrix[i][j + n];
            }
        }

        return inverseMatrix;
    }

    public static double[][] multiplyMatrices(double[][] a, double[][] b) {
        int n = a.length;
        double[][] result = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return result;
    }

    public static boolean isIdentityMatrix(double[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j && Math.abs(matrix[i][j] - 1) > 1e-9) {
                    return false;
                }
                if (i != j && Math.abs(matrix[i][j]) > 1e-9) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the matrix (n x n): ");
        int n = scanner.nextInt();

        double[][] matrix = new double[n][n];
        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("Original Matrix:");
        displayMatrix(matrix);

        double[][] inverseMatrix = gaussJordanInverse(matrix);
        System.out.println("Inverse Matrix:");
        displayMatrix(inverseMatrix);

        double[][] productMatrix = multiplyMatrices(matrix, inverseMatrix);
        System.out.println("Original Matrix * Inverse Matrix (Should be Identity Matrix):");
        displayMatrix(productMatrix);

        if (isIdentityMatrix(productMatrix)) {
            System.out.println("The result is an identity matrix.");
        } else {
            System.out.println("The result is NOT an identity matrix.");
        }
        scanner.close();
    }
}
