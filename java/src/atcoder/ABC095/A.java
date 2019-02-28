package atcoder.ABC095;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = String.valueOf(sc.next());

        int a = 700;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'o') {
                a += 100;
            }
        }

        System.out.println(a);
    }
}