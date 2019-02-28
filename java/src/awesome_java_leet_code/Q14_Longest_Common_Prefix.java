package awesome_java_leet_code;

import java.util.Arrays;
import java.util.List;

// https://github.com/Blankj/awesome-java-leetcode/blob/master/note/014/README.md
public class Q14_Longest_Common_Prefix {

    /**
     * Write a function to find the longest common prefix string amongst an array of strings.
     */

    public static void main(String[] args) {

        List<String> list = Arrays.asList("abcd", "abc", "abcdef");

        System.out.println( longestCommonPrefix(list) );

    }

    public static String longestCommonPrefix(List<String> list) {
        if (list.isEmpty()) { return ""; }

        // とりあえず最初の要素を最長prefixとしておく
        String longestCommonPrefix = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {

                String shorter = list.get(i).length() < list.get(j).length() ? list.get(i) : list.get(j);
                String longer = list.get(i).length() <= list.get(j).length() ? list.get(j) : list.get(i);
                String temp = "";
                for (int k = 0; k < shorter.length(); k++) {
                    char c1 = shorter.charAt(k);
                    char c2 = longer.charAt(k);
                    if (c1 == c2) {
                        temp += c1;
                    } else {
                        break;
                    }
                }

                // 短ければ更新
                if (longestCommonPrefix.length() > temp.length()) {
                    longestCommonPrefix = temp;
                }
            }
        }

        return longestCommonPrefix;
    }
}
