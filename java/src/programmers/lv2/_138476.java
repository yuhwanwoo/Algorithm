package programmers.lv2;

import java.util.HashMap;
import java.util.PriorityQueue;

public class _138476 {
    public static void main(String[] args) {
        solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3});
        solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3});
        solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3});
    }

    public static int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int target : tangerine) {
            if (!map.containsKey(target)) {
                map.put(target, 0);
            }
            map.put(target, map.get(target) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Integer key : map.keySet()) {
            pq.add(-map.get(key));
        }

        while (!pq.isEmpty()) {
            Integer top = pq.poll();
            k += top;
            answer += 1;
            if (k <= 0) {
                break;
            }
        }
        System.out.println("answer = " + answer);
        return answer;
    }
}
