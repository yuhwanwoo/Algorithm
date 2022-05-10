package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        getDiff(A, B);
    }

    private static void getDiff(String a, String b) {
        int answer = 0;
        int aSize = a.length();
        int bSize = b.length();
        if (aSize == bSize) {
            for (int i = 0; i < aSize; i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    answer += 1 ;
                }
            }
            System.out.println(answer);
            return;
        }

        answer = Integer.MAX_VALUE;

        for (int i = 0; i <= bSize - aSize; i++) {
            int tempCnt = 0;
            for (int j = 0; j < aSize; j++) {
                if (a.charAt(j) != b.charAt(i + j)) {
                    tempCnt += 1;
                }
            }
            answer = Math.min(tempCnt, answer);
        }

        System.out.println(answer);

        return;
    }
}
