package com.company.assements;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Question_8 {

    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if (map.containsKey(s1.charAt(i))) {
                Integer count = map.get(s1.charAt(i));
                map.put(s1.charAt(i), count++);
            } else {
                map.put(s1.charAt(i), 1);
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            if (map.containsKey(s2.charAt(i))) {
                Integer count = map.get(s2.charAt(i));
                map.put(s2.charAt(i),count - 1);
            }
        }
        Set<Character> keys = map.keySet();
        for (Character key : keys) {
            if (map.get(key) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("DEV","VED"));
    }
}
