package programmers.year2026.hkr.medium;

import java.util.List;
import java.util.PriorityQueue;

public class MaxMin_fail {
    static void main() {
        maxMin(3, List.of(10, 100, 300, 200, 1000, 20, 30));
    }

    public static int maxMin(int k, List<Integer> arr) {
        // Write your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Integer i : arr) {
            pq.add(i);
        }

        int max =0;
        int min= 0;
        for (int i = 0; i < k; i++) {
            Integer poll = pq.poll();
            if (i == 0) {
                min = poll;
            }
            if (i == k - 1) {
                max = poll;
            }
        }
        return max - min;
    }
}
