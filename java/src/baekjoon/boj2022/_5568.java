package baekjoon.boj2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class _5568 {
    private static HashSet<String> set = new HashSet<>();
    static String[] arr;
    static boolean[] visited;
    static String[] output;
    static int  n;
    static int  k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new String[n];
        visited = new boolean[n];
        output = new String[k];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            arr[i] = input;
        }

        permutations(0);

        System.out.println(set.size());


    }

    private static void permutations(int depth) {
        if (depth == k) {
            String joinNum = String.join("", output);
            set.add(joinNum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                permutations(depth + 1);
                visited[i] = false;;
            }
        }

    }
}
