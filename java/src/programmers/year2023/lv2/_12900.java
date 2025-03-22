package programmers.year2023.lv2;

public class _12900 {
    public static void main(String[] args) {
        solution(6000);
    }

    public static int solution(int n) {
        int[] arr = new int[60001];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        for (int i = 4; i < 60001; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println("arr[n] = " + (arr[n] % 1000000007));
        return arr[n] % 1000000007;
    }
}
