package programmers.year2026.hkr.easy;

import java.util.List;

public class CountApplesAndOranges {
    static void main() {

    }

    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        // 1. 집에 떨어진 사과 개수 구하기
        int appleCount = 0;
        for (int d : apples) {
            int position = a + d; // 사과의 실제 위치
            if (position >= s && position <= t) {
                appleCount++;
            }
        }

        // 2. 집에 떨어진 오렌지 개수 구하기
        int orangeCount = 0;
        for (int d : oranges) {
            int position = b + d; // 오렌지의 실제 위치
            if (position >= s && position <= t) {
                orangeCount++;
            }
        }

        // 3. 결과 출력 (각각 한 줄씩 출력)
        System.out.println(appleCount);
        System.out.println(orangeCount);
    }
}
