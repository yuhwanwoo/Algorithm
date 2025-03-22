package baekjoon.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _6068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        ArrayList<Pair> arrays = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            arrays.add(new Pair(t, s));
        }

        Collections.sort(arrays);
        int answer = arrays.get(0).s;
        int totalFirstVal = 0;

        for (int i = 0; i < n; i++) {
            if (arrays.get(i).s == answer) {
                totalFirstVal += arrays.get(i).t;
            } else {
                break;
            }
        }
        if (totalFirstVal > answer) {
            System.out.println(-1);
            return;
        }
        answer = (answer - totalFirstVal);
        int total = answer;
        for (int i = 0; i < n; i++) {
            int nowT = arrays.get(i).t;
            int nowS = arrays.get(i).s;
            total += nowT;
            if (total > nowS) {
                answer -= (total - nowS);
                total -= (total - nowS);
            }
            if (answer < 0) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(answer);
    }

    private static class Pair implements Comparable<Pair> {
        private int t;
        private int s;

        public Pair(int t, int s) {
            this.t = t;
            this.s = s;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.s == o.s) {
                return o.t - this.t;
            }
            return this.s - o.s;
        }
    }
}
