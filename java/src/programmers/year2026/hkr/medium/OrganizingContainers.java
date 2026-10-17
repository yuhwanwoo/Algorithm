package programmers.year2026.hkr.medium;

import java.util.Arrays;
import java.util.List;

public class OrganizingContainers {
    static void main() {
        System.out.println(organizingContainers(List.of(List.of(1, 1), List.of(1, 1))));
        /*
        1 3 1
        2 1 2
        3 3 3
         */
        System.out.println(organizingContainers(List.of(
                List.of(1, 3, 1),
                List.of(2, 1, 2),
                List.of(3, 3, 3))));
        System.out.println(organizingContainers(
                List.of(
                        List.of(0, 2, 1),
                        List.of(1, 1, 1),
                        List.of(2, 0, 0)))
        );
    }

    public static String organizingContainers(List<List<Integer>> container) {
        // Write your code here
        int n = container.size();

        long[] boxCapacity = new long[n];
        long[] ballTypeCount = new long[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long count = container.get(i).get(j);
                boxCapacity[i] += count;
                ballTypeCount[j] += count;
            }
        }

        Arrays.sort(boxCapacity);
        Arrays.sort(ballTypeCount);

        for (int i = 0; i < n; i++) {
            if (boxCapacity[i] != ballTypeCount[i]) {
                return "Impossible";
            }
        }

        return "Possible";
    }
}
