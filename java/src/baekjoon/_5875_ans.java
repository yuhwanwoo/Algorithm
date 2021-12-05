package baekjoon;

// https://welog.tistory.com/273?category=928922

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5875_ans {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int size = input.length();

        int left_bracket = 0;
        int right_bracket = 0;
        int total_bracket = 0;
        int result = 0;

        String[] arr = input.split("");



        for (int i = 0; i < size; i++) {
            if (arr[i].equals("(")) {
                left_bracket += 1;
                total_bracket += 1;
            }else {
                right_bracket += 1;
                total_bracket -= 1;
            }

            if (total_bracket <= 1) {
                left_bracket = 0;
            }

            if (total_bracket == -1) {
                result = right_bracket;
                break;
            }
        }

        if (total_bracket > 0) {
            result = left_bracket;
        }

        System.out.println(result);
    }
}
