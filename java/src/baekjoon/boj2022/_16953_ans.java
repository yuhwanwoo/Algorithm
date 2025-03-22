package baekjoon.boj2022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _16953_ans {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int cnt = 1;
        while (A != B){
            if (B < A) {
                System.out.println(-1);
                System.exit(0);
            }
            if (B % 10 == 1) B /= 10;
            else if (B % 2 == 0) B /= 2;
            else {
                System.out.println(-1);
                System.exit(0);
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
