package programmers.year2023.lv1;

import java.util.Arrays;

public class _12982 {
    public static void main(String[] args) {
        int[] d = {1,3,2,5,4};
        int budget = 9;
        solution(d, budget);
    }


    public static int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for (int i = 0; i < d.length; i++) {
            int now = d[i];
            if (budget >= now) {
                answer += 1;
                budget -= now;
            } else {
                break;
            }
        }

        return answer;
    }
}
