package programmers.year2023.lv1;

import java.util.PriorityQueue;

public class _135808 {
    public static void main(String[] args) {
//        int k = 3;
//        int m = 4;
//        int[] score = {1, 2, 3, 1, 2, 3, 1};

        int k = 4;
        int m = 3;
        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};

        solution(k, m, score);
    }

    public static int solution(int k, int m, int[] score) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < score.length; i++) {
            int now = -score[i];
            pq.add(now);
        }

        int appleCnt = 0;
        for (int i = 0; i < score.length; i++) {
            Integer top = pq.poll();
            appleCnt++;
            if (appleCnt == m) {
                answer += -(top * m);
                appleCnt = 0;
            }
        }

        System.out.println("answer = " + answer);

        return answer;
    }
}
