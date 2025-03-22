package baekjoon.boj2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://arinnh.tistory.com/46

public class _2553_ans {
    public static void main(String [] args) throws IOException {
        int N, temp, dp[];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N= Integer.parseInt(br.readLine());
        dp= new int[N+1];

        //2^n digit: 2 4 6 8
        dp[1]= 1;
        dp[2]= 2;
        dp[3]= 6;
        dp[4]= 4;

        for(int i=5; i<=N; i++) {
            if(i%5==0) {
                temp= i/5;
                dp[i]= (dp[temp]*(int)Math.pow(2, temp%4))%10;
            }else{
                temp= (i/5)*5;
                dp[i]=dp[temp];
                for(int j=temp+1; j<=i; j++) {
                    dp[i]=dp[i]*j%10;
                }
            }
        }//end for

        System.out.println(dp[N]);
    }
}
