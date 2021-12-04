package baekjoon;

import java.util.*;
import java.io.*;

public class _2660 {
    public static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][n + 1];

        for(int i = 0; i < n + 1; i++) {
            for(int j = 0; j < n + 1; j++) {
                if(i == j) {
                    continue;
                }else {
                    arr[i][j] = INF;
                }
            }
        }

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if(s == -1 && e == -1) {
                break;
            }
            arr[s][e] = 1;
            arr[e][s] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    arr[a][b] = Math.min(arr[a][b], arr[a][k] + arr[k][b]);
                }
            }
        }

        int[] answer = new int[n + 1];
        int min = INF;

        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                if(i == j) {
                    continue;
                }
                answer[i] = Math.max(answer[i], arr[i][j]);

            }
            min = Math.min(min, answer[i]);
        }


        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 1; i < n + 1; i++) {
            if(answer[i] == min) {
                ans.add(i);
            }
        }

        System.out.println(min + " " + ans.size());
        for(int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}

