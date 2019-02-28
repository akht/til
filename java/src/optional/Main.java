package optional;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        notOptional();

        useOptional();

        useOptional2();
    }

    // Optionalを使わない場合
    static void notOptional() {
        Integer value = IntegerList.get(2);

        // nullチェックをするのは、IntegerList.get()がnullを返すことがあると知っているから
        if (value == null) {
            value = -1;
        }

        value += 100;
        System.out.println("結果：" + value);
    }

    // Optionalを使った場合
    static void useOptional() {

        // IntegerList.get()がnullを返す可能性があることを知っているからOptinalで包むことができる
        // これはよくない。
        // nullが返ることがあるってことを知らなければOptionalを使わないで書かれてしまう
        // これはOptionalを使わない場合も同じ。
        Integer value = Optional.ofNullable(IntegerList.get(2)).orElse(-1);

        value += 100;
        System.out.println("結果：" + value);

    }

    // Optionalを使った場合2
    static void useOptional2() {

        Optional<Integer> optinalvalue = IntegerList.get2(2);
        Integer value = optinalvalue.orElse(-1) + 100;

        System.out.println("結果：" + value);

    }
}
