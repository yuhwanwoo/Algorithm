package baekjoon.boj2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _20053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            PriorityQueue<Integer> minpq = new PriorityQueue<>();
            PriorityQueue<Integer> maxpq = new PriorityQueue<>();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                minpq.add(num);
                maxpq.add(-num);
            }

            int min = minpq.poll();
            int max = -maxpq.poll();

            System.out.println(min + " " + max);
        }
    }
}
