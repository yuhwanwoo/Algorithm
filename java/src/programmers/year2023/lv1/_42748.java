package programmers.year2023.lv1;

import java.util.Arrays;

public class _42748 {
    public static void main(String[] args) {
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3}, {4,4,1}, {1,7,3}};

        solution(array, commands);
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int[] tmp;
        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int findIdx = commands[i][2];
            tmp = new int[end - start + 1];
            for (int j = 0; j < end - start + 1; j++) {
                tmp[j] = array[start - 1 + j];
            }
            Arrays.sort(tmp);
            answer[i] = tmp[findIdx - 1];
        }
        return answer;
    }
}
