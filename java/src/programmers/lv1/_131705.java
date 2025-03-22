package programmers.lv1;

public class _131705 {
    public static void main(String[] args) {
        int[] number = {-2, 3, 0, 2, -5};
        solution(number);
    }

    public static int solution(int[] number) {
        int answer = 0;
        for (int i = 0; i < number.length - 2; i++) {
            for (int j = i + 1; j < number.length - 1; j++) {
                for (int k = j + 1; k < number.length; k++) {
                    if (number[i] + number[j] + number[k] == 0) {
                        answer += 1;
                    }
                }
            }
        }
        return answer;
    }
}
