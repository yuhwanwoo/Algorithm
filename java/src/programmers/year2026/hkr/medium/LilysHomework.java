package programmers.year2026.hkr.medium;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class LilysHomework {
    static void main() {
        System.out.println(lilysHomework(List.of(2,5,3,1))); // 2
        System.out.println("lilysHomework() = " + lilysHomework(List.of(1,2)));
        System.out.println("lilysHomework() = " + lilysHomework(List.of(1,2,3)));
    }

    public static int lilysHomework(List<Integer> arr) {
        // Write your code here


        HashMap<Integer, Integer> numToPosition = new HashMap<>();
        HashMap<Integer, Integer> positionToNum = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        HashMap<Integer, Integer> numToPositionMax = new HashMap<>();
        HashMap<Integer, Integer> positionToNumMax = new HashMap<>();
        PriorityQueue<Integer> pqMax = new PriorityQueue<>();
        for (int i = 0; i < arr.size(); i++) {
            Integer score = arr.get(i);
            numToPosition.put(score, i);
            positionToNum.put(i, score);
            pq.add(score);
            numToPositionMax.put(-score, i);
            positionToNumMax.put(i, -score);
            pqMax.add(-score);
        }
        int count = 0;
        int idx = 0;

        while (!pq.isEmpty()) {
            Integer top = pq.poll();
            int nowPos = numToPosition.get(top);
            int nextNum = positionToNum.get(idx);
            if (nowPos != idx) {
                numToPosition.put(top, idx);
                positionToNum.put(idx, top);

                numToPosition.put(nextNum, nowPos);
                positionToNum.put(nowPos, nextNum);

                count++;
            }

            idx++;
        }

        idx = 0;
        int countMax = 0;
        while (!pqMax.isEmpty()) {
            Integer top = pqMax.poll();
            int nowPos = numToPositionMax.get(top);
            int nextNum = positionToNumMax.get(idx);
            if (nowPos != idx) {
                numToPositionMax.put(top, idx);
                positionToNumMax.put(idx, top);

                numToPositionMax.put(nextNum, nowPos);
                positionToNumMax.put(nowPos, nextNum);

                countMax++;
            }

            idx++;
        }



        return Math.min(count, countMax);
    }
}
