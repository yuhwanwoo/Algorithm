package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int answer = 0;

        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            map.put(br.readLine(), 1);
        }

        for(int i = 0; i < m; i++) {
            if(map.get(br.readLine()) != null) {
                answer += 1;
            }
        }
        System.out.println(answer);
    }
}
