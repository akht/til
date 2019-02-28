package tarai;

public class Tarai {
    public static void main(String[] args) {

        System.out.println(tarai(36, 18, 0));

    }

    static int tarai(int x, int y, int z) {
        if (x <= y) {
            return z;
        } else {
            return tarai(tarai(x - 1, y, z), tarai(y - 1, z, x), tarai(z - 1, x, y));
        }
    }
}
