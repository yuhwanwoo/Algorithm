package programmers.lv2;

import java.util.Arrays;

public class _181188_fail {
    public static void main(String[] args) {
        int[][] targets = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};
        solution(targets);
    }

    public static int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        int start = targets[0][1];
        int answer = 1;

        for (int[] target : targets) {
            if (target[1] > start) {
                start = target[1];
                answer++;
            }
        }
        System.out.println("answer = " + answer);

        return answer;
    }
}
