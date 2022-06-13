package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16943 {
    static String[] arr;
    static boolean[] visited;
    static String[] output;
    static int  n;
    static int  k;
    static int answer = -1;
    static Integer b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        b = Integer.parseInt(st.nextToken());
        k = a.length();
        n = k;

        arr = a.split("");
        visited = new boolean[n];
        output = new String[n];

        permutations(0);

        System.out.println(answer);
    }

    private static void permutations(int depth) {
        if (depth == 1) {
            if (output[0].equals("0")) {
                return;
            }
        }
        if (depth == k) {
            Integer joinNum = Integer.parseInt(String.join("", output));
            if (answer < joinNum && joinNum < b) {
                answer = joinNum;
            }
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
