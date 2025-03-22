package baekjoon.boj2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _9081 {

    static String pre_word;

    static String[] arr;
    static boolean[] visited;
    static String[] output;
    static int  n;
    static int  r;
    static boolean flag;
    static String input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            input = br.readLine();
            arr = input.split("");

            flag = false;
            n = arr.length;
            r = n;

            output = new String[n];
            pre_word = "";
            visited = new boolean[n];

            Arrays.sort(arr);

            permutations(0);

        }
    }

    public static void permutations(int depth) {
        if (depth == r) {

            String out = String.join("", output);
            System.out.println(out);
            if (pre_word.equals(input)) {
//                System.out.println(out);
                flag = true;
                return;
            }

            pre_word = out;


            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                permutations(depth + 1);
                if (flag) {
                    return;
                }
                output[depth] = ""; // 이 줄은 없어도 됨
                visited[i] = false;;
            }
        }

    }
}
