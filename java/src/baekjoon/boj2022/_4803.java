package baekjoon.boj2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _4803 {
    static ArrayList<ArrayList<Integer>> arr;

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = 1;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int count = 0;
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) {
                break;
            }

            visited = new boolean[n + 1];

            arr = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                arr.add(new ArrayList<Integer>());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                arr.get(a).add(b);
                arr.get(b).add(a);
            }

//            System.out.println(arr);

            for (int i = 1; i < n + 1; i++) {
//                System.out.println(Arrays.toString(visited));
                if (visited[i]) {
                    continue;
                }
                if(dfs(i, 0)) {
                    count += 1;
//                    System.out.println("i:" + i +", count:" + count);
                }
            }

            if (count == 0) {
                System.out.println("No trees.");
            } else if (count == 1) {
                System.out.println("There is one tree.");
            }else {
                System.out.println("A forest of " + count + " trees.");
            }

            t++;
        }
    }
    public static boolean dfs(int start, int pre_node) {
        visited[start] = true;

        for (int i = 0; i < arr.get(start).size(); i++) {
            int next = arr.get(start).get(i);
//            System.out.println("start:" + start + ", next:" + next + ", preNode:" + pre_node);
            if (next == pre_node) {
                continue;
            }
            if (visited[next]) {
                return false;
            }
            if (!dfs(next, start)){
                return false;
            }
        }

        return true;
    }
}
