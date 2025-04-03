package programmers.lv2;

import java.util.HashMap;

public class _152996 {
    public static void main(String[] args) {
        int[] weights = {100, 180, 360, 100, 270};
        solution(weights);
    }

    public static long solution(int[] weights) {
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int weight : weights) {
            count.put(weight, count.getOrDefault(weight, 0) + 1);
        }
        long answer = 0;

        return answer;
    }
}
