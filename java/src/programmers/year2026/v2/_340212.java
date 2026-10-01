package programmers.year2026.v2;

public class _340212 {
    static void main() {
        int[] diffs = {1, 5, 3};
        int[] times = {2, 4, 7};
        long limit = 30;
        solution(diffs, times, limit);

        int[] diffs1 = {1, 4, 4, 2};
        int[] times1 = {6, 3, 8, 2};
        long limit1 = 59;
        solution(diffs1, times1, limit1);

        int[] diffs2 = {1, 4, 4, 2};
        int[] times2 = {6, 3, 8, 2};
        long limit2 = 59;
        solution(diffs2, times2, limit2);

    }

    public static int solution(int[] diffs, int[] times, long limit) {
        int min = 1;
        int max = 100000;
        int answer = 100000;
        while (min <= max) {
            int mid = (min + max) / 2;
            long totalTime = 0;
            for (int i = 0; i < diffs.length; i++) {
                if (diffs[i] > mid) {
                    totalTime += ((long) (diffs[i] - mid) * (times[i - 1] + times[i]));
                }
                totalTime += times[i];

            }
            if (limit >= totalTime) {
                max = mid - 1;
                answer = mid;
            } else {
                min = mid + 1;
            }
        }
        return answer;
    }
}
