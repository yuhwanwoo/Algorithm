package baekjoon.boj2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _10800 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Ball> balls = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            balls.add(new Ball(i, c, s));
        }
        Collections.sort(balls, new Comparator<Ball>() {
            @Override
            public int compare(Ball o1, Ball o2) {
                return o1.size - o2.size;
            }
        });

        int[] answer = new int[n];
        int[] color = new int[n + 1];
        int j = 0;
        int total = 0;

        for (int i = 0; i < n; i++) {
            Ball a = balls.get(i);
            Ball b = balls.get(j);

            while (b.size < a.size) {
                total += b.size;
                color[b.color] += b.size;

                b = balls.get(++j);
            }

            answer[a.index] = total - color[a.color];
        }

        StringBuffer sb = new StringBuffer();
        for (int i : answer) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);

    }

    private static class Ball {
        int index;
        int color;
        int size;

        public Ball(int index, int color, int size) {
            this.index = index;
            this.color = color;
            this.size = size;
        }
    }
}
