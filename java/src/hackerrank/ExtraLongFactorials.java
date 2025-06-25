package hackerrank;

import java.math.BigInteger;

public class ExtraLongFactorials {
    public static void main(String[] args) {
        extraLongFactorials(25);
    }

    public static void extraLongFactorials(int n) {
        // Write your code here
        BigInteger init = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            init = init.multiply(BigInteger.valueOf(i));
        }

        System.out.println("init.intValue() = " + init);
    }

}
