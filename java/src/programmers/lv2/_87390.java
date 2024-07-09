package programmers.lv2;

public class _87390 {
    public static void main(String[] args) {
        solution(3, 2, 5);
    }

    public static int[] solution(int n, long left, long right) {
        int size = (int) (right - left + 1);
        int[] answer = new int[size];
        int idx = 0;

        for (long i = left; i <= right; i++) {
            long row = i / n;
            long col = i % n;

            answer[idx++] = (int) Math.max(row, col) + 1;
        }

        return answer;
    }
}
