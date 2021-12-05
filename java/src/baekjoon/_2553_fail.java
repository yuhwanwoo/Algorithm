package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2553_fail {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long mul = 1l;
        for (int i = 1; i < n + 1; i++) {
            mul *= i;
        }

        if (mul % 10 == 0) {
            System.out.println(mul / 10);
        }else{
            System.out.println(mul % 10);
        }
    }
}
