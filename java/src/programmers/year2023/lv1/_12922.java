package programmers.year2023.lv1;

public class _12922 {
    public static void main(String[] args) {

    }

    public static String solution(int n) {
        String[] arr = {"수", "박"};
        String answer = "";

        for (int i = 0; i < n; i++) {
            answer += arr[i % 2];
        }
        return answer;
    }
}
