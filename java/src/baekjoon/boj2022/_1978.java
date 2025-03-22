package baekjoon.boj2022;

import java.util.*;
import java.io.*;

public class _1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            arr[i] = input;
            if(input > 2) {
                if(isPrime(input)) {
                    answer += 1;
                }
            }
            if(input == 2){
                answer += 1;
            }
        }

        System.out.println(answer);

    }

    public static boolean isPrime(int n) {
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
