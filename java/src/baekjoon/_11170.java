package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int answer = 0;
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            for (int j = n; j < m + 1; j++) {
                String now = Integer.toString(j);

                for (int k = 0; k < now.length(); k++) {
                    if (now.charAt(k) == '0') {
                        answer += 1;
                    }
                }
            }

            System.out.println(answer);
        }
    }
}
