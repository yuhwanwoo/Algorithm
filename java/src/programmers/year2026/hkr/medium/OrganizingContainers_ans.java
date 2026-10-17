package programmers.year2026.hkr.medium;

import java.util.*;

public class OrganizingContainers_ans {
    public static String organizingContainers(List<List<Integer>> container) {
        long[] rowSum = new long[container.size()];
        long[] colSum = new long[container.size()];

        for(int i=0; i<container.size(); i++) {
            List<Integer> row = container.get(i);
            for(int j=0; j<container.size(); j++) {
                rowSum[i] += (long)row.get(j);
                colSum[j] += (long)row.get(j);
            }
        }

        Arrays.sort(rowSum);
        Arrays.sort(colSum);

        for(int i=0; i<container.size(); i++) {
            if(rowSum[i] != colSum[i]) {
                return "Impossible";
            }
        }

        return "Possible";
    }
}
