package baekjoon.boj2025;

import java.io.*;

public class _2577_ans {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        int[] arr = new int[10];
        int sum = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine());
        String str = Integer.toString(sum);
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < 10; j++) {
                if ((str.charAt(i) - '0') == j) {
                    ++arr[j];
                    break;
                }
            }
        }

        for(int i=0; i<10;i++) {
            bw.write(arr[i]+"\n");
        }
        bw.flush();
    }


}
