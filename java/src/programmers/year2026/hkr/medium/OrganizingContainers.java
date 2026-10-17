package programmers.year2026.hkr.medium;

import java.util.HashMap;
import java.util.List;

public class OrganizingContainers {
    static void main() {
        System.out.println(organizingContainers(List.of(List.of(1, 1), List.of(1, 1))));
        /*
        1 3 1
        2 1 2
        3 3 3
         */
        System.out.println(organizingContainers(List.of(List.of(1, 3, 1), List.of(2, 1, 2), List.of(3, 3, 3))));
        System.out.println(organizingContainers(List.of(List.of(0, 2, 1), List.of(1, 1, 1), List.of(2, 0, 0))));
    }

    public static String organizingContainers(List<List<Integer>> container) {
        // Write your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = container.size();
        for (int i = 0; i < n; i++) {
            map.put(i, 0);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < container.get(i).size(); j++) {
                map.put(j, map.get(j) + container.get(i).get(j));
            }
        }
        System.out.println("map = " + map);
        for (int i = 0; i < n; i++) {
            if (map.get(i) != n) {
                return "Impossible";
            }
        }

        return "Possible";
    }
}
