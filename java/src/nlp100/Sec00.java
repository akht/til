package nlp100;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sec00 {
    // http://www.cl.ecei.tohoku.ac.jp/nlp100/#sec00


    public static void main(String[] args) {


        System.out.println( p00() );
        System.out.println( p01() );
        System.out.println( p02() );
        System.out.println( p03() );
        System.out.println( p04() );

        p05();
        p06();
        p07();
        p08();
        p09();

    }

    // 文字列"stressed"の文字を逆に（末尾から先頭に向かって）並べた文字列を得よ．
    public static String p00() {
        String stressed = "stressed";
        String reversed = "";

        for (int i = stressed.length()-1; i >= 0; i--) {
            reversed += stressed.charAt(i);
        }

        return reversed;
    }


    // 「パタトクカシーー」という文字列の1,3,5,7文字目を取り出して連結した文字列を得よ．
    public static String p01() {
        String s = "パタトクカシーー";
        return String.valueOf(s.charAt(0)) + String.valueOf(s.charAt(2)) +  String.valueOf(s.charAt(4)) +  String.valueOf(s.charAt(6));
    }


    // 「パトカー」＋「タクシー」の文字を先頭から交互に連結して文字列「パタトクカシーー」を得よ．
    public static String p02() {
        String s1 = "パトカー";
        String s2 = "タクシー";
        String ret = "";

        for (int i = 0; i < s1.length(); i++) {
            ret += String.valueOf(s1.charAt(i)) + String.valueOf(s2.charAt(i));
        }

        return ret;
    }


    // "Now I need a drink, alcoholic of course, after the heavy lectures involving quantum mechanics."という文を単語に分解し，
    // 各単語の（アルファベットの）文字数を先頭から出現順に並べたリストを作成せよ．
    public static List<Integer> p03() {
        return Stream.of("Now I need a drink, alcoholic of course, after the heavy lectures involving quantum mechanics.".split(" "))
                .map(String::length)
                .collect(Collectors.toList());

    }


    // "Hi He Lied Because Boron Could Not Oxidize Fluorine. New Nations Might Also Sign Peace Security Clause. Arthur King Can."という文を単語に分解し，
    // 1, 5, 6, 7, 8, 9, 15, 16, 19番目の単語は先頭の1文字，それ以外の単語は先頭に2文字を取り出し，
    // 取り出した文字列から単語の位置（先頭から何番目の単語か）への連想配列（辞書型もしくはマップ型）を作成せよ．
    public static Map<String, Integer> p04() {

        String s = "Hi He Lied Because Boron Could Not Oxidize Fluorine. New Nations Might Also Sign Peace Security Clause. Arthur King Can.";
        String[] array = s.split(" ");
        Predicate<Integer> isHead = i ->  i == 1 || i == 5 || i == 6 || i == 7 || i == 8 || i == 9 || i == 15 || i == 16 || i == 19;
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {

            String head;
            if (isHead.test(i+1)) {
                head = array[i].substring(0, 1);
            } else {
                head = array[i].substring(0, 2);
            }

            map.put(head, i+1);
        }

        return map;

    }


    // 与えられたシーケンス（文字列やリストなど）からn-gramを作る関数を作成せよ．この関数を用い，"I am an NLPer"という文から単語bi-gram，文字bi-gramを得よ．
    public static void p05() {

        String s = "I am an NLPer";

        List<String> wordBiGram = wordNGram(s, 2);
        System.out.println( wordBiGram.stream().reduce((l,r) -> l + "," + r).orElse("") );

        List<String> characterBiGram = characterNGram(s, 2);
        System.out.println( characterBiGram.stream().reduce((l,r) -> l + "," + r).orElse("") );
    }

    // 単語N-gramを作ってリストとして返す
    public static List<String> wordNGram(String s, int n) {
        List<String> nGramList = new ArrayList<>();

        String[] array = s.split(" ");
        int len = array.length;
        int lastIndex = len - 1;
        int step = n - 1;   // bi-gramならn=2なので、ステップは1

        for (int i = 0; i < len; i++) {

            int next = i + step;
            if (next > lastIndex) {
                break;
            }

            String nGram = IntStream.rangeClosed(i, next).boxed().map(index -> array[index]).reduce((l,r) -> l + " " + r).orElse("");
            nGramList.add(nGram);
        }

        return nGramList;
    }

    // 文字N-gramを作ってリストとして返す
    public static List<String> characterNGram(String s, int n) {
        List<String> nGramList = new ArrayList<>();

        String[] array = new String[s.length()];    // 1文字ごとの配列
        for (int i = 0; i < s.length(); i++) {
            array[i] = String.valueOf(s.charAt(i));
        }


        int len = s.length();
        int lastIndex = len - 1;
        int step = n - 1;   // bi-gramならn=2なので、ステップは1

        for (int i = 0; i < len; i++) {

            int next = i + step;
            if (next > lastIndex) {
                break;
            }

            String nGram = IntStream.rangeClosed(i, next).boxed().map(index -> array[index]).reduce((l, r) -> l + r).orElse("");
            nGramList.add(nGram);
        }

        return nGramList;
    }

    // "paraparaparadise"と"paragraph"に含まれる文字bi-gramの集合を，それぞれ, XとYとして求め，
    // XとYの和集合，積集合，差集合を求めよ．さらに，'se'というbi-gramがXおよびYに含まれるかどうかを調べよ．
    public static void p06() {
        Set<String> X = new HashSet<>(characterNGram("paraparaparadise", 2));
        Set<String> Y = new HashSet<>(characterNGram("paragraph", 2));

        // 和集合
        Set<String> UNION =union(X, Y);
        System.out.println("和集合:" + UNION);

        // 積集合
        Set<String> INTERSECTION = intersection(X, Y);
        System.out.println("積集合:" + INTERSECTION);

        // 差集合
        Set<String> DIFFERENCE = difference(X, Y);
        System.out.println("差集合:" + DIFFERENCE);
    }

    // 集合xと集合yの和集合を返す
    public static <T> Set<T> union(Set<T> x, Set<T> y) {
        Set<T> union = new HashSet<>(x);
        union.addAll(y);
        return union;
    }

    // 集合xと集合yの積集合を返す
    public static <T> Set<T> intersection(Set<T> x, Set<T> y) {
        Set<T> intersection = new HashSet<>();
        for (T s : x) {
            if (y.contains(s)) {
                intersection.add(s);
            }
        }
        return intersection;
    }

    // 集合xと集合yの差集合を返す
    public static <T> Set<T> difference(Set<T> x, Set<T> y) {
        Set<T> difference = new HashSet<>();
        for (T s : x) {
            if (!y.contains(s)) {
                difference.add(s);
            }
        }
        return difference;
    }

    // 引数x, y, zを受け取り「x時のyはz」という文字列を返す関数を実装せよ．
    // さらに，x=12, y="気温", z=22.4として，実行結果を確認せよ．
    public static void p07() {

        System.out.println( kion("12", "気温", "22.4") );

    }

    public static String kion(String a, String b, String c) {
        return a + "時の" + b + "は" + c;
    }


    // 与えられた文字列の各文字を，以下の仕様で変換する関数cipherを実装せよ．
    // 英小文字ならば(219 - 文字コード)の文字に置換
    // その他の文字はそのまま出力
    // この関数を用い，英語のメッセージを暗号化・復号化せよ．
    public static void p08() {

        String original = "I am a legend and 29 years old.";

        System.out.println("暗号化:" + cipher(original));
        System.out.println("復号化:" + unCipher(original));
    }

    // 英小文字ならば(219 - 文字コード)の文字に置換
    // その他の文字はそのまま出力
    public static String cipher(String s) {
        String after = "";

        String[] array = new String[s.length()];    // 1文字ごとの配列
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            String replacedCharacter = "";
            if (String.valueOf(c).matches("[a-z]")) {
                replacedCharacter = String.valueOf( (char) (219 - (int) c) );
            } else {
                replacedCharacter = String.valueOf(c);
            }

            array[i] = replacedCharacter;
        }

        return String.join("", array);
    }

    // cipher()で変換する前の文字列を返す
    public static String unCipher(String s) {
        return cipher(cipher(s));
    }


    // スペースで区切られた単語列に対して，各単語の先頭と末尾の文字は残し，それ以外の文字の順序をランダムに並び替えるプログラムを作成せよ．
    // ただし，長さが４以下の単語は並び替えないこととする．
    // 適当な英語の文（例えば"I couldn't believe that I could actually understand what I was reading : the phenomenal power of the human mind ."）を与え，その実行結果を確認せよ．
    public static void p09() {

        String s = "I couldn't believe that I could actually understand what I was reading : the phenomenal power of the human mind .";

        System.out.println( shuffle(s) );

    }

    // スペースで区切られた単語列に対して，各単語の先頭と末尾の文字は残し，それ以外の文字の順序をランダムに並び替える
    // ただし，長さが４以下の単語は並び替えない
    public static String shuffle(String str) {

        Function<String, String> shuffle4mojiika = s -> {
            if (s.length() <= 4) {
                return s;
            }

            return shuffleString(s);
        };

        return Stream.of(str.split(" "))
                .map(shuffle4mojiika)
                .reduce((l,r) -> l + " " + r)
                .orElse("");
    }

    public static String shuffleString(String str) {

        List<String> list = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            if (i == 0 || i == str.length()+1) {
                continue;
            }

            list.add(String.valueOf(str.charAt(i)));

        }

        Collections.shuffle(list);
        list.add(0, String.valueOf(str.charAt(0)));
        list.add(String.valueOf(str.charAt(str.length()-1)));

        return String.join("", list);
    }

}
