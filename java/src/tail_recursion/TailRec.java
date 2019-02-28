package tail_recursion;


import java.util.function.Supplier;
import java.util.stream.Stream;

public class TailRec<T> {

    private final Supplier<TailRec<T>> next;
    private final boolean done;
    private final T result;

    /**
     * コンストラクタ
     */
    private TailRec(Supplier<TailRec<T>> next, boolean done, T result) {
        this.next = next;
        this.done = done;
        this.result = result;
    }

    public T get() {
        // nextがTailRec.callでラップした部分
        // Stream.iterateでTailRecを次々に生成=再帰呼び出し
        return Stream.iterate(this, a -> a.next.get())
                .filter(a -> a.done)    // 再帰呼び出し終了部分だけに絞る
                .map(a -> a.result)     // 値を取り出す
                .findFirst()            // 再帰呼び出し終了部分は一つだけで良い
                .get();
    }

    public static <T> TailRec<T> call(Supplier<TailRec<T>> next) {
        return new TailRec<>(next, false, null);
    }

    public static <T> TailRec<T> done(T result) {
        return new TailRec<>(() -> null, true, result);
    }

}
