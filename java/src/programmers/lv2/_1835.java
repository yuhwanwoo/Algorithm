package programmers.lv2;

import java.util.ArrayList;

public class _1835 {
    private static ArrayList<Character> line = new ArrayList<>();
    private static char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    private static String[] hints;
    private static boolean[] visited;
    private static int answer = 0;

    public static void main(String[] args) {
//        String[] data = {"N~F=0", "R~T>2"};
//        solution(2, data);
        String[] data = {"M~C<2", "C~M>1"};
        solution(2, data);
    }

    public static int solution(int n, String[] data) {
        hints = new String[data.length];
        visited = new boolean[8];
        for (int i = 0; i < data.length; i++) {
            hints[i] = data[i];
        }

        permutation();

        return answer;
    }

    private static int find(Character ch) {
        return line.indexOf(ch);
    }

    private static void permutation() {
        if (line.size() == 8) {
            if (isAnswer()) {
                answer += 1;
            }
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            line.add(friends[i]);
            permutation();
            line.remove(line.size() - 1);
            visited[i] = false;
        }
    }

    private static boolean isAnswer() {
        for (int i = 0; i < hints.length; i++) {
            int diff = Math.abs(find(hints[i].charAt(0)) - find(hints[i].charAt(2))) - 1;
            int expected = hints[i].charAt(4) - '0';
            char op = hints[i].charAt(3);
            if ((op == '=') && (diff != expected)) {
                return false;
            } else if ((op == '<') && (diff >= expected)) {
                return false;
            } else if ((op == '>') && (diff <= expected)) {
                return false;
            }
        }
        return true;
    }
}
