package programmers.lv2;

public class _468372_ans {
    int answer = 1;

    public int solution(int dist_limit, int split_limit) {
        answer = 1;
        dfs(1, 1, 1, 0, dist_limit, split_limit);
        return answer;
    }

    // cur : 현재 깊이에서 분배 가능한 노드 수
    // used : 지금까지 사용한 분배 노드 수
    // split : 현재 깊이까지의 분배도 곱
    // leaf : 지금까지의 확정된 리프 수
    void dfs(long cur, long used, long split, long leaf, int distLimit, int splitLimit) {

        if (used > distLimit) return;

        // 지금 멈추면 남은 노드는 전부 리프
        answer = (int)Math.max(answer, leaf + cur);

        // 자식 수 결정 (2 또는 3)
        for (int child = 2; child <= 3; child++) {

            long nextSplit = split * child;
            if (nextSplit > splitLimit) continue;

            // 이번  depth에서 새로 생기는 노드 수
            long nextNodes = cur * child;

            // 남은 분배 노드
            long remain = distLimit - used;

            // 다음 depth로 넘길 분배 노드는 최대한 많이
            long nextCur = Math.min(nextNodes, remain);

            // 넘기지 못한 노드는 리프 확정
            long nextLeaf = leaf + (nextNodes - nextCur);

            dfs(nextCur, used + nextCur, nextSplit, nextLeaf, distLimit, splitLimit);
        }
    }
}
