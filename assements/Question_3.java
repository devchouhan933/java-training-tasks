package com.company.assements;

/*
In  this case fibonacciOfIterative is faster and better way to find the fibonacci series
because in fibonacciOfRecursive it needed to maintain stack  and their may be chance
stackoverflow .
*/
public class Question_3 {
    static int n1 = 0, n2 = 1, n3;

    static void fibonacciOfRecursive(int nth) {

        if (nth > 0) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            System.out.print(" " + n3);
            fibonacciOfRecursive(nth - 1);
        }
    }

    private static void fabonacciOfIterative(int nth) {
        int n1 = 0, n2 = 1, n3;

        System.out.print(+n2 + " ");
        for (int i = 0; i < nth; i++) {
            n3 = n1 + n2;
            System.out.print(n3 + " ");
            n1 = n2;
            n2 = n3;
        }
    }


    public static void main(String[] args) {
        System.out.println("--------------iterative-------------------------");
        fabonacciOfIterative(6);

        System.out.println("-----------recurcive----------------------------");
        fibonacciOfRecursive(6);
    }
}
