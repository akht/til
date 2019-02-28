package awesome_java_leet_code;

// https://github.com/Blankj/awesome-java-leetcode/blob/master/note/038/README.md
public class Q38_Count_And_Say {

    /**
     * 見て言って数列
     */


    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {
            System.out.println(countAndSay(i));
        }

    }

    static String countAndSay(int n) {


        String term = "1";
        while (n > 1) {
            int count = 1;
            StringBuilder sb = new StringBuilder();
            char[] chars = term.toCharArray();
            for (int i = 1; i < term.length(); i++) {

                if (chars[i-1] == chars[i]) {
                    count++;
                } else {
                    sb.append(count).append(chars[i-1]);
                    count = 1;
                }

            }
            term = sb.append(count).append(chars[chars.length-1]).toString();

            n--;
        }

        return term;
    }
}
