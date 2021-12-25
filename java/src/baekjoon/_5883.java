package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5883 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        int max_num = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            if (max_num < num) {
                max_num = num;
            }
        }

        int answer = 0;
        int[] visited = new int[max_num + 1];

        for (int i = 0; i < n; i++) {
            int now = arr[i];
            if (visited[now] != 0) {
                continue;
            }
            int cnt = 0;
            int prev = -1;
            for (int j = 0; j < n; j++) {
                if (arr[j] == now) {
                    continue;
                }
                if (arr[j] != prev) {
                    prev = arr[j];
                    cnt = 1;
                }else {
                    cnt += 1;
                }
                answer = Math.max(cnt, answer);
            }
        }

        System.out.println(answer);

    }
}
