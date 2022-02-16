package com.company.day3.homework;

public class TwoDimensionalArray {
    public static void show(int row, int column) {
        char[][] grades = new char[row][column];

        char a = 'A';
        System.out.println("Grades of 3 students");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                grades[i][j] = a;
        }
            a++;
        }
        grades[1][4] = 'C';
        grades[2][0] = 'A';
        String str = "        ";
        for (int i = -1; i < row; i++) {
            if (i >= 0)
                System.out.print("Student" + (i + 1) + " ");
            else {
                System.out.print("         ");
            }
            for (int j = -1; j < column; j++) {
                if (i == -1 && j < column - 1) {
                    System.out.print("courses" + (j + 2) + " ");
                }
                if (j >= 0 && i >= 0) {
                    System.out.print(" " + grades[i][j] + "       ");
                }

            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int row = 3;
        int column = 5;
        show(row, column);
    }

}