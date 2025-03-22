package baekjoon.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17123 {
    private static int n;
    private static int m;
    private static int[][] arr;
    private static int[] rows;
    private static int[] cols;
    private static int r1;
    private static int c1;
    private static int r2;
    private static int c2;
    private static int v;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;

        while (t != 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            arr = new int[n][n];
            rows = new int[n];
            cols = new int[n];

            int input;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    input = Integer.parseInt(st.nextToken());
                    rows[i] += input;
                    cols[j] += input;
                }
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                r1 = Integer.parseInt(st.nextToken());
                c1 = Integer.parseInt(st.nextToken());
                r2 = Integer.parseInt(st.nextToken());
                c2 = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());

                for (int j = r1 - 1; j < r2; j++) {
                    rows[j] += (c2 - c1 + 1) * v;
                }

                for (int j = c1 - 1; j < c2; j++) {
                    cols[j] += (r2 - r1 + 1) * v;
                }
            }

            print();

            t--;
        }
    }

    private static void print() {
        for (int row : rows) {
            System.out.print(row + " ");
        }

        System.out.println();

        for (int col : cols) {
            System.out.print(col + " ");
        }
    }
}
