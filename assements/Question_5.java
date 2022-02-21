package com.company.assements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Question_5 {
    private static List<Integer> kthMaxfromList(List<Integer> list, int k) {
        List<Integer> integerList = new ArrayList<>();
        if (list.size() >= k) {
            List<Integer> integerList1 = new ArrayList<>(list);
            Collections.sort(integerList1, Collections.reverseOrder());
            for (int i = 0; i < k; i++)
                integerList.add(integerList1.get(i));
        }
        return integerList;
    }
    public static void main(String[] args) {
        System.out.println(kthMaxfromList(Arrays.asList(1,4,5,6,7),2));;
    }
}
