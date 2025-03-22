package programmers.year2023.lv1;

public class _12931 {
    public static void main(String[] args) {
        solution(987);
    }
    public static int solution(int n) {
        int answer = 0;

        while (n != 0) {
            answer += (n % 10);
            n /= 10;
        }
        System.out.println("answer = " + answer);

        return answer;
    }
}
