package atcoder.ABC098;

import java.util.Scanner;

public class A {

    /*
    2 つの整数 A, B が与えられます。 A+B, A−B, A×B の中で最大の値を求めてください。
     */

    static int A;
    static int B;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();

        solve();
    }

    static void solve() {

        int add = A + B;
        int sub = A - B;
        int mul = A * B;

        int max = Math.max(Math.max(add, sub), mul);
        System.out.println(max);
    }


}
