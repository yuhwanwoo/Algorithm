package test.tren;

import java.util.HashMap;

public class exam03 {
    public static void main(String[] args) {
//        int[] arr = {2,1,3,1,4,2,1,3};
        int[] arr = {1,2,3};

        System.out.println(solution(arr));
    }
    public static int solution(int[] arr) {
        int answer = 1000000;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int now = arr[i];
            if (map.containsKey(now)) {
                answer = Math.min(answer, i - map.get(now));
            }

            map.put(now, i);
        }

        return answer == 1000000 ? -1 : answer;
    }


}
