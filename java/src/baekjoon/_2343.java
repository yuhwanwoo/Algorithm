package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        int s = 0;
        int e = 0;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            arr[i] = input;
            e += input;
            answer += input;
        }

        while (s <= e) {
            int mid = (s + e) / 2;

            int size = 0;
            int cnt = 0;
            boolean flag = false;

            for (int i = 0; i < n; i++) {
                int lec = arr[i];
                if (lec > mid) {
                    flag = true;
                    break;
                }
                size += lec;
                if (size > mid) {
                    size -= lec;
                    cnt += 1;
                    size = lec;
                }
            }

            if (flag) {
                s = mid + 1;
                continue;
            }

            if (size <= mid) {
                cnt += 1;
            }else {
                cnt += 2;
            }

            if (cnt <= m) {
                e = mid - 1;
                answer = Math.min(answer, mid);
            }else{
                s = mid + 1;
            }
        }

        System.out.println(answer);

    }
}
