package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MAX_VALUE;
        int ans1 = 0;
        int ans2 = 0;

        for (int i = 0; i < n - 1; i++) {
            int now = arr[i];
            int target = now * -1;
//            System.out.println("target : " + target);
            int tmp = binary_search(i + 1, n, target, arr, n);
//            System.out.println(tmp);
            int sum = Math.abs(arr[i] + tmp);
            if (Math.abs(answer) >= sum) {
                answer = sum;
                ans1 = arr[i];
                ans2 = tmp;
            }
        }

        System.out.println(ans1 + " " + ans2);

    }

    public static int binary_search(int start, int end, int target, int[] arr, int n) {
        int mid = 0;
        while (start < end) {
            mid = (start + end) / 2;

            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid;
            } else {
                return target;
            }
        }
        System.out.println(mid);
        if (mid == n - 1) {
            return arr[mid];
        }

        if (Math.abs(arr[mid] - target) <= Math.abs(arr[mid + 1] - target)) {
            return arr[mid];
        } else {
            return arr[mid + 1];
        }
    }
}
