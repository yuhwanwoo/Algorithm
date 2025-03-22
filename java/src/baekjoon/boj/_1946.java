package baekjoon.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t != 0) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Pair> arrays = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arrays.add(new Pair(a, b));
            }
            Collections.sort(arrays);
            int answer = 0;
            int minValue = arrays.get(0).b;
            for (int i = 0; i < n; i++) {
                int nowB = arrays.get(i).b;
                if (nowB <= minValue) {
                    answer++;
                    minValue = nowB;
                }
            }
            System.out.println(answer);
            t--;
        }
    }

    private static class Pair implements Comparable<Pair> {
        private Integer a;
        private Integer b;

        public Pair(Integer a, Integer b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.a == o.a) {
                return b - o.b;
            }

            return this.a - o.a;
        }
    }
}
