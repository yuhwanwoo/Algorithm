package hackerrank;

import java.util.List;

public class PlusMinus_ans {
    public static void main(String[] args) {

    }

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        int plus = 0;
        int minus = 0;
        int zero = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > 0) {
                plus++;
            } else if (arr.get(i) < 0) {
                minus++;
            } else {
                zero++;
            }
        }

        double resultPlus = (double) plus / arr.size();
        double resultMinus = (double) minus / arr.size();
        double resultZero = (double) zero / arr.size();

        System.out.printf("%.6f\n%.6f\n%.6f", resultPlus, resultMinus, resultZero);
    }
}

