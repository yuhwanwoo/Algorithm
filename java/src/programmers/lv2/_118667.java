package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class _118667 {
    public static void main(String[] args) {
//        int[] queue1 = {3,2,7,2};
//        int[] queue2 = {4,6,5,1};
//        System.out.println(solution(queue1, queue2));
//        int[] queue11 = new int[]{1, 1, 1, 1,1};
//        int[] queue22 = new int[]{1,1,1,9,1};
        int[] queue11 = new int[]{9,7,2};
        int[] queue22 = new int[]{9,2,11}; // 3
        /*

        9 7 2 9 => 27
        2 11 => 13

        7 2 9 => 18
        2 11 9 => 22
         */
        System.out.println(solution(queue11, queue22));
    }

    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long sum1 = 0;
        long sum2 = 0;
        int sum = 0;

        for (int i = 0; i < queue1.length; i++) {
            sum += (queue1[i] + queue2[i]);
            sum1 += queue1[i];
            q1.offer(queue1[i]);
            sum2 += queue2[i];
            q2.offer(queue2[i]);
        }

        if (sum % 2 == 1) {
            return -1;
        }

        while (true) {
            if (answer > queue1.length * 4) {
                return -1;
            }

            if (sum1 == sum2) {
                break;
            }

            if (q1.isEmpty() || q2.isEmpty()) {
                return -1;
            }

            if (sum1 > sum2) {
                sum1 -= q1.peek();
                sum2 += q1.peek();
                q2.add(q1.poll());
            } else {
                sum2 -= q2.peek();
                sum1 += q2.peek();
                q1.add(q2.poll());
            }
            answer++;
        }

        return answer;
    }
}
