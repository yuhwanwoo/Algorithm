package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 1번에서 출발하는 걸로 생각해보자
        int[] amount = new int[n + 1];

        for(int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String t = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            if (t.equals("W")) {
                a = -a;
            }
            amount[i + 2] = a;
        }

        for (int i : amount) {
            System.out.print(i + " ");
        }
    }
}
