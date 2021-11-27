package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class _2667 {
    public static int[][] graph;

    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];

        ArrayList<Integer> answer = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(tmp.charAt(j) + "");
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1) {
                    int cnt = dfs(i, j);
                    answer.add(cnt);
                }
            }
        }

        Collections.sort(answer);

        System.out.println(answer.size());
        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }

    public static int dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= n) {
            return 0;
        }
        if (graph[x][y] == 1) {
            graph[x][y] = 0;
            int cnt = 0;
            cnt += 1;
            cnt += dfs(x + 1, y);
            cnt += dfs(x, y + 1);
            cnt += dfs(x - 1, y);
            cnt += dfs(x, y - 1);

            return cnt;
        }

        return 0;
    }
}
