package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1487_fail {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int benefit = 0;

        int gap;

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int maxPrice = Integer.parseInt(st.nextToken());
            int deliveryFee = Integer.parseInt(st.nextToken());
            gap = maxPrice - deliveryFee;
            if (benefit <= gap) {
                benefit = gap;
                if (answer > maxPrice && benefit == gap) {
                    answer = maxPrice;
                    continue;
                }
                answer = maxPrice;
            }
        }

        System.out.println("answer = " + answer);
    }
}
