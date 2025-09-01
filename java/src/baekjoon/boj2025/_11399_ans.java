package baekjoon.boj2025;

import java.io.*;
import java.util.*;

public class _11399_ans {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        // Pi 값들 입력 받기
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //배열을 오름차순으로 정렬
        Arrays.sort(arr);
        int sum = 0;  //총 합
        int add = 0;  //더할 수
        for (int i = 0; i < n; i++) {
            add += arr[i];
            sum += add;
        }
        System.out.print(sum);
    }
}
