package programmers.lv2;

import java.util.*;

public class _258711_ans {
    static final int M = 1_000_000;

    static int[] indeg = new int[M+1];
    static int[] outdeg = new int[M+1];

    static Map<Integer, List<Integer>> graph = new HashMap<>();

    static int origin, donut, stick, eight;

    public int[] solution(int[][] edges) {
        for (int[] e: edges) {
            int v1 = e[0];
            int v2 = e[1];
            outdeg[v1]++;
            indeg[v2]++;
            if (!graph.containsKey(v1)) {
                graph.put(v1, new ArrayList<>());
            }
            graph.get(v1).add(v2);
        }

        for (int i=1; i<=M; i++) {
            if (indeg[i] == 0 && outdeg[i] >= 2) {
                origin = i;
                break;
            }
        }

        for (int s: graph.get(origin)) {
            // 탐색 시작 지점이 막대 그래프의 끝
            if (outdeg[s] == 0) {
                stick++;
                continue;
            }

            int v = graph.get(s).get(0);
            while (true) {
                if (outdeg[v] == 0) {
                    stick++;
                    break;
                }
                if (outdeg[v] == 2) {
                    eight++;
                    break;
                }
                if (v == s) {
                    donut++;
                    break;
                }

                v = graph.get(v).get(0);
            }
        }

        return new int[] {origin, donut, stick, eight};
    }
}
