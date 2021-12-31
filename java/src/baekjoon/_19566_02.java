package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _19566_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long sum = 0L;
        long answer = 0L;

        HashMap<Long, Long> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n + 1; i ++) {
            long now = Long.parseLong(st.nextToken());
            sum += now;

            long key = sum - (k * i);

            if (map.containsKey(key)) {
                answer += map.get(key);
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1L);
            }
        }

        System.out.println(answer + map.getOrDefault(0L, 0L));
    }
}
