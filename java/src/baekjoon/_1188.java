package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1188 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int gc = GCD(n, m);

        System.out.println(m - gc);
    }

    public static int GCD(int n1, int n2) {
        if(n1 % n2 == 0) {
            return n2;
        }else{
            return GCD(n2, n1 % n2);
        }
    }
}
