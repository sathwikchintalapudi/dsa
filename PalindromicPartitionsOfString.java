package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class PalindromicPartitionsOfString {

    List<List<String>> result = new ArrayList<>();
    List<String> currentList = new ArrayList<>();

    public static void main(String[] args) {
        String input = "aaaaaaaaaa";
        PalindromicPartitionsOfString palindromicPartitionsOfString = new PalindromicPartitionsOfString();
        palindromicPartitionsOfString.getResult(input);
        System.out.println(palindromicPartitionsOfString.result);
        System.out.println(palindromicPartitionsOfString.result.size());
    }

    private void getResult(String input) {
        if (input.length() == 0) {
            List<String> tempList = new ArrayList<>();
            tempList.addAll(currentList);
            result.add(tempList);
        }

        for (int i = 0; i < input.length(); i++) {
            String palindromeText = input.substring(0, i + 1);
            String remainingText = input.substring(i + 1);
        //    if (isPalindrome(palindromeText)) {
                currentList.add(palindromeText);
                getResult(remainingText);
                currentList.remove(currentList.size()-1);
       //     }
        }
    }

    private boolean isPalindrome(String input) {
        for (int i = 0, j = input.length() - 1; i < j; i++, j--) {
            if (input.charAt(i) != input.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
