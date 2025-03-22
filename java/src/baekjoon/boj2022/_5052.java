package baekjoon.boj2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];

            for(int j = 0; j < n; j++) {
                arr[j] = br.readLine();
            }

            Arrays.sort(arr);

            boolean flag = false;
            if(judge(n, arr)){
                System.out.println("YES");
            } else{
                System.out.println("NO");
            }

        }
    }

    public static boolean judge(int size, String[] arr) {

        for (int i = 1; i < size; i++) {
            if (arr[i].startsWith(arr[i - 1])) {
                return false;
            }
        }
        // 깃 오류 확인2
        return true;
    }
}