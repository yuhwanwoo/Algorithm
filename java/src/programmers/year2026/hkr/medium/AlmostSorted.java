package programmers.year2026.hkr.medium;

import java.util.ArrayList;
import java.util.List;

public class AlmostSorted {
    static void main() {
        /*
        1 10 3 4 5 6 7 2 13

         */
//        almostSorted(new ArrayList<>(List.of(2,4)));
//        almostSorted(new ArrayList<>(List.of(1, 10, 3, 4, 5, 6, 7, 2, 13)));
//        almostSorted(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 13, 10)));
        almostSorted(new ArrayList<>(List.of(1, 5, 4, 3, 2, 6)));
    }

    public static void almostSorted(List<Integer> arr) {
        // Write your code here
        if (isSorted(arr)) {
            System.out.println("yes");
            return;
        }
        int start = -1;
        int end = -1;
        for (int i = 1; i < arr.size(); i++) {
            int prev = arr.get(i - 1);
            int next = arr.get(i);
            if (prev > next) {
                if (start == -1) {
                    start = i - 1;
                }
                end = i;
            }
        }
        swap(arr, start, end);
        if (isSorted(arr)) {
            System.out.println("yes");
            System.out.println("swap " + (start + 1) + " " + (end + 1));
            return;
        }
        swap(arr, start, end);
        reverse(arr, start, end);
        if (isSorted(arr)) {
            System.out.println("yes");
            System.out.println("reverse " + (start + 1) + " " + (end + 1));
            return;
        }

        System.out.println("no");
    }

    private static boolean isSorted(List<Integer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i - 1) > arr.get(i)) {
                return false;
            }
        }
        return true;
    }

    private static void swap(List<Integer> arr, int idxA, int idxB) {
        int tmp = arr.get(idxA);
        arr.set(idxA, arr.get(idxB));
        arr.set(idxB, tmp);
    }

    private static void reverse(List<Integer> arr, int idxA, int idxB) {
        while (idxA < idxB) {
            swap(arr, idxA, idxB);
            idxA++;
            idxB--;
        }
    }

}
