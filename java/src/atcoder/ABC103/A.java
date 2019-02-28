package atcoder.ABC103;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] tasks = new int[3];
        for (int i = 0; i < 3; i++) {
            tasks[i] = sc.nextInt();
        }

        Arrays.sort(tasks);
        int min = Math.abs(tasks[0] - tasks[1]) + Math.abs(tasks[1] - tasks[2]);
        System.out.println(min);
    }
}
