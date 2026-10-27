package programmers.year2026.hkr.medium;

import java.util.List;
import java.util.TreeSet;

public class MinimumLoss_ans2 {
    static void main() {

    }

    public static int minimumLoss(List<Long> price) {
        // Write your code here
        long minLoss = Long.MAX_VALUE;
        TreeSet<Long> priceSet = new TreeSet<>();

        for (int j = 0; j < price.size(); j++) {
            long currentPrice = price.get(j);

            // 현재 가격보다 크면서 가장 작은 값을 세트에서 찾습니다. (price[i] > price[j])
            Long higherPrice = priceSet.higher(currentPrice);

            if (higherPrice != null) {
                // 손실 계산: 이전 가격(매수) - 현재 가격(매도)
                long loss = higherPrice - currentPrice;
                minLoss = Math.min(minLoss, loss);
            }

            // 현재 가격을 세트에 추가
            priceSet.add(currentPrice);
        }

        // 리턴 타입이 int이므로 형변환하여 반환
        return (int) minLoss;
    }
}
