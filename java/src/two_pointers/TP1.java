package two_pointers;

public class TP1 {

    /*
    しゃくとり法(Tow Pointers)

    長さnの正の整数列 a1,a2,…,ana1,a2,…,an と整数xが与えられる。
    整数列の連続する部分列で、その総和がx以下となるものを数え上げよ
    (実際の出題はQ個のクエリがあって各クエリごとにxが与えられる)。


    ※「条件」を満たす区間 (連続する部分列) の数え上げ
     */

    public static void main(String[] args) {

        twoPointers();

    }


//    static int n = 12;
//    static int[] a = {4,6,7,8,1,2,110,2,4,12,3,9};
//    static int x = 25;

    static int n = 6;
    static int[] a = {5,3,8,6,1,4};
    static int x = 12;

    static void twoPointers() {

        long count = 0;

        int right = 0;
        long sum = 0;
        for (int left = 0; left < n; left++) {

            System.out.println("left = " + a[left]);

            // sumにa[right]を加えても大丈夫ならrightを動かす
            while (right < n && sum + a[right] <= x) {

                System.out.println("right = " + a[right]);

                sum += a[right];
                right++;
            }

            // breakした状態で、rightは条件を満たす最大になっている
            count += (right - left);

            System.out.println("(right-left) = " + (right - left));
            System.out.println("count = " + count);


            // leftをインクリメントする準備
            if (right == left) {
                // rightがleftに重なったらrightも動かす
                right++;

                System.out.println("right = " + right);

            } else {
                // leftのみがインクリメントされるのでsumからa[left]を引く
                sum -= a[left];

                System.out.println("left = " + a[left]);
                System.out.println("sum = " + sum);
            }
        }

        System.out.println(count);
    }
}
