package baekjoon.boj2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int answer = 1;

        while (answer <= 1000000) {
            int now = answer;

            int seg_sum = 0;

            while(now != 0) {
                seg_sum += (now % 10);

                now /= 10;
            }

            if (answer + seg_sum == n) {
                break;
            }


            answer += 1;
        }


        if (answer == 1000001) {
            System.out.println(0);
        }else{
            System.out.println(answer);
        }
    }
}
