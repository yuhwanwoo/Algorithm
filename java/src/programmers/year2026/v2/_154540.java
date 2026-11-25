package programmers.year2026.v2;

import java.util.PriorityQueue;

public class _154540 {
    private static boolean[][] visited;
    private static char[][] map;
    private static PriorityQueue<Integer> pq = new PriorityQueue<>();
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

            }
        }

        return answer;
    }




}
