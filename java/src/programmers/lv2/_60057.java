package programmers.lv2;

public class _60057 {
    public static void main(String[] args) {
        String s = "aabbaccc";

        solution(s);
    }

    public static int solution(String s) {
        int answer = 0;
        int size = s.length();

        for (int i = 1; i < size / 2; i++) {
            comp(s, i);
        }

        return answer;
    }

    private static String comp(String s, int i) {
        String com_str = "";




        return com_str;
    }
}
