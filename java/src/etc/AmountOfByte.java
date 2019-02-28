package etc;

import java.nio.charset.Charset;

public class AmountOfByte {
    public static void main(String[] args) {

        /**
         * 文字列のバイト数
         */

        System.out.println(getByteLength("ABCDEFGHIJKLMNOPQRSTUVWXYZ", Charset.forName("Shift_JIS")));
        System.out.println(getByteLength("ABCDEFGHIJKLMNOPQRSTUVWXYZ", Charset.forName("UTF-8")));

        System.out.println(getByteLength("あいうえお", Charset.forName("Shift_JIS")));
        System.out.println(getByteLength("あいうえお", Charset.forName("UTF-8")));
    }

    public static int getByteLength(String s, Charset charset) {
        return s.getBytes(charset).length;
    }
}
