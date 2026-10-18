package programmers.year2026.hkr.medium;

import java.util.List;

public class LarrysArray {
    static void main() {
        System.out.println("larrysArray(List.of()) = " + larrysArray(List.of(3, 1, 2)));
        System.out.println("larrysArray(List.of()) = " + larrysArray(List.of(1, 3, 4, 2)));
        System.out.println("larrysArray(List.of()) = " + larrysArray(List.of(1, 2, 3, 5, 4)));
    }

    public static String larrysArray(List<Integer> A) {
        // Write your code here
        for (int i = 0; i < A.size() - 2; i++) {
            for (int j = i; j < i + 3; j++) {
                System.out.println("j = " + j);
            }
        }
        return "YES";
    }
}
