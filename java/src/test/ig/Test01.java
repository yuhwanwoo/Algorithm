package test.ig;

public class Test01 {
    public static void main(String[] args) {
        int A = 3;
        int B = 7;

        System.out.println("B = " + B);
        solution(A, B);
    }

    public static int solution(int A, int B) {
        long sum = A * B;
        int answer = 0;

        String sumToBinaryString = Long.toBinaryString(sum);

        for (int i = 0; i < sumToBinaryString.length(); i++) {
            char c = sumToBinaryString.charAt(i);
            if (c == '1') {
                answer++;
            }
        }

        return answer;
    }
}
