package programmers.lv2;

public class _148653_fail {
    public static void main(String[] args) {
        solution(16);
        solution(2554);
        solution(1);
        solution(9);
        solution(555);
        solution(95);
    }

    public static int solution(int storey) {
        int answer = 0;
        int mod;
        while (storey != 0) {
            if (storey % 10 > 5) {
                answer += (10 - (storey % 10));
                mod = 1;
            } else {
                answer += (storey % 10);
                mod = 0;
            }
            storey /= 10;
            storey += mod;
        }
        System.out.println("answer = " + answer);
        return answer;
    }
}
