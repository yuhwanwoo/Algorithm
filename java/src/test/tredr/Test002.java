package test.tredr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Test002 {
    private static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    private static LinkedList<Integer> nameList = new LinkedList<>();
    private static int answer = 0;

    public static void main(String[] args) {
        int n = 7;
        int[][] relation = {
                {1, 2},
                {2, 5},
                {2, 6},
                {1, 3},
                {1, 4},
                {3, 7}
        };
        String[] dirname = {"root", "abcd", "cs", "hello", "etc", "hello", "solution"};
        solution(n, relation, dirname);
    }

    public static int solution(int N, int[][] relation, String[] dirname) {
        for (int i = 1; i <= N; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] element : relation) {
            int from = element[0];
            int to = element[1];
            map.get(from).add(to);
        }
        nameList.add(1);
        dfs(1, dirname);

        System.out.println("answer = " + answer);
        return answer;
    }

    private static void dfs(int depth, String[] dirname) {
        if (map.get(depth).size() == 0) {
            StringBuilder dir  = new StringBuilder();
            int size = nameList.size();
            for (int i = 0; i < size; i++) {
                int idx = nameList.get(i);
                dir.append(dirname[idx - 1]);
                if (i != size - 1) {
                    dir.append("/");
                }
            }

            answer = Math.max(answer, dir.length());
            return;
        }

        for (int i = 0; i < map.get(depth).size(); i++) {
            int top = map.get(depth).get(i);
            nameList.add(top);
            dfs(top, dirname);
            nameList.removeLast();
        }
    }
}
