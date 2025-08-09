package test.class101Test;

import java.util.HashMap;

public class exam01 {
    public static void main(String[] args) {
        int X = 7, Y=42;
        int[] A = {6, 42, 11, 7, 1, 42};
        solution(X, Y, A);
        int X1 = 100, Y1=63;
        int[] A1 = {100,63,1,6,2,13};
        solution(X1, Y1, A1);
    }

    private static int solution(int X, int Y, int[] A) {
        int answer = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(X, 0);
        map.put(Y, 0);
        for (int i = 0; i < A.length; i++) {
            if (A[i] == X) {
                map.put(X, map.getOrDefault(X, 0) + 1);
            }
            if (A[i] == Y) {
                map.put(Y, map.getOrDefault(Y, 0) + 1);
            }
            if (map.get(X) == map.get(Y) && map.get(X) != 0) {
                answer = i;
            }
        }
        System.out.println("answer = " + answer);
        return answer;
    }
}
