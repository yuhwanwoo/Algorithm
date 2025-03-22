package test.toss;

public class exam01 {
    public static void main(String[] args) {

//        String

//        System.out.println("sol = " + solution());
    }

    public static int solution(String s) {
        int answer = -1;
        int size = s.length();
        if (size == 0) {
            return -1;
        }
        char now = s.charAt(0);
        int length = 1;
        for (int i = 1; i < size; i++) {
            if (now == s.charAt(i)) {
                length += 1;
                now = s.charAt(i);
            } else {
                now = s.charAt(i);
                length = 1;
            }

            if (length == 3) {
                int intValue = Character.getNumericValue(s.charAt(i));
                answer = Math.max(answer, intValue + intValue * 10 + intValue * 100);
            }
        }

        return answer;
    }
}
