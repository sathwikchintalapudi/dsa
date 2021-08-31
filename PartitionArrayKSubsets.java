package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionArrayKSubsets {
    List<Integer> result = new ArrayList<>();
    List<Integer> consideredResult = new ArrayList<>();
    int partitions = 0;

    public static void main(String[] args) {
        int[] elements = {8, 7, 1, 2};
        int equalPartitions = 3;
        PartitionArrayKSubsets partitionArrayKSubsets = new PartitionArrayKSubsets();
        System.out.println(partitionArrayKSubsets.isKPartitionPossible(elements, equalPartitions));
    }

    private boolean isKPartitionPossible(int[] elements, int equalPartitions) {
        int partitionWeight = getPartitionWeight(elements, equalPartitions);
        getResult(elements, partitionWeight, 0, equalPartitions);
        if (partitions == equalPartitions) {
            return true;
        }
        else {
            return false;
        }
    }

    private void getResult(int[] elements, int partitionWeight, int currentIndex, int equalPartitions) {
        if (partitions == equalPartitions) {
            return;
        }

        if (partitionWeight == 0) {
            partitions++;
            consideredResult.addAll(result);
            partitionWeight = 6;
        }

        for (int i = currentIndex; i < elements.length; i++) {
            // action
            result.add(i);
            if (partitionWeight - elements[i] >= 0 && !consideredResult.contains(i)) {
                getResult(elements, partitionWeight - elements[i], i + 1, equalPartitions);
            }
            // revert
            result.remove(result.size() - 1);
        }
    }

    private int getPartitionWeight(int[] elements, int equalPartitions) {
        return Arrays.stream(elements).sum() / equalPartitions;
    }
}
