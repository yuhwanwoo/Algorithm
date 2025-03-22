package baekjoon.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15664 {
    private static int n;
    private static int m;
    private static int[] arr;
    private static int[] answer;
    private static boolean[] visited;
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
    }

    private static void dfs(int start, int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(answer[i] + " ");
            }
            System.out.println();
            return;
        }
        int before = 0;
        for (int i = start; i < n; i++) {
            int now = arr[i];
            if (now == before || visited[i]) {
                continue;
            }
            before = now;
            visited[i] = true;
            answer[depth] = now;
            dfs(i + 1, depth + 1);
            visited[i] = false;
        }
    }
}
