package atcoder.ABC103;

import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(new int[]{sc.nextInt(), sc.nextInt()});
        }

        // 目的地の番号で昇順にソートする
        Collections.sort(list, Comparator.comparing(a -> a[1]));

        int count = 0;
        int prev = 0;
        if (!list.isEmpty()) {
            count = 1;
            prev = list.get(0)[1] - 1;
        }

        for (int i = 1; i < list.size(); i++) {
            int[] ab = list.get(i);

            if (ab[0] <= prev) {
                continue;
            }

            count++;
            prev = ab[1] - 1;
        }

        System.out.println(count);
    }

    // これはダメな実装
    public static void xxx(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();


        int[] memo = new int[n-1];

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            for (int j = a-1; j < b-1; j++) {
                memo[j]++;
            }

            list.add(new int[]{a, b});
        }
//        System.out.println(Arrays.toString(memo));

        int count = 0;
        boolean[] memo2 = new boolean[n-1];
//        System.out.println(Arrays.toString(memo2));
        for (int[] ab : list) {
            int a = ab[0] - 1;
            int b = ab[1] - 1;
            int max = 0;
            int maxBridge = 0;
            for (int i = a; i < b; i++) {
                if (max < memo[i]) {
                    max = memo[i];
                    maxBridge = i;
                }
            }
//            System.out.println(ab[0] + "-" + ab[1] + "間のmax = " + max + " no=" + (maxBridge+1));
            if (!memo2[maxBridge]) {
                // 橋がまだ落とされてなかったら落とす
                memo2[maxBridge] = true;
                count++;
            }
        }
        System.out.println(count);
    }
}
