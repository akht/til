package optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class IntegerList {
    // nullが含まれるIntegerのリスト
    private final static List<Integer> INTEGER_LIST = Arrays.asList(new Integer[]{1, 2, null});


    // 戻り値にnullが含まれる可能性があるが、そんなことはこのメソッドのシグニチャからはわからない
    public static Integer get(int index) {

        return INTEGER_LIST.get(index);

    }


    // 戻り値にnullが含まれる可能性があるためOptionalでラップして返す
    // こうすることで、戻り値にnullになる可能性があることを明示して
    // 呼び出し元にnullを考慮したコーディングを強制することができる
    public static Optional<Integer> get2(int index) {

        return Optional.ofNullable(INTEGER_LIST.get(index));

    }
}
