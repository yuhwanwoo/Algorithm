package programmers.year2023.lv1;

public class _12918 {
    public static void main(String[] args) {
        String s = "1234";
        System.out.println("solution(s) = " + solution(s));
    }

    public static boolean solution(String s) {
        if (s.length() != 4 && s.length() != 6) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
