package com.example;

import java.util.List;

public class ArrayCounter {
    public String name = "Práctica 7";
    public static List<List<Integer>> matrix = List.of(
            List.of(0, 2, 5, 7, 6),
            List.of(0, 0, 0, 3, 8),
            List.of(2, 9, 6, 3, 4),
            List.of(1, 5, 6, 1, 4),
            List.of(0, 9, 2, 5, 0));

    public static int count() {
        int zeroCounter = 0;

        for (List<Integer> row : matrix) {
            for (Integer n : row) {
                if (n == 0)
                    zeroCounter++;
            }
        }
        return zeroCounter;
    }
    
    public static String getArrayAsString(){
        String text = "<html>";
         for (List<Integer> row : matrix) {
            for (Integer n : row) {
                text = text + n;
            }
            text = text + "<br>";
        }       
        return text + "<html/>";
    }

    public static String getNumberOfZeros() {
        return String.format("Hay %s zeros en el arreglo. ", count());
    }
}
