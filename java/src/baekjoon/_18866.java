package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 일단 투포인터,부분합 등
public class _18866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] happiness = new int[n];
        int[] fatigue = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            happiness[i] = u;
            fatigue[i] = v;
        }

        int hs = 0;
        int he = n - 1;
        int fs = 0;
        int fe = n - 1;

        int hmax = 0;
        int hmin = Integer.MAX_VALUE;

        while (true) {

        }


    }
}
