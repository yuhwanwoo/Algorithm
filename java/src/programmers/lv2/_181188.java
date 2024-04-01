package programmers.lv2;

import java.util.Arrays;

public class _181188 {
    public static void main(String[] args) {
        int[][] targets = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};
        solution(targets);
    }

    public static int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);

        int start = 0;
        for (int[] target : targets) {
            if (start <= target[0]) {
                start = target[1];
                answer++;
            }
        }
        return answer;
    }
}
