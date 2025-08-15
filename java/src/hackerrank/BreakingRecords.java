package hackerrank;

import java.util.List;

public class BreakingRecords {

    public static void main(String[] args) {
        breakingRecords(List.of(10, 5, 20, 20, 4, 5, 2, 25, 1));
    }

    public static List<Integer> breakingRecords(List<Integer> scores) {
        // Write your code here
        int maxCount = 0;
        int minCount = 0;
        int initMax = scores.get(0);
        int initMin = scores.get(0);

        for (Integer score : scores) {
            if (score > initMax) {
                maxCount += 1;
                initMax = score;
            }
            if (score < initMin) {
                minCount += 1;
                initMin = score;
            }
        }

        return List.of(maxCount, minCount);
    }
}
