package com.example.demo;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RemoveInvalidParantheses {

    Set<String> interResults = new HashSet<>();
    public static void main(String[] args) {
        RemoveInvalidParantheses removeInvalidParantheses = new RemoveInvalidParantheses();
        String input = "(()a";
        int mra = removeInvalidParantheses.getMra(input);

        removeInvalidParantheses.generateValidStrings(input, mra);
    }

    // generate the valid string after removing the minimum removals
    private void generateValidStrings(String input, int mra) {
        if(mra == 0) {
            System.out.println(input);
            return;
        }
        formSolution(input, mra, 0);
    }

    private void formSolution(String input, int mra, int currentRemoval) {

        if(mra == currentRemoval) {
            if(getMra(input) == 0) {
                System.out.println(input);
                return;
            }
        }

        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '(' || input.charAt(i) == ')') {
                String partOne = input.substring(0, i);
                String partTwo = input.substring(i + 1);
                if (interResults.add(partOne + partTwo)) {
                    formSolution(partOne + partTwo, mra, currentRemoval + 1);
                }
            }
        }
    }

    // get the minimum removals
    private int getMra(String input) {
        Stack<Character> stack = new Stack<>();
        char[] in = input.toCharArray();

        for (int i = 0; i < in.length; i++) {
            if (stack.isEmpty() && (in[i] == '(' || in[i] == ')')) {
                stack.push(in[i]);
            }
            else if (in[i] == '(' || in[i] == ')') {
                if (stack.peek() == '(' && in[i] == ')') {
                    stack.pop();
                }
                else {
                    stack.push(in[i]);
                }
            }
        }
        return stack.size();
    }
}
