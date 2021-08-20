package com.example.demo;

public class EqualSubset {
 boolean result = false;
    public static void main(String[] args) {
        EqualSubset equalSubset = new EqualSubset();
        int[] elements = {1,2,3,4,5,6,7};
        equalSubset.isEqualPartitionPossible(elements);
        System.out.println(equalSubset.result);
    }

    private void isEqualPartitionPossible(int[] elements) {
        int totalAmount = getTotal(elements);
        int halfTotal = totalAmount / 2;
        if(totalAmount % 2  != 0) {
            result = false;
            return;
        }
         getResult(halfTotal, elements);
    }
    private void getResult(int halfTotal, int[] elements) {
        if (halfTotal == 0) {
            result = true;
            return;
        }

        for (int i = 0; i < elements.length; i++) {
            halfTotal = halfTotal - elements[i];
            if (halfTotal >= 0) {
                int[] remainingElements = generateElements(i, elements);
                getResult(halfTotal, remainingElements);
            }
            halfTotal = halfTotal + elements[i];
        }
    }

    private int[] generateElements(int i, int[] elements) {
        int k = 0;
        int[] remainingElements = new int[elements.length - 1];
        for (int j = 0; j < elements.length; j++) {
            if (j != i) {
                remainingElements[k++] = elements[j];
            }
        }
        return remainingElements;
    }

    private int getTotal(int[] elements) {
        int sum = 0;
        for (int i = 0; i < elements.length; i++) {
            sum = sum + elements[i];
        }
        return sum;
    }
}
