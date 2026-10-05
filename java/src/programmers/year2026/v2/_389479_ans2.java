package programmers.year2026.v2;

import java.util.PriorityQueue;

public class _389479_ans2 {
    static void main() {

    }

    private static int solution(int[] players, int m, int k) {
        int servers = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < 24; i++) {
            while (!pq.isEmpty() && pq.peek() <= i) {
                Integer poll = pq.poll();
                //System.out.println(poll + " 반납");
            }

            int needServers = players[i] / m;
            if (pq.size() < needServers) {
                for (int j = pq.size(); j < needServers; j++) {
                    //System.out.println(i+" 생성");
                    pq.add(i + k);
                    servers++;
                }
            }
        }

        return servers;
    }
}
