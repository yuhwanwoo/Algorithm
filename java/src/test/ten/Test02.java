package test.ten;

import java.util.HashMap;

public class Test02 {
    static HashMap<String, Boolean> watched = new HashMap<>();
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) {
        int n = 10;
        int m = 7;
        String[] friends = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        String[][] movies = {{"a", "c", "d", "h", "i", "j"}, {"a", "d", "i"}, {"a", "c", "f", "g", "h", "i", "j"},
                {"b", "d", "g"}, {"b", "c", "f", "h", "i"}, {"b", "e", "g", "j"}, {"b", "c", "g", "h", "i"}};
        solution(n, m, friends, movies);
    }

    private static int solution(int n, int m, String[] friends, String[][] movies) {

        for (String friend : friends) {
            watched.put(friend, false);
        }
        visited = new boolean[movies.length];
        dfs(0, movies);
        System.out.println("answer = " + answer);
        return answer;
    }

    private static void dfs(int depth, String[][] movies) {
        boolean flag = true;
        for (String key : watched.keySet()) {
            if (!watched.get(key)) {
                flag = false;
                break;
            }
        }
        if (flag) {
            for (int i = 0; i < visited.length; i++) {
                System.out.print(visited[i] + " ");
            }
            System.out.println();
            answer += 1;
        }
        if (depth == movies.length) {
            return;
        }

        dfs(depth + 1, movies);

        if (!visited[depth]) {
            visited[depth] = true;
            for (int j = 0; j < movies[depth].length; j++) {
                String friend = movies[depth][j];
                watched.put(friend, true);
            }
            dfs(depth + 1, movies);
            visited[depth] = false;
        }

    }
}
