package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2798 {
    static int[] arr;
    static int[] output;
    static int  n;
    static int  m;
    static int  r;
    static int answer;
    static int gap = 300000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        output = new int[n];
        r = 3;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        combinations(0, 0);
        
        // 조합으로 풀자
        System.out.println(answer);
    }

    public static void combinations(int depth, int start) {
        if (depth == r) {
            int sum = 0;
            for(int i = 0; i < r; i++) {
                sum += output[i];
            }
            if (sum <= m) {
                int tmp_gap = Math.abs(sum - m);
                if (gap >= tmp_gap) {
                    gap = tmp_gap;
                    answer = sum;
                }
            }
            return;
        }


        for (int i = start; i < n; i++) {
            output[depth] = arr[i];
            combinations(depth + 1, i + 1);
            output[depth] = 0; // 이 줄은 없어도 됨
        }
    }
}
