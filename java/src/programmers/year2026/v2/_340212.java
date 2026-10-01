package programmers.year2026.v2;

public class _340212 {
    static void main() {
        int[] diffs = {1, 5, 3};
        int[] times = {2, 4, 7};
        long limit = 30;
        solution(diffs, times, limit);
    }

    public static int solution(int[] diffs, int[] times, long limit) {
        int min = 1;
        int max = 100000;
        int answer = 100000;
        while (min < max) {
            int mid = (min + max) / 2;
            int totalTime = 0;
            for (int i = 0; i < diffs.length; i++) {
                if (diffs[i] > mid) {
                    totalTime += ((diffs[i] - mid) * (times[i - 1] + times[i]));
                }
                totalTime += times[i];

                if (limit < totalTime) {
                    max = mid;
                } else {
                    min = mid + 1;
                    answer = mid;
                }
            }
        }
        System.out.println("answer = " + answer);
        return answer;
    }
}
