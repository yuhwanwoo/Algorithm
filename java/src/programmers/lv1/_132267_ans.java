package programmers.lv1;

public class _132267_ans {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n / a > 0) {
            answer += n / a * b;
            n = n / a * b + n % a;
        }
        return answer;
    }
}
