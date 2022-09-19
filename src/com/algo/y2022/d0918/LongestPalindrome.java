package com.algo.y2022.d0918;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长回文子串
 *
 * @author flynn
 * @date 2022/09/18
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String result = new LongestPalindrome().longestPalindrome("babad");
        System.out.println(result);
    }

    public String longestPalindrome(String s) {
        Map<Character, Integer> charIndexMap = new HashMap<>(s.length() >> 1);
        int start = 0;
        int end = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            if (charIndexMap.containsKey(item)) {
                int index = charIndexMap.get(item);
                if (i - index > maxLength) {
                    start = index;
                    end = i;
                    maxLength = end - start;
                }
            }
            charIndexMap.put(item, i);
        }
        return s.substring(start, end + 1);
    }

}
