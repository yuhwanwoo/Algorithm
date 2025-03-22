package baekjoon.boj2022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class _6443 {

    static String[] arr;
    static boolean[] visited;
    static String[] output;
    static int  n;
    static int  k;
    static PriorityQueue<String> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tc; i++) {
            String str = br.readLine();
            arr = str.split("");
            int size = str.length();
            k = size;
            n = size;
            output = new String[size];
            visited = new boolean[size];

            permutations(0);

            int len = pq.size();



            for (int j = 0; j < len; j++) {
                sb.append(pq.poll() + "\n");
            }
        }

        System.out.println(sb);


    }

    private static void permutations(int depth) {
        if (depth == k) {
            String joinStr = String.join("", output);
            pq.add(joinStr);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                permutations(depth + 1);
                visited[i] = false;
            }
        }

    }
}
