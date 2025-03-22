package programmers.year2023.lv1;

public class _12928 {
    public static void main(String[] args) {
        solution(16);
    }

    public static int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0){
                if (i == n / i) {
                    answer += i;
                } else {
                    answer += i;
                    answer += (n / i);
                }
            }
        }
        System.out.println("answer = " + answer);

        return answer;
    }
}
