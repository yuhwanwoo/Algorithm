package baekjoon.boj2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _12933 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char[] quack = new char[5];
        quack[0] = 'q';
        quack[1] = 'u';
        quack[2] = 'a';
        quack[3] = 'c';
        quack[4] = 'k';

        int nowIdx = 0;
        int answer = 0;

        for (int i = 0; i < input.length(); i++) {
            char now = input.charAt(i);
            if (input.charAt(i) == quack[nowIdx % 5]) {
                if (now == 'k') {
                    answer += 1;
                }
                nowIdx += 1;
            }
        }

        System.out.println("answer = " + answer);
    }
}
