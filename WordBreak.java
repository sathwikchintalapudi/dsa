package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {

    List<String> results = new ArrayList<>();
    Map<Character, List<Integer>> reference;

//    public static void main(String[] args) {
//        List<String> dict = Arrays.asList("cats", "cat", "and", "sand", "dog");
//        WordBreak wordBreak = new WordBreak();
//        String input = "catsanddog";
//        wordBreak.wordBreak(dict.size(), dict, input);
//    }
//
//    private void wordBreak(int n, List<String> dict, String input) {
//        reference = formMap(input);
//        char[] inputInfo = input.toCharArray();
//        getResult(dict, inputInfo, 0);
//    }

//    private void getResult(List<String> dict, char[] inputInfo, int currentIndex) {
//        if (dict.size() == currentIndex) {
//            System.out.println(results);
//            results.clear();
//            return;
//        }
//        for (int i = 0; i < dict.size(); i++) {
//            if (isStringEmbedded(inputInfo, dict.get(i))) {
//                results.add(dict.get(i));
//                getResult(getUpdatedDict(dict, i), updateInputInfo(inputInfo, dict.get(i)), i);
//                results.remove(results.size() - 1);
//            }
//        }
//    }

//    private char[] updateInputInfo(char[] inputInfo, String s) {
//        char[] selectedDictionary = s.toCharArray();
//        List<Integer> indexes = reference.get(selectedDictionary[0]);
//        for(Integer index : indexes) {
//            for(int i = 0; i < selectedDictionary.length; i++) {
////                if() {
////
////                }
//            }
//        }
//
//    }

//    private List<String> getUpdatedDict(List<String> dict, int i) {
//
//
//    }

    private boolean isStringEmbedded(char[] inputInfo, String dictionaryValue) {
        return inputInfo.toString().contains(dictionaryValue);
    }

    private Map<Character, List<Integer>> formMap(String input) {
        Map<Character, List<Integer>> reference = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            if (reference.containsKey(input.charAt(i))) {
                reference.get(input.charAt(i)).add(i);
            }
            else {
                List<Integer> location = new ArrayList<>();
                location.add(i);
                reference.put(input.charAt(i), location);
            }
        }
        return reference;
    }
}
