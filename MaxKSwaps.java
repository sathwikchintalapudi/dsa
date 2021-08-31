package com.example.demo;

public class MaxKSwaps {

    public static void main(String[] args) {
        MaxKSwaps maxKSwaps = new MaxKSwaps();
        String input = "918273645";
        int k = 4;
        System.out.println(maxKSwaps.findMaximumNum(input, k));
    }

    private String findMaximumNum(String input, int k) {
        String maxNumber = input;

        for (int i = 0; i < maxNumber.length() - 1; i++) {
            String maxNumberInitial = maxNumber;
            char[] inputChars = maxNumber.toCharArray();
            if(k > 0) {
                for (int j = i + 1; j < inputChars.length; j++) {
                    if (inputChars[j] > inputChars[i]) {
                        swap(inputChars, i, j);
                        String swappedNumber = new String(inputChars);
                        if (Integer.parseInt(maxNumber) < Integer.parseInt(swappedNumber)) {
                            maxNumber = swappedNumber;
                        }
                        swap(inputChars, j, i);
                    }
                }
                if (maxNumberInitial != maxNumber) {
                    k--;
                }
            }
        }
        return maxNumber;
    }

    private void swap(char[] inputChars, int i, int j) {
        char temp = inputChars[i];
        inputChars[i] = inputChars[j];
        inputChars[j] = temp;
    }
}
