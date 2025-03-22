package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Combinations {
    static int[] arr;
    static boolean[] visited;
    static int[] output;
    static int  n;
    static int  r;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];
        output = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        combinations(0, 0);

        System.out.println(answer);

    }

    public static void combinations(int depth, int start) {
        if (depth == r) {
            int sum = 0;
            for(int i = 0; i < r; i++) {
                System.out.print(output[i] + " ");
            }
            System.out.println();

            return;
        }

        for (int i = start; i < n; i++) {
            output[depth] = arr[i];
            combinations(depth + 1, i + 1);
            output[depth] = 0; // 이 줄은 없어도 됨
        }
    }
}
