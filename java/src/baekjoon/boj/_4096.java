package baekjoon.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _4096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                break;
            }
            System.out.println(getPalindrome(input));
        }

    }

    private static int getPalindrome(int input) {
        int answer = 0;
        while (true) {
            int temp = input + answer;
            if (isPalindrome(temp)) {
                return answer;
            }
            answer++;
        }
    }

    private static boolean isPalindrome(int temp) {
        System.out.println("temp = " + temp);
        int length = (int) Math.log10(temp) + 1;
        for (int i = 0; i < (length / 2); i++) {
            System.out.println("temp % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i) = " + temp % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i));
            System.out.println("temp % (int) Math.pow(10, length - i) / (int) Math.pow(10, length - i - 1) = " + temp % (int) Math.pow(10, length - i) / (int) Math.pow(10, length - i - 1));
            System.out.println(" ================================");
            if (temp % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i) != temp % (int) Math.pow(10, length - i) / (int) Math.pow(10, length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
