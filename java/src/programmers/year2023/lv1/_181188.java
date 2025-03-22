package programmers.year2023.lv1;

import java.util.Arrays;

public class _181188 {
    public static void main(String[] args) {
//        int[][] targets = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};
//        int[][] targets = {{1,14},{3,5},{4,7},{6,8},{6,10}};
        int[][] targets = {{1,14}};
        solution(targets);
    }

    public static int solution(int[][] targets) {
        int answer = 1;
        int length = targets.length;

        Arrays.sort(targets, ((o1, o2) -> o1[0] != o2[0] ? o1[0]-o2[0] : o1[1]-o2[1]));
        int idx = 1;
        int prevTargetStart = targets[0][0];
        int prevTargetEnd = targets[0][1];

        while (idx < length) {
            int[] target = targets[idx];
            int start = target[0];
            int end = target[1];
            System.out.println("prevTargetStart = " + prevTargetStart + ", prevTargetEnd:" + prevTargetEnd);
            if (prevTargetEnd > start) {
                prevTargetStart = Math.max(start, prevTargetStart);
                prevTargetEnd = Math.min(end, prevTargetEnd);
            } else {
                prevTargetStart = start;
                prevTargetEnd = end;
                answer++;
            }
            idx++;
        }
        System.out.println("answer = " + answer);

        return answer;
    }
}
