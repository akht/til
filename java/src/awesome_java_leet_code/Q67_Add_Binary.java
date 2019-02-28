package awesome_java_leet_code;

// https://github.com/Blankj/awesome-java-leetcode/blob/master/note/067/README.md
public class Q67_Add_Binary {

    /**
     * Given two binary strings, return their sum (also a binary string).
     *
     * For example,
     * a = "11", b = "1"
     * returns "100"
     *
     */

    public static void main(String[] args) {

        String a = "10011001";
        String b = "1011011";

        System.out.println(addBinary(a, b));

    }

    static String addBinary(String a, String b) {
        String sum = String.valueOf(Integer.parseInt(a) + Integer.parseInt(b));
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = sum.length()-1; i >= 0; i--) {
            int c = Integer.parseInt(String.valueOf(sum.charAt(i))) + carry;
            if (c == 0) {
                carry = 0;
                sb.append('0');
            } else if (c == 1) {
                carry = 0;
                sb.append('1');
            } else if (c == 2) {
                carry = 1;
                sb.append('0');
            } else if (c == 3) {
                carry = 1;
                sb.append('1');
            }
        }

        String ret = sb.reverse().toString();
        if (carry > 0) {
            ret = carry + ret;
        }

        return ret;
    }
}
