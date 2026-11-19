package programmers.lv2;

import java.util.*;

public class _468373_ans {
    static class Pipe {
        int u, v, type;
        boolean open;
        Pipe(int u, int v, int type) {
            this.u = u;
            this.v = v;
            this.type = type;
        }
    }

    static List<Pipe>[] graph;
    static List<Pipe>[] byType;
    static Queue<Integer> bfsQ;
    static int[] openOrder;  // 파이프를 여는 순서
    static int N, K, infection, maxAnswer;
    static boolean[] visited;

    static void bfs() {
        // 현재 감염된 노드를 모두 큐에 넣음
        for (int i = 1; i <= N; i++) {
            if (visited[i]) bfsQ.offer(i);
        }

        while (!bfsQ.isEmpty()) {
            int cur = bfsQ.poll();
            visited[cur] = true;

            for (Pipe p : graph[cur]) {
                if (!p.open) continue;

                int next = (p.u == cur) ? p.v : p.u;
                if (visited[next]) continue;

                visited[next] = true;
                bfsQ.offer(next);
            }
        }
    }

    static int check() {
        bfsQ = new ArrayDeque<>();
        bfsQ.offer(infection);  // 최초 감염 처리
        visited = new boolean[N + 1];
        visited[infection] = true;

        for (int type : openOrder) {
            // 해당 순서 파이프 열기
            for (Pipe p : byType[type]) p.open = true;

            bfs();

            // 해당 순서 파이프 닫기
            for (Pipe p : byType[type]) p.open = false;
        }

        // 감염된 노드 개수 구하기
        int total = 0;
        for (int i = 1; i <= N; i++) {
            if (visited[i]) total++;
        }

        return total;
    }

    static void dfs(int idx) {
        if (idx == K) {
            maxAnswer = Math.max(maxAnswer, check());
            return;
        }

        for (int type = 1; type <= 3; type++) {
            openOrder[idx] = type;
            dfs(idx + 1);
        }
    }

    public int solution(int n, int infection, int[][] edges, int k) {
        N = n;
        K = k;
        _468373_ans.infection = infection;

        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        byType = new List[4];
        for (int i = 1; i <= 3; i++) {
            byType[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int x = edge[0], y = edge[1], type = edge[2];
            // 같은 Pipe 객체를 참조
            Pipe p = new Pipe(x, y, type);
            graph[x].add(p);
            graph[y].add(p);
            byType[type].add(p);
        }

        openOrder = new int[k];
        maxAnswer = -1_000_000_000;
        dfs(0);

        return maxAnswer;
    }
}
