package baekjoon.boj2025;

import java.util.*;

public class _2661_ans {

    static int start = 1;
    static int end = 3;
    static int n;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        backtracking("");
    }

    public static void backtracking(String str) {
        if(str.length() == n) {
            System.out.println(str);
            System.exit(0);
        }

        for(int i = start; i <= end; i++) {
            if(can_make_str(str + i)) backtracking(str + i);
        }
    }

    public static boolean can_make_str(String str) {
        for(int i = 1; i <= str.length() / 2; i++) {
            String front = str.substring(str.length() -i * 2, str.length() - i);
            String back = str.substring(str.length() - i, str.length());
            if(front.equals(back)) return false;
        }
        return true;
    }
}

