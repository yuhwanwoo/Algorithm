package programmers.lv2;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class _152996 {
    public static void main(String[] args) {
        int[] weights = {100, 180, 360, 100, 270};
        solution(weights);

        solution(new int[]{200, 300, 300});
    }

    public static long solution(int[] weights) {
        long answer = 0;
        HashMap<Double, Long> weightToCount = new HashMap<>();

        for (int weight : weights) {
            weightToCount.put(weight * 1.0, weightToCount.getOrDefault(weight * 1.0, 0L) + 1);
        }

        for (Double key : weightToCount.keySet()) {
            Long count = weightToCount.get(key);

            if (count > 1) {
                answer += combination(count);
            }

            if (weightToCount.containsKey(key * 3.0 / 4.0)) {
                answer += (long) (weightToCount.get(key * 3.0 / 4.0) * (count * 1.0));
            }

            if (weightToCount.containsKey(key * 2.0 / 3.0)) {
                answer += (long) (weightToCount.get(key * 2.0 / 3.0) * (count * 1.0));
            }

            if (weightToCount.containsKey(key * 1.0 / 2.0)) {
                answer += (long) (weightToCount.get(key * 1.0 / 2.0) * (count * 1.0));
            }
        }

        return answer;
    }

    private static long combination(long n) {
        if (n < 2) return 0; // n이 2보다 작으면 조합 불가능
        return n * (n - 1) / 2;
    }
}
