package programmers.year2023.lv1;

public class _17682 {
    public static void main(String[] args) {

    }

    public static int solution(String dartResult) {
        int answer = 0;
        int tmp = -1;
        for (int i = 0; i < dartResult.length(); i++) {
            char input = dartResult.charAt(i);
            if (Character.isDigit(input)) {
                if (tmp != -1) {
                    tmp *= 10;
                    tmp += Integer.valueOf(input);
                } else {
                    tmp = Integer.valueOf(input);
                }
            } else if (input == 'S' || input == 'D' || input == 'T') {
                if (input == 'D') {
                    tmp = tmp * tmp;
                }
                if (input == 'T') {
                    tmp = tmp * tmp * tmp;
                }
            } else if (input == '*' || input == '#') {
                if (input == '*') {
                    tmp *= 2;
                }
                if (input == '#') {
                    tmp *= -1;
                }
            }
        }

        return answer;
    }
}
