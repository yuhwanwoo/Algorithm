package baekjoon.boj2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9996 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String pattern = br.readLine();

        String[] split = pattern.split("\\*");

        String front = split[0];
        String end = split[1];

        for (int t = 0; t < n; t++) {
            String input = br.readLine();
            if (front.length() + end.length() > input.length()) {
                System.out.println("NE");
                continue;
            }
            String input_front = input.substring(0, front.length());
            String input_end = input.substring(input.length() - end.length(), input.length());

            if (input_front.equals(front) && input_end.equals(end)) {
                System.out.println("DA");
            } else{
                System.out.println("NE");
            }
        }
    }
}
