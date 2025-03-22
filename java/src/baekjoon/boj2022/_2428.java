package baekjoon.boj2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2428 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            arr[i] = input;
        }

        Arrays.sort(arr);

        Long answer = 0L;

        for (int i = 0; i < n; i++) {
            int left = i;
            int right = n - 1;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (arr[i] >= arr[mid] * 0.9) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            answer += left - i - 1;
        }

        System.out.println(answer);
    }
}
