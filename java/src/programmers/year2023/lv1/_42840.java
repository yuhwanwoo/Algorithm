package programmers.year2023.lv1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _42840 {
    public static void main(String[] args) {
        int[] answers = {1, 2, 3, 4, 5};

        solution(answers);
    }

    public static int[] solution(int[] answers) {
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        Pair pair1 = new Pair(1, 0);
        Pair pair2 = new Pair(2, 0);
        Pair pair3 = new Pair(3, 0);

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == first[(first.length + i) % first.length]) {
                pair1.correctProblem++;
            }
            if (answers[i] == second[(second.length + i) % second.length]) {
                pair2.correctProblem++;
            }
            if (answers[i] == third[(third.length + i) % third.length]) {
                pair3.correctProblem++;
            }
        }

        List<Pair> answerList = Arrays.asList(pair1, pair2, pair3);
        Collections.sort(answerList);
        return answerList.stream().filter(ans -> answerList.get(0).correctProblem == ans.correctProblem)
                .map(map -> map.num).mapToInt(Integer::intValue).toArray();
    }

    private static class Pair implements Comparable<Pair> {
        int num;
        int correctProblem;

        public Pair(int num, int correctProblem) {
            this.num = num;
            this.correctProblem = correctProblem;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.correctProblem == o.correctProblem) {
                return this.num - o.num;
            }
            return o.correctProblem - this.correctProblem;
        }
    }
}
