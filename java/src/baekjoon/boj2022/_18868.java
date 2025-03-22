package baekjoon.boj2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _18868 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        ArrayList<int[]> content = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            ArrayList<Pair> arr = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr.add(new Pair(Integer.parseInt(st.nextToken()), j));
            }

            int[] tmp = new int[n];

            Collections.sort(arr);

            for (int j = 0; j < n; j++) {
                Pair pair = arr.get(j);
                tmp[j] = pair.idx;
            }
            content.add(tmp);
        }

        int answer = 0;

        int[] visited = new int[m];

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
//                if (visited[i] == 1 || visited[j] == 1) {
//                    continue;
//                }
                if (Arrays.equals(content.get(i), content.get(j))) {
//                    visited[i] = 1;
//                    visited[j] = 1;
                    answer += 1;
                }
            }
        }

        System.out.println(answer);

    }
}

class Pair implements Comparable<Pair>{
    int x;
    int idx;

    public Pair(int x, int idx) {
        this.x = x;
        this.idx = idx;
    }


    @Override
    public int compareTo(Pair o) {
        if(this.x <= o.x) {
            if (this.x == o.x) {
                return -1;
            }
            return -1;
        }

        return 1;
    }
}
