package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2805_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        Long m = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Long start = 0L;
        Long end = Long.MIN_VALUE;

        Long[] arr = new Long[n];

        for (int i = 0; i < n; i++) {
            Long input = Long.parseLong(st.nextToken());

            if (input > end) {
                end = input;
            }
            arr[i] = input;
        }

        Long answer = 0L;

        while (start <= end) {
            Long mid = ((start + end) / 2L);

            Long cutTree = 0L;
            for (int i = 0; i < n; i++) {
                if (arr[i] > mid) {
                    cutTree += (arr[i] - mid);
                }
            }
            if (cutTree < m) {
                end = mid - 1;
            } else {
                answer = mid;
                start = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
