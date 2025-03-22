package test.toss;

import java.util.PriorityQueue;

public class exam02 {
    public static void main(String[] args) {
//        int[] levels = {1,2,3,4};
        int[] levels = {1,2,3,4,5,6,7,8,9};
        System.out.println("solution(levels) = " + solution(levels));
    }

    private static int solution(int[] levels) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int size = levels.length;


        for (int i = 0; i < size; i++) {
            pq.add(-levels[i]);
        }
        int answer = 0;

        System.out.println("size = " + (int)(size * 0.25));

        for (int i = 0; i < (int)(size * 0.25); i++) {
            answer = pq.poll();
        }

        return -answer;
    }
}