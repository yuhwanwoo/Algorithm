package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class _5875 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int size = input.length();

        int left_bracket = 0;
        int right_bracket = 0;
        int total_bracket = 0;
        int result = 0;

        String[] arr = input.split("");

        int[] judge = new int[3];

        for (int i = 0; i < size; i++) {
            if (arr[i].equals("(")) {

                left_bracket += 1;
                total_bracket += 1;
            }else {
                right_bracket += 1;
                total_bracket -= 1;
            }

            System.out.println("total: " + total_bracket);
            System.out.println("left: " + left_bracket);
            System.out.println("right: " + right_bracket);
            System.out.println("===================");
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
