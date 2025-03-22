package programmers.lv2;

public class _87390_ans2 {
    public static void main(String[] args) {

    }

    private static int[] solution(int n, long left, long right) {
        int len = (int) (right - left);  // 변환할 숫자의 개수
        int[] answer = new int[len + 1]; // 변환된 숫자를 저장할 배열
        int idx = 0; // answer 배열의 위치 인덱스

        // left부터 right까지의 숫자들에 대해 반복
        for (long i = left; i <= right; i++) {
            long row = i / n; // 현재 숫자의 행 번호
            long col = i % n; // 현재 숫자의 열 번호

            // 행과 열 중 더 큰 값에 1 더하여 저장
            answer[idx++] = Math.max((int) row, (int) col) + 1;
        }

        return answer;
    }
}
