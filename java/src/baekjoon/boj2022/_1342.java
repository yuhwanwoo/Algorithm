package baekjoon.boj2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class _1342 {
    static char[] arr;
    static boolean[] visited;
    static char[] output;
    static int  n;
    static HashMap<String, Boolean> map = new HashMap<>();
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        n = input.length();
        arr = input.toCharArray();
        visited = new boolean[n];
        output = new char[n];

        permutations(0);

        /**
         *  aaab
         *
         *  baaa
         *  abaa
         *  bbab
         *
         *
         */
        System.out.println(answer);
    }

    public static void permutations(int depth) {
        if (depth == n) {
            if (check()) {
                answer += 1;
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                permutations(depth + 1);
                output[depth] = 0; // 이 줄은 없어도 됨
                visited[i] = false;;
            }
        }
    }

    public static boolean check() {
        for(int i = 0; i < output.length - 1; i++) {
            if(output[i] == output[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
