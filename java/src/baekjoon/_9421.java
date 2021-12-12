package baekjoon;

import java.io.*;
import java.util.*;


public class _9421 {
    static boolean[] judge = new boolean[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            if (PrimeNum(i)) {
                answer.add(i);
            }
        }

    }

    public static boolean PrimeNum(int n) {
        if (judge[n]) {
            return true;
        }

        

        return false;
    }
}
