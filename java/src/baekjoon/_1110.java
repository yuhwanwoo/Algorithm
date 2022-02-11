package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int now = n;
        int answer = 0;

        while (true) {
            int left = now / 10;
            int right = now % 10;
            now = right * 10 + (left + right) % 10;
            answer += 1;
            if (n == now) {
                break;
            }
        }

        System.out.println(answer);


    }
}
