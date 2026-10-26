package programmers.year2026.hkr.medium;

import java.util.*;

public class MinimumLoss_ans {
    static void main() {

    }

    public static int minimumLoss(List<Long> price) {
        // Write your code here
        Map<Long, Integer> indexes = new HashMap<>();
        for (int i = 0; i < price.size(); i++) {
            indexes.put(price.get(i), i);
        }

        // 내림차순 정렬을 위해 리스트 복사 후 정렬
        List<Long> sortedPrice = new ArrayList<>(price);
        sortedPrice.sort(Collections.reverseOrder());

        int minLoss = Integer.MAX_VALUE;

        for (int i = 1; i < sortedPrice.size(); i++) {
            long p1 = sortedPrice.get(i - 1);
            long p2 = sortedPrice.get(i);

            // 집을 산 순서(인덱스)가 더 앞선(작은) 경우인지 확인한다.
            if (indexes.get(p1) < indexes.get(p2)) {
                // 손실액을 계산하여 int형으로 변환 후 최솟값 비교
                int loss = (int) (p1 - p2);
                minLoss = Math.min(minLoss, loss);
            }
        }

        return minLoss;
    }
}
