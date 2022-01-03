package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _18868 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            ArrayList<Pair> arr = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                arr.add(new Pair(Integer.parseInt(st.nextToken()), j));
            }
        }


    }
}

class Pair {
    int x;
    int idx;

    public Pair(int x, int idx) {
        this.x = x;
        this.idx = idx;
    }
}
