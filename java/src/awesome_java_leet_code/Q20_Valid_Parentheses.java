package awesome_java_leet_code;

import java.util.ArrayDeque;
import java.util.Deque;

// https://github.com/Blankj/awesome-java-leetcode/blob/master/note/020/README.md
public class Q20_Valid_Parentheses {

    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
     */

    public static void main(String[] args) {

        System.out.println( isValidParentheses("()") );
        System.out.println( isValidParentheses("(()") );
        System.out.println( isValidParentheses("())") );
        System.out.println( isValidParentheses("(){}[]") );
        System.out.println( isValidParentheses("(]") );
        System.out.println( isValidParentheses("([)]") );
        System.out.println( isValidParentheses("([{}]{}[])") );
    }

    static boolean isValidParentheses(String string) {

        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < string.length(); i++) {

            String s = String.valueOf(string.charAt(i));

            if (s.equals("(") || s.equals("{") || s.equals("[")) {
                stack.offerFirst(s);
            } else if (s.equals(")")) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (!stack.pollFirst().equals("(")) {
                    return false;
                }
            } else if (s.equals("}")) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (!stack.pollFirst().equals("{")) {
                    return false;
                }
            } else if (s.equals("]")) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (!stack.pollFirst().equals("[")) {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
