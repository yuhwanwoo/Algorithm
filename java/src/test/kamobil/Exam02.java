package test.kamobil;

import java.util.HashMap;

public class Exam02 {
    public static void main(String[] args) {
        int n = 4;
        int[] A = {1, 2, 4, 4, 3};
        int[] B = {2, 3, 1, 3, 1};
        System.out.println("solution(n, A, B) = " + solution(n, A, B));
    }

    private static HashMap<Integer, HashMap<Integer, Boolean>> graph = new HashMap<>();

    public static boolean solution(int N, int[] A, int[] B) {
        // Implement your solution here
        for (int i = 1; i <= N; i++) {
            graph.put(i, new HashMap<>());
        }
        for (int i = 0; i < A.length; i++) {
            graph.get(A[i]).put(B[i], true);
            graph.get(B[i]).put(A[i], true);
        }

        return dfs(1, N);
    }

    private static boolean dfs(int depth, int maxNode) {
        if (depth == maxNode) {
            return true;
        }
        if (graph.get(depth).containsKey(depth + 1)) {
            return dfs(depth + 1, maxNode);
        }
        return false;
    }
}
