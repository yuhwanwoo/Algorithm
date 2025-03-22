package baekjoon.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1244 {
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (s == 1) {
                maleSwitch(num - 1);
            }
            if (s == 2) {
                femaleSwitch(num - 1);
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
            if ((i + 1) % 20 == 0)
                System.out.println();
        }
    }

    private static void femaleSwitch(int site) {
        int size = 0;
        for (int i = 1; i < arr.length; i++) {
            int start = site - i;
            int end = site + i;
            if (start < 0 || end >= arr.length) {
                break;
            }
            if (arr[start] == arr[end]) {
                size++;
            } else {
                break;
            }
        }

        inversionSwitch(site);
        for (int i = 1; i <= size; i++) {
            inversionSwitch(site + i);
            inversionSwitch(site - i);
        }
    }

    private static void maleSwitch(int num) {
        for (int i = num; i < arr.length; i += (num + 1)) {
            inversionSwitch(i);
        }
    }

    private static void inversionSwitch(int site) {
        if (arr[site] == 1) {
            arr[site] = 0;
        } else {
            arr[site] = 1;
        }
    }
}
