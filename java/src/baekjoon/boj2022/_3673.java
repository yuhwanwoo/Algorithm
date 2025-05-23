package baekjoon.boj2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://jaimemin.tistory.com/1160

// 누적합 예상
public class _3673 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (c != 0) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int sum = 0 ;

            long[] arr = new long[d];

            arr[sum]++;
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                int input = Integer.parseInt(st.nextToken());

                sum = (sum + input) % d;
                arr[sum] += 1;
            }

            System.out.println(Arrays.toString(arr));

            long result = 0l;
            for (int i = 0; i < d; i++) {
                long tmp = arr[i] * (arr[i] - 1) / 2;

                // 누적합이므로 누적합의 mod에 대한 정보를 가지고 있는다.
                // 그리고 같은 mod를 갖는 2가지를 고르면 되므로 nC2를 진행하면된다.
                System.out.println("tmp = " + tmp);
                result += tmp;
            }

            System.out.println(result);


            c--;
        }
    }
}
