package baekjoon.boj2025;

import java.util.Scanner;

public class _25314_ans {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            if (i % 4 == 0) {
                System.out.print("long ");
            }
        }

        System.out.println("int");
    }
}
