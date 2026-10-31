package programmers.year2026.hkr.easy;

import java.util.List;

public class PlusMinus {
    static void main() {

    }

    public static void plusMinus(List<Integer> arr) {
        int n = arr.size();
        double positiveCount = 0;
        double negativeCount = 0;
        double zeroCount = 0;

        // 배열의 요소를 순회하며 양수, 음수, 0의 개수 카운트
        for (int num : arr) {
            if (num > 0) {
                positiveCount++;
            } else if (num < 0) {
                negativeCount++;
            } else {
                zeroCount++;
            }
        }

        // 비율을 계산하고 소수점 아래 6자리까지 출력
        System.out.printf("%.6f\n", positiveCount / n);
        System.out.printf("%.6f\n", negativeCount / n);
        System.out.printf("%.6f\n", zeroCount / n);
    }
}
