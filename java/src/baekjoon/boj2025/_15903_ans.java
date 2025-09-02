package baekjoon.boj2025;

import java.io.*;
import java.util.*;

public class _15903_ans {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] t = br.readLine().split(" ");

        int n = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);

        long arr []  = new long[n];

        String [] tt = br.readLine().split(" ");

        for(int i=0; i<n; i++) {
            arr[i] = Long.parseLong(tt[i]);
        }

        for(int i=0; i<m; i++) {
            Arrays.sort(arr);
            long sum = arr[0]+arr[1];
            arr[0] = sum;
            arr[1] = sum;
        }

        long ans = 0;

        for(int i=0; i<n; i++) {
            ans+=arr[i];
        }
        System.out.println(ans);
    }
}
