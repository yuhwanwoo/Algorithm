package baekjoon.boj2025;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _30088_ans {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read();
        long[] sums = new long[n];

        while (n-- > 0) {
            int[] arr = new int[read()];
            for (int i = 0; i < arr.length; i++) arr[i] = read();

            Arrays.sort(arr);
            for (int i : arr) sums[n] += i;
        }

        Arrays.sort(sums);
        long sum = 0, tmp = 0;
        for (long l : sums) sum += tmp += l;

        bw.write(String.valueOf(sum));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
