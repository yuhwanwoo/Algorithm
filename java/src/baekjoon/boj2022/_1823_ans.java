package baekjoon.boj2022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1823_ans {
    public static int[] rice_plant = new int[2001];
    public static int[][] dp = new int[2001][2001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int rice_num = Integer.parseInt(br.readLine());

        for (int x = 1; x <= rice_num; x++) {
            rice_plant[x] = Integer.parseInt(br.readLine());
        }

        bw.write(String.valueOf(cut(1, rice_num, 1)));
        bw.flush();
        bw.close();
        br.close();

    }

    public static int cut(int start,int end,int num) {

        if(start>end)
            return 0;

        if(dp[start][end]!=0)
            return dp[start][end];

        int first = cut(start + 1, end, num + 1) + num * rice_plant[start];
        int last = cut(start, end - 1, num + 1) + num * rice_plant[end];

        dp[start][end] = Math.max(first, last);

        return dp[start][end];


    }
}
