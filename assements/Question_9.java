package com.company.assements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question_9 {

    private static void removeNegativeIntegers(List<Integer> integers) {
        integers.removeIf(integer -> integer < 0);
    }
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList(Arrays.asList(1, 3, 2, -2, 4, -2, -8));
        removeNegativeIntegers(integers);
        System.out.println(integers);
    }

}
