package atcoder.ABC103;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();

        if (s.equals(t)) {
            System.out.println("Yes");
            return;
        }

        int len = s.length();
        for (int i = 0; i < len-1; i++) {
            s = s.substring(len-1, len) + s.substring(0, len-1);
            if (s.equals(t)) {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }
}
