package com.example.demo;

public class KthPermutation {
    int finalResult = 0;

    public static void main(String[] args) {
        KthPermutation kthPermutation = new KthPermutation();
        int n = 5;
        int k = 17;
        int[] input = kthPermutation.formInput(n);
        kthPermutation.getResult(input, k);
        System.out.println(kthPermutation.finalResult);
    }

    private void getResult(int[] input, int k) {
        if (k == 0) {
            int x = getIndexOfLastDigit(input);
            finalResult = finalResult * 10 + input[x];
        }
        else {
            int permutationsPossible = getPossiblePermutations(input);
            int digitIndex = ((k - 1) / permutationsPossible);
            int finalIndex = formResult(input, digitIndex);
            finalResult = finalResult * 10 + input[finalIndex];
            input[finalIndex] = -1;
            getResult(input, k % permutationsPossible);
        }
    }


    private int formResult(int[] input, int resultIndex) {
        int index = -1;
        for (int i = 0; i < input.length; i++) {
            if (input[i] != -1) {
                index++;
            }
            if (resultIndex == index) {
                index = i;
                break;
            }

        }
        return index;
    }

    private int getPossiblePermutations(int[] input) {
        int length = 0;
        for (int j = 0; j < input.length; j++) {
            if (input[j] != -1) {
                length = length + 1;
            }
        }

        int result = 1;
        for (int i = length - 1; i > 0; i--) {
            result = result * i;
        }
        return result;
    }

    private int[] formInput(int n) {
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = i + 1;
        }
        return input;
    }

    private int getIndexOfLastDigit(int[] input) {
        int index = -1;
        for (int x = 0; x < input.length; x++) {
            if (input[x] != -1) {
                index = x;
                break;
            }
        }
        return index;
    }

}
