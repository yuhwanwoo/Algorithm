package hackerrank;

import java.util.List;

public class PlusMinus {
    public static void main(String[] args) {

    }

    public static void plusMinus(List<Integer> arr) {
        int positive = 0;
        int negative = 0;
        int zero = 0;

        for (Integer num : arr) {
            if (num > 0) {
                positive++;
            } else if (num < 0) {
                negative++;
            } else {
                zero++;
            }
        }

        System.out.printf("%.6f\n", (double) positive / arr.size());
        System.out.printf("%.6f\n", (double) negative / arr.size());
        System.out.printf("%.6f", (double) zero / arr.size());
    }
}
