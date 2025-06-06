package baekjoon.boj2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> map = new HashMap();

        int size = 0;

        while (true) {
            String word = br.readLine();

            if (word == null || word.equals("")) {
                break;
            }

            if (!map.containsKey(word)) {
                map.put(word, 0);
            }
            map.put(word, map.get(word) + 1);
            size += 1;
        }

        Object[] str = map.keySet().toArray();
        Arrays.sort(str);

        for(Object obj:str){
            String key = (String) obj;
            String value = String.format("%.4f", (map.get(key) * 100.0f/ size));

            System.out.println(key + " " + value);
        }

    }
}
