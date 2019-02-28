package atcoder.ABC101;

import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();

        int answer = 0;
        for (int i = 0; i < 4; i++) {
            if (S.charAt(i) == '+') {
                answer++;
            } else {
                answer--;
            }
        }

        System.out.println(answer);
    }
}
