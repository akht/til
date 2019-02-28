package etc;

public class Overflow {
    public static void main(String[] args) {

        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        int c = (a + b) / 2;        // オーバーフローする
        System.out.println(c);


        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        int z = x + (y - x) / 2;    // オーバーフローしない
        System.out.println(z);
    }
}
