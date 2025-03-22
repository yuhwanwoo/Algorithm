package programmers.year2023.lv1;

public class _12916 {
    public static void main(String[] args) {
        String s = "pPoooyY";
        solution(s);
    }

    static boolean solution(String s) {
        int cntP = 0;
        int cntY = 0;

        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if (Character.toLowerCase(now) == 'p') {
                cntP += 1;
            }
            if (Character.toLowerCase(now) == 'y') {
                cntY += 1;
            }
        }

        return cntP == cntY;
    }
}
