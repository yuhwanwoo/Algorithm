package hackerrank;

import java.util.Arrays;
import java.util.List;

public class OrganizingContainersOfBalls_ans1 {
    public static void main(String[] args) {

    }

    public static String organizingContainers(List<List<Integer>> container) {
        // Write your code here
        long[] rowSum = new long[container.size()];
        long[] colSum = new long[container.size()];

        for (int i = 0; i < container.size(); i++) {
            List<Integer> row = container.get(i);
            for (int j = 0; j < container.size(); j++) {
                rowSum[i] += (long) row.get(j);
                colSum[j] += (long) row.get(j);
            }
        }

        Arrays.sort(rowSum);
        Arrays.sort(colSum);

        for (int i = 0; i < container.size(); i++) {
            if (rowSum[i] != colSum[i]) {
                return "Impossible";
            }
        }

        return "Possible";
    }
}
