package test.bra;

import java.util.HashMap;

public class Test03 {
    public static void main(String[] args) {
        int n = 0;

        solution(n);
    }

    private static int solution(int n) {
        int answer = 0;
        HashMap<Integer, Integer> cntSegment = new HashMap<>();
        cntSegment.put(0, 6);
        cntSegment.put(1, 2);
        cntSegment.put(2, 5);
        cntSegment.put(3, 5);
        cntSegment.put(4, 4);
        cntSegment.put(5, 5);
        cntSegment.put(6, 6);
        cntSegment.put(7, 4);
        cntSegment.put(8, 7);
        cntSegment.put(9, 6);


        for (int i = 0; i < 10; i++) {
            for (int k = 0; k < 10; k++) {
                for (int l = 0; l < 10; l++) {
                    if ( (i + k) == l && cntSegment.get(i) + cntSegment.get(k) + cntSegment.get(l) + 2 == n
                    ) {
                        answer++;
                    }

                    if ( (i - k) == l && cntSegment.get(i) + cntSegment.get(k) + cntSegment.get(l) + 1 == n
                    ) {
                        answer++;
                    }

                    if ( k != 0 && (i / k) == l && cntSegment.get(i) + cntSegment.get(k) + cntSegment.get(l) + 1 == n
                    ) {
                        answer++;
                    }

                    if ( (i * k) == l && cntSegment.get(i) + cntSegment.get(k) + cntSegment.get(l) + 2 == n
                    ) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}
