package etc;

public class NthRoot {

    /**
     * 冪根（累乗根）
     */

    public static void main(String[] args) {

        // 平方根 = x^(1/2)
        // 3乗根 = x^(1/3)
        // 4乗根 = x^(1/4)
        // 5乗根 = x^(1/5)



        // 平方根
        System.out.println( Math.sqrt(4) );
        System.out.println( Math.pow(4, 0.5));
        System.out.println( Math.pow(4, (double)1 / 2));
        System.out.println( nthRoot(4, 2));

        System.out.println();



        // 3乗根
        System.out.println( Math.cbrt(4) );
        System.out.println( Math.pow(4, (double)1 / 3) );
        System.out.println( nthRoot(4, 3));
        System.out.println( 1.5874010519681996 * 1.5874010519681996 * 1.5874010519681996);

        System.out.println();



        // 4乗根
        System.out.println( Math.pow(4, 0.25) );
        System.out.println( Math.pow(4, (double)1 / 4) );
        System.out.println( nthRoot(4, 4));
        System.out.println( 1.4142135623730951 * 1.4142135623730951 * 1.4142135623730951 * 1.4142135623730951);

        System.out.println();



        // 5乗根
        System.out.println( Math.pow(4, 0.2) );
        System.out.println( Math.pow(4, (double)1 / 5) );
        System.out.println( nthRoot(4, 5));
        System.out.println( 1.3195079107728942 * 1.3195079107728942 * 1.3195079107728942 * 1.3195079107728942 * 1.3195079107728942);

    }

    /**
     * 簡易的にxのn乗根を求めて返す
     *
     * @param x
     * @param n
     * @return xのn乗根
     */
    public static double nthRoot(double x, int n) {

        return Math.pow(x, (double)1 / n);

    }
}
