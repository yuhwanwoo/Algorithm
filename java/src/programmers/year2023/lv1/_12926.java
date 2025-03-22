package programmers.year2023.lv1;

public class _12926 {
    public static void main(String[] args) {
        String s = "AB";
        int n = 1;
        solution(s, n);
    }

    public static String solution(String s, int n) {
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isAlphabetic(c)) {
                if (Character.isUpperCase(c)) {
                    answer += (char) ('A' + (c - 'A' + n) % 26);
                } else {
                    answer += (char) ('a' + (c - 'a' + n) % 26);
                }
            } else {
                answer += c;
            }
        }

        return answer;
    }
}
