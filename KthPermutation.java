package com.example.demo;

public class KthPermutation {
    int finalResult = 0;

    public static void main(String[] args) {
        KthPermutation kthPermutation = new KthPermutation();
        int n = 5;
        int k = 17;
        kthPermutation.getKthPermutation(n, k);
        System.out.println(kthPermutation.finalResult);
    }

    private void getKthPermutation(int n, int k) {
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = i + 1;
        }
        getResult(input, k);
    }

    private void getResult(int[] input, int k) {
        if (k == 0) {
            for (int x = 0; x < input.length; x++) {
                if (input[x] != -1) {
                    finalResult = finalResult * 10 + input[x];
                }
            }
        }
        else {
            int permutationsPossible = getPossiblePermutations(input);
            int resultIndex = ((k - 1) / permutationsPossible);
            int index = formResult(input, resultIndex);

            finalResult = finalResult * 10 + input[index];

            input[index] = -1;
            getResult(input, k % permutationsPossible);
        }
    }

    // FInd the number of the box
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
}
