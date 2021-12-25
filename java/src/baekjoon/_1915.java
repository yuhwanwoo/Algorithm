package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1915 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        int answer = 0;

        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(tmp[j]);
                if (arr[i][j] == 1) {
                    answer = 1;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (arr[i][j] == 1) {
                    if (arr[i - 1][j] != 0 && arr[i - 1][j - 1] != 0 && arr[i][j - 1] != 0) {
                        int tmp = Math.min(arr[i - 1][j], arr[i - 1][j - 1]);
                        tmp = Math.min(tmp, arr[i][j - 1]);
                        arr[i][j] = tmp + 1;

                        answer = Math.max(answer, arr[i][j]);
                    }
                }
            }
        }

        System.out.println(answer * answer);

    }
}
