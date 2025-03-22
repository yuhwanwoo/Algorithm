package baekjoon.boj2022;

import java.util.*;

public class _2660_ans {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int max = 251;

        int[][] friend = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                friend[i][j] = max;
            }
        }

        while(true) {
            int n1 = scan.nextInt();
            int n2 = scan.nextInt();
            if(n1 == -1 && n2 == -1) break;
            friend[n1][n2] = 1;
            friend[n2][n1] = 1;
        }

        for(int k = 1; k <= n; k++) {
            friend[k][k] = 1;
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(friend[i][j] > friend[i][k] + friend[k][j]) {
                        friend[i][j] = friend[i][k] + friend[k][j];
                    }
                }
            }
        }

        int[] scores = new int[n + 1];
        int min = Integer.MAX_VALUE; //회장 점수
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                scores[i] = Math.max(scores[i], friend[i][j]);
            }
            min = Math.min(min, scores[i]);
        }

        ArrayList<Integer> list = new ArrayList<>(); //회장 후보 목록
        for(int i = 1; i <= n; i++) {
            if(scores[i] == min) list.add(i);
        }

        System.out.println(min + " " + list.size());
        for(int temp : list) {
            System.out.print(temp + " ");
        }
    }
}
