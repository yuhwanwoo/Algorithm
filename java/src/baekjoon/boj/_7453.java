package baekjoon.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _7453 {
    private static int[][] arr;
    private static long[] AB;
    private static long[] CD;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n][4];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int index = 0;
        AB = new long[n * n];
        CD = new long[n * n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                AB[index] = arr[i][0] + arr[j][1];
                CD[index] = arr[i][2] + arr[j][3];
                index++;
            }
        }

        long answer = 0;
        Arrays.sort(AB);
        Arrays.sort(CD);

        for (long target : AB) {
            int lowerBound = lowerBound(CD, -target);
            int upperBound = upperBound(CD, -target);
            answer += (upperBound - lowerBound);
        }

        System.out.println(answer);
    }

    private static int lowerBound(long[] arr, long target) {
        int begin = 0;
        int end = arr.length;

        while (begin < end) {
            int mid = (begin + end) / 2;

            if (arr[mid] >= target) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        return end;
    }

    private static int upperBound(long[] arr, long target) {
        int begin = 0;
        int end = arr.length;

        while (begin < end) {
            int mid = (begin + end) / 2;

            if (arr[mid] <= target) {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }
}
