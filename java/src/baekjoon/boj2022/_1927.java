package baekjoon.boj2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0 && pq.isEmpty()) {
                System.out.println(0);
            }
            if (input == 0 && !pq.isEmpty()) {
                Integer poll = pq.poll();
                System.out.println(poll);
            }
            if (input != 0) {
                pq.add(input);
            }
        }
    }
}
