package com.ga.homeworks;

import java.util.Arrays;

public class CommonPrefix {

    public static String longestCommonPrefix(String[] words) {
        StringBuilder prefix = new StringBuilder();
        if (words.length == 0) {
            return "";
        }
        int lastProcessedCharIndex = 0;
        String firstWord = words[0];
        while (firstWord.length() > lastProcessedCharIndex) {
            prefix.append(firstWord.charAt(lastProcessedCharIndex));
            lastProcessedCharIndex++;
            boolean prefixIsCommon = Arrays.stream(words).allMatch(word -> word.contains(firstWord));
            if (!prefixIsCommon && lastProcessedCharIndex == 0) {
                return "";
            } else if (!prefixIsCommon) {
                return prefix.toString();
            }
        }
        return prefix.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }
}