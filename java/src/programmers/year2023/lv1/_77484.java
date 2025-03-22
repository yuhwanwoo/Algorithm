package programmers.year2023.lv1;

import java.util.HashMap;

public class _77484 {
    public static void main(String[] args) {
//        int[] lottos = {44,1,0,0,31,25};
//        int[] win_nums = {31, 10, 45, 1, 6, 19};

//        int[] lottos = {0,0,0,0,0,0};
//        int[] win_nums = {38,19,20,40,15,25};

//        int[] lottos = {45,4,35,20,3,9};
//        int[] win_nums = {20,9,3,45,4,35};

        int[] lottos = {21,10,7,46,5,36};
        int[] win_nums = {20,9,3,45,4,35};


        solution(lottos, win_nums);
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int correctCnt = 0;
        int zeroCnt = 0;
        HashMap<Integer, Boolean> win = new HashMap<>();
        for (int lotto : lottos) {
            if (lotto != 0) {
                win.put(lotto, true);
            }
            if (lotto == 0) {
                zeroCnt += 1;
            }
        }
        for (int win_num : win_nums) {
            if (win.containsKey(win_num)) {
                correctCnt += 1;
            }
        }
        System.out.println("correctCnt = " + correctCnt);
        System.out.println("zeroCnt = " + zeroCnt);
        System.out.println("top:" +(7 - correctCnt - zeroCnt));
        System.out.println(":" + (correctCnt >= 2 ? 7 - correctCnt : 6));

        return new int[]{Math.min(7 - correctCnt - zeroCnt, 6), correctCnt >= 2 ? 7 - correctCnt : 6};
    }
}
