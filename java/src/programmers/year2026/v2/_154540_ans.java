package programmers.year2026.v2;

import java.util.*;

public class _154540_ans {
    private boolean[][] visited;
    private String[] maps;
    public int[] solution(String[] maps) {
        this.visited = new boolean[maps.length][maps[0].length()];
        this.maps = maps;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (visited[i][j]) continue;
                int sum = explore(i, j);
                if (sum == 0) continue;
                list.add(sum);
            }
        }
        if (list.size() > 0) {
            int[] ret = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                ret[i] = list.get(i);
            }
            Arrays.sort(ret);
            return ret;
        }
        return new int[] {-1};

    }

    private int explore (int i, int j) {
        visited[i][j] = true;
        char cur = maps[i].charAt(j);
        if (cur == 'X') return 0;
        int sum = parseInt(cur);
        if (i - 1 >= 0 && !visited[i - 1][j]) sum += explore(i - 1, j);
        if (i + 1 < maps.length && !visited[i + 1][j]) sum += explore (i + 1, j);
        if (j - 1 >= 0 && !visited[i][j - 1]) sum += explore(i, j - 1);
        if (j + 1 < maps[i].length() && !visited[i][j + 1]) sum += explore(i, j + 1);
        return sum;
    }

    private int parseInt(char s) {
        return (int) s - 48;
    }
}
