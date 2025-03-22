package baekjoon.boj2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2636 {
    static int n, m, cheese;
    static int[][] arr;
    static int[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int val = Integer.parseInt(st.nextToken());
                arr[i][j] = val;
                if(val == 1) {
                    cheese += 1;
                }
            }
        }
        int time = 0;
        int cnt = 0;

        while (cheese != 0) {
            time += 1;
            cnt = cheese;
            bfs();
        }

        System.out.println(time);
        System.out.println(cnt);
    }

    public static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));

        visited = new int[n][m];

        while(!q.isEmpty()) {
            Point now = q.poll();
            int cx = now.x;
            int cy = now.y;
            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] == 1) {
                    continue;
                }

                if(arr[nx][ny] == 1) {
                    cheese -= 1;
                    arr[nx][ny] = 0;
                }else if(arr[nx][ny] == 0) {
                    q.add(new Point(nx, ny));
                }
                visited[nx][ny] = 1;

            }
        }
    }
}

class Point {
    int x;
    int y;

    Point (int x, int y) {
        this.x = x;
        this.y = y;
    }
}