package etc;

public class Hanoi {

    public static void main(String[] args) {

//        int n = hanoi(3, "X", "Y",  "Z");
//        System.out.println(n);

        int n = hanoi(6);
        System.out.println(n);

    }

//    static void hanoi(int n, String from, String to, String using) {
//
//        if (n == 0) {
//
//        } else {
//            hanoi(n - 1, from, using, to);
//            System.out.println(from + " → " + to);
//            hanoi(n - 1, using, to, from);
//        }
//
//    }

    static int hanoi(int n) {
        if (n == 0) {
            return 0;
        }
        return hanoi(n - 1) + 1 + hanoi(n - 1);
    }
}
