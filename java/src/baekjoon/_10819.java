package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10819 {

    static int[] arr;
    static boolean[] visited;
    static int[] output;
    static int  n;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n];
        visited = new boolean[n];
        output = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        permutations(0);

        System.out.println(answer);

    }

    public static void permutations(int depth) {
        if (depth == n) {
            int sum = 0;
            for(int i = 1; i < n; i++) {
                sum += Math.abs(output[i] - output[i - 1]);
            }

            answer = Math.max(answer, sum);
            return;
        }

        for (int i=0; i<n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                permutations(depth + 1);
                output[depth] = 0; // 이 줄은 없어도 됨
                visited[i] = false;;
            }
        }

    }
}