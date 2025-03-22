package baekjoon.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _19948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int spaceCnt = Integer.parseInt(br.readLine());

        HashMap<Character, Integer> map = new HashMap<>();

        map.put(' ', spaceCnt);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 26; i++) {
            int alpCnt = Integer.parseInt(st.nextToken());
            map.put((char) ('A' + i), alpCnt);
        }

        String upperInput = input.toUpperCase();
        char firstChar = upperInput.charAt(0);

        String answer = firstChar + "";

        if (map.get(firstChar) < 2) {
            System.out.println(-1);
            return;
        }

        map.put(firstChar, map.get(firstChar) - 2);

        for (int i = 1; i < input.length(); i++) {
            char now = input.charAt(i);
            char prev = input.charAt(i - 1);
            char upperNow = upperInput.charAt(i);
            if (now == prev) {
                continue;
            }
            if (map.get(upperNow) < 1) {
                System.out.println(-1);
                return;
            }
            if (prev == ' ') {
                answer += upperNow;
                map.put(upperNow, map.get(upperNow) - 1);
            }

            if (map.get(upperNow) < 1) {
                System.out.println(-1);
                return;
            }
            map.put(upperNow, map.get(upperNow) - 1);
        }
        System.out.println(answer);
    }
}
