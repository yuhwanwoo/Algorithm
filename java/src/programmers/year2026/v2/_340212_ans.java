package programmers.year2026.v2;

public class _340212_ans {
    public int solution(int[] diffs, int[] times, long limit) {
        int minLev = 1;
        int maxLev = 100_000;
        int answer = maxLev;

        while (minLev < maxLev) {
            int midLev = (minLev + maxLev) / 2;

            if (isPossibleSolve(diffs, times, midLev, limit)) {
                maxLev = midLev;
                answer = Math.min(answer, midLev);
            }
            else {
                minLev = midLev + 1;
            }
        }
        return answer;
    }

    private boolean isPossibleSolve(int[] diffs, int[] times, int lev, long limit) {
        long totalTime = 0;
        int prevTime = 0;

        for (int i = 0; i < diffs.length; i++) {
            if (lev < diffs[i]) {
                totalTime += (long)(prevTime + times[i]) * (diffs[i] - lev);
            }

            totalTime += times[i];
            prevTime = times[i];

            if (limit < totalTime) return false;
        }
        return true;
    }
}
