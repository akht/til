package call_by_reference;

public class Main {

    public static void main(String[] args) {

        testString1();
        testString2();

        System.out.println("----------");

        testObject1();
        testObject2();

    }

    // メソッドを通さずに文字列変数に値をセットする
    public static void testString1() {
        String s = "a";

        s = "b";

        System.out.println(s);  // => "b" 値が書き換わる
    }

    // メソッドの中で文字列変数に値をセットする
    public static void testString2() {
        String s = "a";

        change(s);

        System.out.println(s);  // => "a" 値は書き換わらない
    }

    // メソッドを通さずにオブジェクトのメンバ変数に値をセットする
    public static void testObject1() {
        TestObject testObject = new TestObject();
        testObject.value = "a";

        testObject.value = "b";

        System.out.println(testObject); // => "b" 値が書き換わる
    }

    public static void testObject2() {
        TestObject testObject = new TestObject();
        testObject.value = "a";

        change(testObject);

        System.out.println(testObject); // => "b" 値が書き換わる
    }

    public static void change(String s) {
        s = "b";
        System.out.println(s + " (in method)");
    }

    public static void change(TestObject testObject) {
        testObject.value = "b";
        System.out.println(testObject + " (in method)");
    }
}
