package test.toss2023;

public class Exam01 {
    public static void main(String[] args) {
        String s = "123";
        int N = 2;

        System.out.println("N = " + solution(s, N));
    }

    public static int solution(String s, int N) {
        int answer = -1;
        boolean[] visited;
        int length = s.length();
        if (N == length) {
            visited = new boolean[N + 1];
            answer = getAnswer(s, N, answer, visited, 0);
        }

        for (int i = 0; i <= length - N; i++) {
            visited = new boolean[N + 1];
            answer = getAnswer(s, N, answer, visited, i);
        }

        return answer;
    }

    private static int getAnswer(String s, int N, int answer, boolean[] visited, int i) {
        String num = "";
        for (int j = i; j < i + N; j++) {
            String input = String.valueOf(s.charAt(j));
            num += input;
            int now = Integer.parseInt(input);
            if (1 <= now && now <= N) {
                visited[now] = true;
            }
        }
        int chainNum = Integer.parseInt(num);
        System.out.println("chainNum = " + chainNum);
        for (int j = 1; j <= N; j++) {
            if (!visited[j]) {
                break;
            }
            if (j == N && visited[j]) {
                answer = Math.max(answer, chainNum);
            }
        }
        return answer;
    }
}
