package programmers.lv2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _388353_ans {
    static void main() {

    }
    private static final int[][] movements = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static Queue<int[]> exposureQueue;
    private static boolean[][] isExposed;
    private static char[][] map;

    public static int solution(String[] storage, String[] requests) {
        init(storage);
        for (String request : requests) {
            char target = request.charAt(0);
            if (request.length() == 2) {
                removeAll(target);
            } else {
                removeExposed(target);
            }
        }
        int answer = 0;
        for (char[] m : map) {
            for (char c : m) {
                answer += c == 0 ? 0 : 1;
            }
        }
        return answer;
    }

    private static void init(String[] storage) {
        int row = storage.length;
        int col = storage[0].length();
        map = new char[row][col];
        isExposed = new boolean[row][col];
        exposureQueue = new LinkedList<>();

        Arrays.fill(isExposed[0], true);
        Arrays.fill(isExposed[row - 1], true);

        for (int i = 0; i < isExposed.length; i++) {
            isExposed[i][0] = isExposed[i][col-1] = true;
        }

        for (int i = 0; i < row; i++) {
            map[i] = storage[i].toCharArray();
        }
    }

    private static void removeAll(char c) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == c) {
                    map[i][j] = 0;
                    if (isExposed[i][j]) {
                        exposureQueue.offer(new int[]{i, j});
                    }
                }
            }
        }
        spanExposure();
    }

    private static void removeExposed(char c) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == c && isExposed[i][j]) {
                    map[i][j] = 0;
                    exposureQueue.offer(new int[]{i, j});
                }
            }
        }
        spanExposure();
    }

    private static void spanExposure() {
        while (!exposureQueue.isEmpty()) {
            int[] current = exposureQueue.poll();
            int r = current[0];
            int c = current[1];
            for (int[] m : movements) {
                int nR = r + m[0];
                int nC = c + m[1];
                if (nR < 0 || nR >= map.length || nC < 0 || nC >= map[0].length || isExposed[nR][nC]) {
                    continue;
                }
                isExposed[nR][nC] = true;
                if (map[nR][nC] == 0) { // 추가로 노출된 부분이 빈칸 일 때 노출이 전파되어야 한다
                    exposureQueue.offer(new int[]{nR, nC});
                }
            }
        }
    }
}
