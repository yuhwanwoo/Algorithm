package test.tredr;
import java.util.ArrayList;
import java.util.LinkedList;
public class Test02 {
    public static void main(String[] args) {
        int[][] relation = {
                {1, 2},
                {2, 5},
                {2, 6},
                {1, 3},
                {1, 4},
                {3, 7}
        };

        String[] dirname = {"root", "abcd", "cs", "hello", "etc", "hello", "solution"};
        System.out.println(solution(7, relation, dirname));

    }

    private static ArrayList<Integer>[] a;
    private static boolean[] visited;
    private static LinkedList<Integer> list = new LinkedList<>();
    private static long max = Integer.MIN_VALUE;

    public static int solution(int N, int[][] relation, String[] dirname) {
        a = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) a[i] = new ArrayList<>();

        for (int[] r : relation) {
            int parent = r[0], child = r[1];
            a[parent].add(child);
        }

        list.add(1);
        dfs(1, dirname);
        return (int)max;
    }

    private static void dfs(int v, String[] dirname) {
        if (visited[v]) return;

        visited[v] = true;
        if (a[v].size() == 0) {
            getResult(dirname);
            return;
        }

        for (int vv : a[v]) {
            if (!visited[vv]) {
                list.add(vv);
                dfs(vv, dirname);
                list.removeLast();
            }
        }
        visited[v] = false;
    }

    private static void getResult(String[] dirname) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(dirname[list.get(i) - 1]);
            if (i != list.size() - 1) sb.append('/');
        }

        max = Math.max(max, sb.toString().length());
    }
}
