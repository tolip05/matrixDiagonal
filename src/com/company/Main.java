package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int SEQUENS_COUNT = 0;
    private static String SEQUENS_SYMBOL = "";

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        String[] dim = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dim[0]);
        int cols = Integer.parseInt(dim[1]);

        String [][] matrix = new String[rows][];

        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().split(" ");
        }
        //line
        List<String>sequence = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            sequence.addAll(Arrays.asList(matrix[i]));
            checksForSequence(sequence);
        }
        //by colone
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                sequence.add(matrix[col][row]);
            }
            checksForSequence(sequence);
        }

        int diagSize = Math.min(rows,cols);
        for (int i = 0; i < diagSize; i++) {
            sequence.add(matrix[i][i]);
        }
        checksForSequence(sequence);

        for (int i = 0; i < SEQUENS_COUNT; i++) {
            System.out.printf("%s ,",SEQUENS_SYMBOL);
        }
        System.out.println();
    }

    private static void checksForSequence(List<String> sequence) {
        for (int startPos = 0; startPos < sequence.size() - 1; startPos++) {
            int counter = 1;
            String symbol = sequence.get(startPos);
            int currentPosition = startPos + 1;

            while (symbol.equals(sequence.get(currentPosition))){
                counter ++;
                if (counter >= SEQUENS_COUNT){
                    SEQUENS_COUNT = counter;
                    SEQUENS_SYMBOL = symbol;
                }
                currentPosition ++;
                if (currentPosition >= sequence.size()){
                    break;
                }
            }
        }
        sequence.clear();
    }


}
