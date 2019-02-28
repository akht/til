package etc;

import java.util.Map;

public class Fibo {
    public static void main(String[] args) {
//        // メモ化に使うメモの初期化
//        memo = new HashMap<>();
//        memo.put(0, 0L);
//        memo.put(1, 1L);
//        for (int i = 0; i < 50; i++) {
//            System.out.println(memoFibo(i) + " ");
//        }

//        for (int i = 0; i < 5; i++) {
//            System.out.println(loopFibo(i));
//        }

        // 謎のループの使い方でフィボナッチ
        int a = 0;  // a(N-1)
        // 初項を表示
        System.out.println(a);
        // bが今の項、aが前項を表す
        // b = b + aがフィボナッチの肝の部分。これを計算した後に
        // a = b - aとしてaに前項の結果を覚えさせて次のbの計算に使う
        for (int b = 1; b <= 10; a = b - a) {
            System.out.println(b);
            b = b + a;
        }

    }

    // ループで書いたフィボナッチ
    public static long loopFibo(long n) {
        if (n <= 1) return n;

        long fib1 = 1;
        long fib2 = 0;
        long fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = fib1 + fib2;
            fib2 = fib1;
            fib1 = fib;
        }
        return fib;
    }

    // スタンダード
    public static int fibo(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibo(n - 1) + fibo(n - 2);
    }

    // ちょっとだけ改善
    public static int fibo2(int n) {
        if (n <= 1) return n;
        return fibo(n-1) + fibo(n-2);
    }

    // 条件演算子を使って書く
    public static int fibo3(int n) {
        return n <= 1 ? n : fibo(n-1) + fibo(n-2);
    }

    static Map<Integer, Long> memo;
    // メモ化を使って効率をあげる
    public static long memoFibo(int n) {
        Long result = memo.get(n);
        if (result != null) {
            return result;
        }
        result = memoFibo(n-1) + memoFibo(n-2);
        memo.put(n, result);
        return result;
    }

    static long f(int n) {
        Long result = memo.get(n);
        if (result != null) return result;

        result = f(n-1) + f(n-2);
        memo.put(n, result);
        return result;
    }
}
