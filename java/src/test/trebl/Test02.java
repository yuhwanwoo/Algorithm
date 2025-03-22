package test.trebl;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Test02 {
    private static int r = 0;
    private static int c = 0;
    private static boolean[][] visited;
    private static String[][] graph;

    public static void main(String[] args) {
        String[] maps = {"1101110000", "1100001000", "1000011000", "0000000000", "0000100100", "1110101111"};
        solution(maps);
    }

    private static int[] solution(String[] maps) {
        HashSet<Integer> set = new HashSet<>();
        visited = new boolean[maps.length][maps[0].length()];
        graph = new String[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            graph[i] = maps[i].split("");
        }
        r = maps.length;
        c = maps[0].length();

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (visited[i][j] || graph[i][j].equals("0")) {
                    continue;
                }
                set.add(dfs(i, j));
            }
        }

        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    private static int dfs(int x, int y) {
        if (x < 0 || x >= r || y < 0 || y >= c) {
            return 0;
        }

        if (visited[x][y] || graph[x][y].equals("0")) {
            return 0;
        }

        visited[x][y] = true;
        int size = 1;
        size += dfs(x - 1, y);
        size += dfs(x, y - 1);
        size += dfs(x + 1, y);
        size += dfs(x, y + 1);

        return size;

    }
}
