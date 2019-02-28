package awesome_java_leet_code;

// https://github.com/Blankj/awesome-java-leetcode/blob/master/note/028/README.md
public class Q28_Implement_strStr {

    /**
     * Implement strStr().
     *
     * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     */

    public static void main(String[] args) {

        System.out.println( strStr("hello", "ell") );
        System.out.println( strStr("hello", "h") );
        System.out.println( strStr("hello", "ll") );
        System.out.println( strStr("hello", "o") );
        System.out.println( strStr("hello", "lo") );
        System.out.println( strStr("hello", "hello") );

        System.out.println( strStr("aaaaa", "bba") );

        System.out.println( strStr("12345", "23") );
        System.out.println( strStr("12345", "") );
    }

    // JavaのString#indexOf()みたいな関数
    static int strStr(String haystack, String needle) {
        int len = needle.length();

        for (int i = 0; i < haystack.length(); i++) {
            if (i + len <= haystack.length()) {
                String slice = haystack.substring(i, i + len);
                if (needle.equals(slice)) {
                    return i;
                }
            } else {
                break;
            }
        }

        return -1;
    }
}
