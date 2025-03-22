package programmers.year2023.lv1;

import java.util.PriorityQueue;

public class _138477 {
    public static void main(String[] args) {
//        int k = 3;
//        int[] score = {10, 100, 20, 150, 1, 100, 200};

        int k = 4;
        int[] score = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};

        solution(k, score);
    }

    public static int[] solution(int k, int[] score) {
        int length = score.length;
        int[] answer = new int[length];
        int pqSize = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < length; i++) {
            int currentScore = score[i];
            pq.add(currentScore);
            pqSize++;
            if (pqSize > k) {
                pq.poll();
            }
            Integer top = pq.peek();

            answer[i] = top;
        }

        return answer;
    }
}
