package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class EqualSubsetTwo {
    List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        EqualSubsetTwo equalSubset = new EqualSubsetTwo();
        int[] elements = {1, 5, 11, 5};
        System.out.println(equalSubset.isEqualPartitionPossible(elements));
    }

    private boolean isEqualPartitionPossible(int[] elements) {
        int halfTotal = getTotal(elements) / 2;
        return getResult(halfTotal, elements, result);
    }

    private boolean getResult(int halfTotal, int[] elements, List<Integer> result) {
        boolean op = false;
        if (halfTotal == 0) {
            // Split in to 2 lots on the results
            System.out.println(result);
            return true;
        }

        for (int i = 0; i < elements.length; i++) {
            halfTotal = halfTotal - elements[i];
            if (halfTotal >= 0) {
                int[] remainingElements = generateElements(i, elements);
                result.add(elements[i]);
                op = getResult(halfTotal, remainingElements, result);
                result.remove(result.size() - 1);
            }
            halfTotal = halfTotal + elements[i];
        }
        return op;
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
