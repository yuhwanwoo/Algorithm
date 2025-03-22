package programmers.year2023.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class _1844 {
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static Queue<Pair> q = new LinkedList<>();
    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        solution(maps);
    }

    public static int solution(int[][] maps) {
        q.add(new Pair(0, 0));
        while (!q.isEmpty()) {
            Pair top = q.poll();
            int x = top.x;
            int y = top.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length) {
                    continue;
                }
                if (maps[nx][ny] == 0) {
                    continue;
                }
                if (maps[nx][ny] == 1) {
                    maps[nx][ny] = maps[x][y] + 1;
                    q.add(new Pair(nx, ny));
                }
            }
        }

        return maps[maps.length - 1][maps[0].length - 1] != 1 ? maps[maps.length - 1][maps[0].length - 1] : -1;
    }

    private static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
