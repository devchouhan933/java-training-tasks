package com.company.assements;

import java.util.Stack;

public class Question_1 {

    public static boolean isValidParentheses(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stackOfCharacter = new Stack();
        for (Character character : chars) {
            if (character == '{' || character == '(' || character == '[') {
                stackOfCharacter.push(character);
            } else if (character == ']') {
                if (stackOfCharacter.isEmpty() || stackOfCharacter.peek() != '[') {
                    return false;
                }
                stackOfCharacter.pop();
            } else if (character == ')') {
                if (stackOfCharacter.isEmpty() || stackOfCharacter.peek() != '(') return false;
                stackOfCharacter.pop();
            } else if (character == '}') {
                if (stackOfCharacter.isEmpty() || stackOfCharacter.peek() != '{') return false;
                stackOfCharacter.pop();
            }
        }
        return stackOfCharacter.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(isValidParentheses("{}"));
    }
}
