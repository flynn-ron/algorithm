package com.algo.y2022.d0917;

/**
 * @author flynn
 * @date 2022/09/18
 */
public class LongestCommonPrefix {
    /*
    编写一个函数来查找字符串数组中的最长公共前缀。

    如果不存在公共前缀，返回空字符串""。

    示例 1：
    输入：strs = ["flower","flow","flight"]
    输出："fl"

    示例 2：
    输入：strs = ["dog","racecar","car"]
    输出：""
    解释：输入不存在公共前缀。

    提示：

    1 <= strs.length <= 200
    0 <= strs[i].length <= 200
    strs[i] 仅由小写英文字母组成
     */
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        LongestCommonPrefix instance = new LongestCommonPrefix();
        System.out.println(instance.longestCommonPrefix(strs));
        System.out.println(instance.longestPrefix2(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder bd = new StringBuilder();
        for (int i = 0; i <= 200; i++) {
            Character charItem = null;
            boolean isSame = true;
            for (String item : strs) {
                if (item.length() <= i) {
                    isSame = false;
                    break;
                }
                if (charItem == null) {
                    charItem = item.charAt(i);
                    continue;
                }
                if (charItem != item.charAt(i)) {
                    isSame = false;
                    break;
                }
            }
            if (!isSame || charItem == null) {
                break;
            }
            bd.append(charItem);
        }
        return bd.toString();
    }

    public String longestPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String shortest = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (shortest.length() > strs[i].length()) {
                shortest = strs[i];
            }
        }
        for (int i = 0; i < shortest.length() ; i++) {
            for (int j = 0; j < strs.length ; j++) {
                if (i >= strs[j].length() || shortest.charAt(i) != strs[j].charAt(i)) {
                    return shortest.substring(0, i);
                }
            }
        }
        return shortest;
    }


    /**
     * 官方，横向扫描
     * @param strs
     * @return
     */
    public String officialLongestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = officialLongestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    /**
     * 找出两个字符串的公共前缀
     * @param str1
     * @param str2
     * @return
     */
    public String officialLongestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }
}
