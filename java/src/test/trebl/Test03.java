package test.trebl;

import java.util.ArrayList;
import java.util.Arrays;

public class Test03 {
    private static boolean[] visited;
    private static int[] output;
    private static ArrayList<ArrayList<Integer>> permutationsResult = new ArrayList<>();
    private static int n;
    private static int targetDiff;

    public static void main(String[] args) {
        solution(new int[]{10, 40, 30, 20}, 20);

    }

    private static int solution(int[] numbers, int k) {
        visited = new boolean[numbers.length];
        output = new int[numbers.length];
        targetDiff = k;

        permutations(numbers, 0);
        int answer = Integer.MAX_VALUE;

        if (permutationsResult.isEmpty()) {
            return -1;
        }

        for (ArrayList<Integer> integers : permutationsResult) {

        }

        return answer;
    }
    private static void permutations(int[] numbers, int depth) {
        if (depth == n) {
            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                result.add(output[i]);
            }
            permutationsResult.add(result);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = numbers[i];
                permutations(numbers, depth + 1);
                visited[i] = false;
            }
        }
    }
// 10 차이 테스트
//    private boolean validNumber
}
