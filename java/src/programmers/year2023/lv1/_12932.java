package programmers.year2023.lv1;

public class _12932 {
    public static void main(String[] args) {
        int n = 12345;
        solution(n);
    }

    public static int[] solution(long n) {

        int v = (int) Math.ceil(Math.log10(n));
        int[] answer = new int[v];
        int idx = 0;
        while (v != 0) {
            long num = n % 10;
            System.out.println("num = " + num);
            answer[idx] = (int) num;
            idx++;
            n /= 10;
            v--;
        }
        return answer;
    }
}
