package com.company.assements;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Question_8 {

    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> map_for_s1 = new HashMap<>();
        Map<Character, Integer> map_for_s2 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            if (map_for_s1.containsKey(s1.charAt(i))) {
                Integer count = map_for_s1.get(s1.charAt(i));
                map_for_s1.put(s1.charAt(i), count++);
            } else {
                map_for_s1.put(s1.charAt(i), 1);
            }
            if (map_for_s2.containsKey(s2.charAt(i))) {
                Integer count_ = map_for_s1.get(s2.charAt(i));
                map_for_s2.put(s2.charAt(i), count_++);
            } else {
                map_for_s2.put(s2.charAt(i), 1);
            }

        }

        return map_for_s1.equals(map_for_s2);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("ABDC", "DBAC"));
    }
}
