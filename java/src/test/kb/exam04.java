package test.kb;

import java.util.ArrayList;
import java.util.HashMap;

public class exam04 {
    public static void main(String[] args) {
        int[][] tower = {{0,2},{2,3},{3,2},{5,3},{6,2},{7,3},{9,4},{10,2},{11,2},{12,4},{14,2},{15,3},{16,2}};
        int k = 3;

        solution(tower, k);
    }

    public static int solution(int[][] tower, int k) {
        int answer = 0;

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < tower.length; i++) {
            int idx = tower[i][0];
            int height = tower[i][1];
            if (!map.containsKey(height)) {
                map.put(height, new ArrayList<Integer>());
            }
            map.get(height).add(idx);

        }

        for (Integer key : map.keySet()) {
            System.out.println("key = " + key);
            answer += 1;
            int pre_idx = map.get(key).get(0);
            for (int i = 1; i < map.get(key).size(); i++) {
                int now = map.get(key).get(i);
                if (now - pre_idx <= k) {
                    System.out.print(now + " ");
                    pre_idx = now;
                    continue;
                }
                answer += 1;

                pre_idx = now;
            }
        }
        System.out.println();
        System.out.println(answer);

        return answer;
    }
}
