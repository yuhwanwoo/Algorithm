package programmers.lv2;

import java.util.HashMap;

public class _152996 {
    public static void main(String[] args) {
        int[] weights = {100, 180, 360, 100, 270};
        solution(weights);
    }

    public static long solution(int[] weights) {
        HashMap<Integer, Integer> weightToCount = new HashMap<>();

        for (int weight : weights) {
            weightToCount.put(weight, weightToCount.getOrDefault(weight, 0) + 1);
        }
        for (Integer key : weightToCount.keySet()) {
            Integer count = weightToCount.get(key);
        }
//            for (int i = 2; i <= 4; i++) {
//
//            }

        long answer = 0;

        return answer;
    }
}
