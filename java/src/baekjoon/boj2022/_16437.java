package baekjoon.boj2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _16437 {

    static HashMap<Integer, Nod> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n + 1; i++) {
            map.put(i, new Nod(0, new ArrayList<Integer>()));
        }

        for(int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String t = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            if (t.equals("W")) {
                a = -a;
            }
            map.get(p).arr.add(i + 2);
            map.get(i + 2).amount = a;
        }

        System.out.println(dfs(1));
    }

    public static long dfs(int now) {

        long now_amount = map.get(now).amount;
        for(int next : map.get(now).arr) {

            now_amount += dfs(next);
        };

        if(now_amount < 0) {
            map.get(now).amount = now_amount;
            return 0;
        }else {
            return now_amount;
        }
    }
}

class Nod {
    long amount;
    ArrayList<Integer> arr;
    public Nod(int amount, ArrayList<Integer> arr) {
        this.amount = amount;
        this.arr = arr;
    }
}
