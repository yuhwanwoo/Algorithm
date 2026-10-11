package programmers.year2026.v2;

import java.util.ArrayList;

public class _388352 {
    private static int answer = 0;
    private static boolean[] visited;

    static void main() {
        int n = 10;
        int[][] q = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {3, 7, 8, 9, 10},
                {2, 5, 7, 9, 10},
                {3, 4, 5, 6, 7}
        };
        int[] ans = {2, 3, 4, 3, 3};
        solution(n, q, ans);
        answer = 0;
        int n1 = 15;
        int[][] q1 = {{2, 3, 9, 12, 13}, {1, 4, 6, 7, 9}, {1, 2, 8, 10, 12}, {6, 7, 11, 13, 15}, {1, 4, 10, 11, 14}};
        int[] ans1 = {2, 1, 3, 0, 1};
        solution(n1, q1, ans1);

    }

    public static int solution(int n, int[][] q, int[] ans) {
        visited = new boolean[n + 1];
        combination(1, new ArrayList<>(), q, ans);
        return answer;
    }

    private static void combination(int depth, ArrayList<Integer> element, int[][] q, int[] ans) {
        if (element.size() == 5) {
            if (isPossible(element, q, ans)) {
                answer++;
            }
            return;
        }
        for (int i = depth; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                element.add(i);
                combination(i + 1, element, q, ans);
                element.remove(element.size() - 1);
                visited[i] = false;
            }
        }
    }

    private static boolean isPossible(ArrayList<Integer> element, int[][] q, int[] ans) {
        for (int i = 0; i < q.length; i++) {
            int count = 0;
            for (int j = 0; j < q[i].length; j++) {
                for (int k = 0; k < 5; k++) {
                    if (element.get(k) == q[i][j]) {
                        count++;
                        break;
                    }
                }
            }
            if (count != ans[i]) {
                return false;
            }
        }
        return true;
    }


}
