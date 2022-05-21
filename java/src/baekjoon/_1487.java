package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _1487 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Pair> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int maxPrice = Integer.parseInt(st.nextToken());
            int deliveryFee = Integer.parseInt(st.nextToken());

            list.add(new Pair(maxPrice, deliveryFee));
        }

        Collections.sort(list);

        int answer = 0;

        int benefit = 0;

        int tmp_benefit = 0;

        for (int i = 0; i < n; i++) {
            Pair now = list.get(i);
            tmp_benefit = 0;
            for (int j = i; j < n; j++) {
                Pair comp = list.get(j);
                if (comp.y <= now.x) {
                    tmp_benefit += (now.x - comp.y);
                }
            }
            if (tmp_benefit > benefit) {
                benefit = tmp_benefit;
                answer = now.x;
            }
        }
        
        System.out.println(answer);
    }

    private static class Pair implements Comparable{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // todo
        // x 같은 것이 문제가 될 수도 있다.
        @Override
        public int compareTo(Object o) {
            return x - ((Pair)o).x;
        }
    }
}
