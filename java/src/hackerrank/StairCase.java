package hackerrank;

public class StairCase {
    public static void main(String[] args) {
        staircase(3);
    }

    public static void staircase(int n) {
        // Write your code here
        for (int i = 1; i <= n; i++) {
            // 공백 출력
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            // # 출력
            for (int j = 0; j < i; j++) {
                System.out.print("#");
            }
            // 줄바꿈
            System.out.println();
        }
    }
}
