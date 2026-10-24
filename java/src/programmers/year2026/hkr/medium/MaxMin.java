package programmers.year2026.hkr.medium;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MaxMin {
    static void main() {
        maxMin(3, List.of(10, 100, 300, 200, 1000, 20, 30));
    }

    public static int maxMin(int k, List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.size() - k + 1; i++) {
            int gap = arr.get(i + k - 1) - arr.get(i);
            min = Math.min(min, gap);
        }

        return min;
    }
}
