package com.company.day4;

import java.util.*;

public class Assignment_1 {

    private static List<Integer> nthMaxfromList(List<Integer> list, int n) {
        List<Integer> integerList = new ArrayList<>();
        if (list.size() >= n) {
            List<Integer> integerList1 = new ArrayList<>(list);
            Collections.sort(integerList1, Collections.reverseOrder());
            for (int i = 0; i < n; i++)
                integerList.add(integerList1.get(i));

        }
        return integerList;
    }

    private static List<Integer> secondMaxFromList(List<Integer> list) {
        List<Integer> integerList = new ArrayList<>(list);
        Collections.sort(integerList, Collections.reverseOrder());
        return Arrays.asList(integerList.get(0), integerList.get(1));
    }

    private static int maxFromList(List<Integer> asList) {
        return Collections.max(asList);
    }

    public static void main(String[] args) {
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String s = (String) o1;
                String s2 = (String) o2;
                return s2.compareTo(s);
            }
        };

        String temp = "This is a sentence";
        System.out.println("frequency of word -> " + Collections.frequency(Arrays.asList(temp.split(" ")), "This"));
        System.out.println("frequency of char -> " + Collections.frequency(Arrays.asList(temp.split("")), "i"));
        List<Integer> integerList = Arrays.asList(1, 2, 6, 3, 4);

        PriorityQueue<String> stringPriorityQueue = new PriorityQueue<>(comparator /*(s,s2)->s2.compareTo(s)*/);
        stringPriorityQueue.add("a");
        stringPriorityQueue.add("b");
        stringPriorityQueue.add("c");
        stringPriorityQueue.add("d");

        while (stringPriorityQueue.size() > 0) {
            System.out.println(stringPriorityQueue.remove());
        }
        List<Integer> list = Arrays.asList(3, 4, 7, 1, 77);
        System.out.println(maxFromList(list));
        System.out.println(secondMaxFromList(list));
        System.out.println(nthMaxfromList(list, 4));
        System.out.println(list);
    }

}






