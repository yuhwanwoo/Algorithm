package test.toss;

import java.util.HashMap;

public class exam05 {
    public static void main(String[] args) {
//        int[] tasks = {1,1,2,3,3,2,2};
        int[] tasks = {4,1,1,1,1,2,3};

        System.out.println("solution(tasks) = " + solution(tasks));
    }

    private static int solution(int[] tasks) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int[] twoArr;
        int[] threeArr;

        boolean[] arr = new boolean[1000000001];
        arr[0] = false;
        arr[1] = false;
        arr[2] = true;
        arr[3] = true;



        for (int i = 0; i < tasks.length; i++) {
            int key = tasks[i];
            if (!map.containsKey(key)) {
                map.put(key, 0);
            }
            map.put(key, map.get(key) + 1);
        }

        int answer = 0;

        for (Integer key : map.keySet()) {
            int value = map.get(key);
            if (value % 2 == 0 || value % 3 == 0) {
                if (value % 3 == 0) {
                    answer += value / 3;
                } else {
                    answer += value / 2;
                }
            } else {
                return -1;
            }
        }

        return answer;
    }
}
