package baekjoon.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        input = input.replaceAll("c=", "1");
        input = input.replaceAll("c-", "1");
        input = input.replaceAll("dz=", "1");
        input = input.replaceAll("d-", "1");
        input = input.replaceAll("lj", "1");
        input = input.replaceAll("nj", "1");
        input = input.replaceAll("s=", "1");
        input = input.replaceAll("z=", "1");

        System.out.println(input.length());
    }
}