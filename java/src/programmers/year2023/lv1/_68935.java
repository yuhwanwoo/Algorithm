package programmers.year2023.lv1;

public class _68935 {
    public static void main(String[] args) {
        int n = 125;
        solution(n);
    }

    public static int solution(int n) {
        int answer = 0;

        String[] num = Integer.toString(n, 3).split("");
        for (int i = 0; i < num.length; i++) {
            double tmp = Integer.parseInt(num[i]) * Math.pow(3, i);
            answer += tmp;
        }

        return answer;
    }
}
