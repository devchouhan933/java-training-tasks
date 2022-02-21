package com.company.assements;

import java.util.HashMap;
import java.util.Scanner;

public class Question_4 {
    private static boolean isSymmetricMatrix(int[][] matrix, int row) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                if (matrix[i][j] != matrix[j][i]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int row = 3;
        int[][] matrix = new int[row][row];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        System.out.println();
        System.out.println(isSymmetricMatrix(matrix,row));
    }

}
