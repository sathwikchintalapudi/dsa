package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class CombinationalSum {

    List<List<Integer>> finalResult = new ArrayList<>();

    public static void main(String[] args) {
        int[] input = {7, 2, 6, 5};
        int totalTarget = 16;
        CombinationalSum combinationalSum = new CombinationalSum();
        List<Integer> result = new ArrayList<>();
        combinationalSum.getResult(input, totalTarget, 0, result);
        System.out.println(combinationalSum.finalResult);
    }

    private void getResult(int[] input, int totalTarget, int index, List<Integer> result) {

        if (totalTarget == 0) {
            finalResult.add(new ArrayList<>(result));
            return;
        }

        for (int i = index; i < input.length; i++) {
            result.add(input[i]);
            if (totalTarget - input[i] >= 0) {
                getResult(input, totalTarget - input[i], i, result);
            }
            result.remove(result.size() - 1);
        }
    }
}
