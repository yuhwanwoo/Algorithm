package baekjoon.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15665 {
    private static int n, m;
    private static int[] arr;
    private static int[] answer;
    private static boolean[] visited;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        answer = new int[m];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0, 0);
        bw.close();
        br.close();
    }

    private static void dfs(int start, int depth) throws IOException {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                bw.write(answer[i] + " ");
            }
            bw.write("\n");
            return;
        }
        int before = 0;
        for (int i = 0; i < n; i++) {
            int now = arr[i];
            if (now == before) {
                continue;
            }
            before = now;
            answer[depth] = now;
            dfs(i + 1, depth + 1);
        }
    }
}
