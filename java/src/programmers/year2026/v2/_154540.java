package programmers.year2026.v2;

import java.util.PriorityQueue;

public class _154540 {
    private static boolean[][] visited;
    private static char[][] map;
    private static PriorityQueue<Integer> pq = new PriorityQueue<>();
    private static int[] dx = {0, -1, 0, 1};
    private static int[] dy = {-1, 0, 1, 0};

    static void main() {
        String[] maps = {"X591X", "X1X5X", "X231X", "1XXX1"};
        solution(maps); // 1, 1, 27

        String[] maps1 = {"XXX","XXX","XXX"};
        solution(maps1); // -1
    }

    public static int[] solution(String[] maps) {
        int[] answer = {};
        map = new char[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].toCharArray();
        }

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (!visited[i][j] && Character.isDigit(map[i][j])) {
                    visited[i][j] = true;
                    dfs(i, j, map[i][j]);
                }
            }
        }

        return answer;
    }


    private static int dfs(int x, int y, int score) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length && Character.isDigit(map[nx][ny])) {
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    score += dfs(nx, ny, map[nx][ny]);
                }
            }
        }

        return score;
    }



}
