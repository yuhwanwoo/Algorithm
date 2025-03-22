package baekjoon.boj2022;

import java.io.*;
import java.util.*;

public class _2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Long start = 0L;
        Long end = 0L;

        Long[] arr = new Long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            if (arr[i] > end) {
                end = arr[i];
            }
        }

        Long answer = 0L;

        while (start <= end) {
            Long mid = (start + end) / 2;
            Long sum = 0L;
            for (int i = 0; i < n; i++) {
                if (arr[i] > mid) {
                    sum += (arr[i] - mid);
                    if (sum > m) {
                        break;
                    }
                }
            }

            if (sum < m) {
                end = mid - 1;
            }else {
                answer = mid;
                start = mid + 1;
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}
