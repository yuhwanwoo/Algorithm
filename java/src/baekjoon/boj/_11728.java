package baekjoon.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] firstArray = new int[n];
        int[] secondArray = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            firstArray[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            secondArray[i] = Integer.parseInt(st.nextToken());
        }

        int idxA = 0;
        int idxB = 0;

        while (idxA != n || idxB != m) {
            if (idxA == n) {
                bw.write(secondArray[idxB] + " ");
                idxB++;
            } else if (idxB == m) {
                bw.write(firstArray[idxA] + " ");
                idxA++;
            } else {
                if (firstArray[idxA] > secondArray[idxB]) {
                    bw.write(secondArray[idxB] + " ");
                    idxB++;
                }
                else {
                    bw.write(firstArray[idxA] + " ");
                    idxA++;
                }
            }
        }

        bw.close();
    }
}
