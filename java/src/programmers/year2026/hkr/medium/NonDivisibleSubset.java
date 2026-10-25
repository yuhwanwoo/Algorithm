package programmers.year2026.hkr.medium;

import java.util.HashMap;
import java.util.List;

public class NonDivisibleSubset {
    static void main() {
        nonDivisibleSubset(3, List.of(1, 7, 2, 4));
    }

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer i : s) {
            int mod = i % k;
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }


        int answer = 0;
        if (map.containsKey(0)) {
            answer += 1;
        }
        for (int i = 1; i <= k / 2; i++) {
            if (i == k - i) {
                if (map.containsKey(i)) {
                    answer++;
                }
            } else {
                int count1 = map.getOrDefault(i, 0);
                int count2 = map.getOrDefault(k - i, 0);
                answer += Math.max(count1, count2);
            }
        }

        return answer;
    }
}
