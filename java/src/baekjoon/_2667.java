package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _2667 {
    public static int[][] graph;
    public static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        graph = new int[n][n];
        visited = new int[n][n];

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

                }
            }
        }
    }

    public static int dfs(int x, int y) {

        return 0;
    }




}
