package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Data {

    static int N = 10;

    public static List<Integer> list() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }

        return list;
    }

    public static int[] sorted() {
        List<Integer> list = list();

        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = list.get(i);
        }

        return array;
    }

    public static int[] random() {
        List<Integer> list = list();
        Collections.shuffle(list);

        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = list.get(i);
        }

        return array;
    }

    public static void main(String[] args) {

        int[] array = sorted();

        for (int i = 0; i < 20; i++) {
            System.out.println(array[i]);
        }

    }

}
