package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    List<String> results = new ArrayList<>();

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        String input = "sathwik";
        permutations.find_permutation(input);
        System.out.println(permutations.results);
    }

    private void find_permutation(String input) {
        for (int i = 0; i < input.length(); i++) {
            StringBuffer perm = new StringBuffer();
            perm.append(input.charAt(i));
            getPermutation(perm, getUpdatedInput(input, i));
        }
    }

    private void getPermutation(StringBuffer perm, String updatedInput) {
        if (updatedInput.equals("")) {
            results.add(perm.toString());
        }

        for (int i = 0; i < updatedInput.length(); i++) {
            perm.append(updatedInput.charAt(i));
            getPermutation(perm, getUpdatedInput(updatedInput, i));
            perm.deleteCharAt(perm.length() - 1);
        }
    }

    private static String getUpdatedInput(String input, int i) {
        StringBuffer updatedString = new StringBuffer();
        for (int k = 0; k < input.length(); k++) {
            if (i != k) {
                updatedString.append(input.charAt(k));
            }
        }
        return updatedString.toString();
    }
}
