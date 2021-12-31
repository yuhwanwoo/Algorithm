package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _19566 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        HashMap<Long, Long> map = new HashMap<>();

        long answer = 0L;
        long now = 0L;

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            long x = Long.parseLong(st.nextToken());

            now += x;

            long r = (now - ((long)k * (i + 1)));

            if(map.containsKey(r)) {
                answer += map.get(r);
                map.put(r, map.get(r) + 1L);
            } else {
                map.put(r, 1L);
            }
        }

        System.out.println(answer + map.getOrDefault(0L, 0L));
    }

}
