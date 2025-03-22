package programmers.year2023.lv1;

public class _12943 {
    public static void main(String[] args) {
        int num = 626331;
        solution(num);
    }

    public static int solution(int num) {
        int answer = 0;
        long input = num;
        if (input == 1) {
            return 0;
        }
        while (input != 1) {
            answer += 1;
            if (answer == 500) {
                return -1;
            }

            if (input % 2 == 0) {
                input /= 2;
            } else {
                input *= 3;
                input += 1;
            }
        }
        System.out.println("num = " + num);
        System.out.println("answer = " + answer);
        return answer;
    }
}
