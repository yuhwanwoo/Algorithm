package programmers.year2026.hkr.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class JourneyToMoon {
    static int[] parent;
    static void main() {
        journeyToMoon(5, List.of(List.of(0, 1), List.of(2, 3), List.of(0, 4)));
        journeyToMoon(4, List.of(List.of(0, 2)));
    }

    public static int journeyToMoon(int n, List<List<Integer>> astronaut) {
        // Write your code here
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < astronaut.size(); i++) {
            List<Integer> countryMember = astronaut.get(i);
            Integer a = countryMember.get(0);
            Integer b = countryMember.get(1);
            union(a, b);
        }
        for (int i : parent) {
            System.out.println("i = " + i);
        }
        System.out.println("===========");

        int[] countArr = new int[n];
        for (int i = 0; i < n; i++) {
            int p = findParent(i);
            countArr[p]++;
        }

        long totalPairs = 0;
        long accumulatedSize = 0;

        for (int size : countArr) {
            if (size > 0) {
                totalPairs += accumulatedSize * size;
                accumulatedSize += size;
            }
        }

        return (int) totalPairs;
    }

    public static int findParent(int x) {
        if (parent[x] == x) return x;
        parent[x] = findParent(parent[x]);
        return parent[x];
    }

    public static void union(int a, int b) {
        int parentA = findParent(a);
        int parentB = findParent(b);
        if (parentA < parentB) {
            parent[parentB] = parentA;
        } else {
            parent[parentA] = parentB;
        }
    }

}
