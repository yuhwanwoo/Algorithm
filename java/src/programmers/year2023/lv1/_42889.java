package programmers.year2023.lv1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class _42889 {
    public static void main(String[] args) {
//        int N = 5;
//        int[] stages ={2, 1, 2, 6, 2, 4, 3, 3};

//        int N = 4;
//        int[] stages ={4,4,4,4,4};

        int N = 2;
        int[] stages ={1};
        solution(N, stages);
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int size = stages.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            map.put(i, 0);
        }

        for (int stage : stages) {
            map.put(stage, map.get(stage) + 1);
        }
        ArrayList<Failure> answerList = new ArrayList<>();
        for (int i = 0; i < N; i++) {

            answerList.add(new Failure(size != 0 ? (float) map.get(i + 1)/size : 0,i + 1));
            size -= map.get(i + 1);
        }
        Collections.sort(answerList);
        for (int i = 0; i < answerList.size(); i++) {
            Failure failure = answerList.get(i);
            answer[i] = failure.stage;
            System.out.println("i: " + i + ", stage = " + failure.stage);
            System.out.println("failure.percent = " + failure.percent);
            System.out.println("=====================================");
        }
        return answer;
    }

    private static class Failure implements Comparable<Failure> {
        float percent;
        int stage;

        public Failure(float percent, int stage) {
            this.percent = percent;
            this.stage = stage;
        }

        @Override
        public int compareTo(Failure f) {
            if (f.percent == this.percent) {
                return this.stage - f.stage;
            }
            return f.percent > this.percent ? 1 : -1;
        }
    }
}
