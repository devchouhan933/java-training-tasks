package com.company.assements;

import java.util.Arrays;
import java.util.List;

public class Question_2 {

    public static boolean isListContainSum(List<Integer> list, int expectedSum) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            System.out.println(list.get(i));
            int num = expectedSum - list.get(i);
            if (list.contains(num) && list.indexOf(num) != i) return true;
        }
        return false;

    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 6, 4, 5);
        System.out.println(isListContainSum(list, 11));
    }
}
