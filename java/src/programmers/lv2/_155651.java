package programmers.lv2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _155651 {
    public static void main(String[] args) {
        String[][] bookTime = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        solution(bookTime);
    }

    public static int solution(String[][] book_time) {

        int[][] bookTime = new int[book_time.length][book_time[0].length];

        for (int i = 0; i < book_time.length; i++) {
            String[] startTimeSplit = book_time[i][0].split(":");
            String[] endTimeSplit = book_time[i][1].split(":");

            int startTime = Integer.parseInt(startTimeSplit[0]) * 60 + Integer.parseInt(startTimeSplit[1]);
            int endTime = Integer.parseInt(endTimeSplit[0]) * 60 + Integer.parseInt(endTimeSplit[1]) + 10;

            bookTime[i][0] = startTime;
            bookTime[i][1] = endTime;
        }
        Arrays.sort(bookTime, (a1, a2) -> a1[0] == a2[0] ? a1[1] - a2[1] : a1[0] - a2[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] time : bookTime) {
            if (!pq.isEmpty() && pq.peek() <= time[0]) {
                pq.poll();
            }
            pq.add(time[1]);
        }

        return pq.size();
    }
}
